package com.project.repository.impl;

import com.project.domain.entity.UserEntity;
import com.project.filter.Filter;
import com.project.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String FIND_QUERY = "SELECT u FROM UserEntity WHERE u.id = :id";

    private static final String SELECT_ALL = "SELECT u FROM UserEntity WHERE 1 = 1";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getAll(Filter... filters) {
        String dynamicQuery = SELECT_ALL;

        if (filters != null) {
            if (filters[0].getValue() != null) {
                dynamicQuery += "AND c." + filters[0].getField() + " " +
                        filters[0].getOperator() + " '%" + filters[0].getValue() + "%' ";
            }
            if (filters[0].getSort() != null) {
                dynamicQuery += "ORDER BY c." + filters[0].getField() + " " + filters[0].getSort();
            }
            if (filters[0].getPageSize() != null && filters[0].getPageNumber() != null) {
                return entityManager.createQuery(dynamicQuery, UserEntity.class)
                        .setFirstResult((filters[0].getPageNumber() - 1) * filters[0].getPageSize())
                        .setMaxResults(filters[0].getPageSize())
                        .getResultList();
            }
        }
        return entityManager.createQuery(dynamicQuery, UserEntity.class).getResultList();
    }

    @Override
    public UserEntity save(UserEntity user) {
        entityManager.persist(user);
        user.setCreatedDate(LocalDateTime.now());
        user.setLastModified(LocalDateTime.now());
        return user;
    }

    @Override
    public UserEntity update(UserEntity user) {
        entityManager.merge(user);
        user.setLastModified(LocalDateTime.now());
        return user;
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return Optional.of(entityManager.createQuery(FIND_QUERY,UserEntity.class)
                .setParameter("id",id).getSingleResult());
    }

    @Override
    public void softDelete(UserEntity entity) {
        entity.setDeleted(true);
    }

    @Override
    public UserEntity delete(UserEntity user) {
        entityManager.remove(user);
        return user;
    }

    @Override
    public void restore(UserEntity entity) {
        entity.setDeleted(false);
    }
}
