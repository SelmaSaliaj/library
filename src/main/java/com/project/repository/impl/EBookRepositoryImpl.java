package com.project.repository.impl;

import com.project.domain.entity.EBookEntity;
import com.project.filter.Filter;
import com.project.repository.EBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class EBookRepositoryImpl implements EBookRepository {

    private static final String FIND_QUERY = "SELECT e FROM EBookEntity e WHERE e.id = :id";

    private static final String SELECT_ALL = "SELECT e FROM EBookEntity e WHERE 1 = 1";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EBookEntity> getAll(Filter... filters) {
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
                return entityManager.createQuery(dynamicQuery, EBookEntity.class)
                        .setFirstResult((filters[0].getPageNumber() - 1) * filters[0].getPageSize())
                        .setMaxResults(filters[0].getPageSize())
                        .getResultList();
            }
        }
        return entityManager.createQuery(dynamicQuery, EBookEntity.class).getResultList();
    }

    @Transactional
    @Override
    public EBookEntity save(EBookEntity eBook) {
        entityManager.persist(eBook);
        return eBook;
    }

    @Transactional
    @Override
    public EBookEntity update(EBookEntity eBook) {
        entityManager.merge(eBook);
        return eBook;
    }

    @Override
    public Optional<EBookEntity> findById(Integer id) {
        return Optional.of(entityManager.createQuery(FIND_QUERY,EBookEntity.class)
                .setParameter("id",id).getSingleResult());
    }

    @Override
    public void softDelete(EBookEntity entity) {
        entity.setDeleted(true);
    }

    @Transactional
    @Override
    public EBookEntity delete(EBookEntity eBook) {
        entityManager.remove(eBook);
        return eBook;
    }

    @Override
    public void restore(EBookEntity entity) {
        entity.setDeleted(false);
    }
}
