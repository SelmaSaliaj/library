package com.project.repository.impl;

import com.project.domain.entity.UserEntity;
import com.project.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String FIND_QUERY = "SELECT u FROM UserEntity WHERE u.id = :id";

    private static final String GET_ALL_QUERY = "SELECT * FROM UserEntity";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery(GET_ALL_QUERY, UserEntity.class).getResultList();
    }

    @Override
    public UserEntity save(UserEntity user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public UserEntity update(UserEntity user) {
        entityManager.merge(user);
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
