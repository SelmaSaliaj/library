package com.project.repository.impl;

import com.project.domain.entity.ReaderEntity;
import com.project.filter.Filter;
import com.project.helpers.Constant;
import com.project.repository.ReaderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private static final String SELECT_ALL = "SELECT r FROM ReaderEntity r WHERE 1 = 1";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ReaderEntity> getAll(Filter... filters) {
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
                return entityManager.createQuery(dynamicQuery, ReaderEntity.class)
                        .setFirstResult((filters[0].getPageNumber() - 1) * filters[0].getPageSize())
                        .setMaxResults(filters[0].getPageSize())
                        .getResultList();
            }
        }
        return entityManager.createQuery(dynamicQuery, ReaderEntity.class).getResultList();
    }

    @Transactional
    @Override
    public ReaderEntity save(ReaderEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public ReaderEntity update(ReaderEntity entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public ReaderEntity findById(Integer id) {
        return entityManager.createQuery(Constant.SELECT_READER_BY_ID,ReaderEntity.class)
                .setParameter("id",id).getSingleResult();
    }

    @Transactional
    @Override
    public ReaderEntity delete(ReaderEntity entity) {
        entityManager.remove(entity);
        return entity;
    }

}
