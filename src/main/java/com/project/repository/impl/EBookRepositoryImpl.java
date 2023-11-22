package com.project.repository.impl;

import com.project.domain.entity.EBookEntity;
import com.project.domain.exception.ResourceNotFoundException;
import com.project.filter.Filter;
import com.project.repository.EBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.project.helpers.Constant;

import java.util.List;

@Repository
public class EBookRepositoryImpl implements EBookRepository {

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
    public EBookEntity save(EBookEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public EBookEntity update(EBookEntity entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public EBookEntity findById(Integer id) {
            return entityManager.createQuery(Constant.SELECT_EBOOK_BY_ID,EBookEntity.class)
                    .setParameter("id",id).getSingleResult();
    }


    @Transactional
    @Override
    public EBookEntity delete(EBookEntity entity) {
        entity.setDeleted(true);
        entityManager.remove(entity);
        return entity;
    }

}
