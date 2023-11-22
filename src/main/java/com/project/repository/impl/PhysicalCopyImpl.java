package com.project.repository.impl;

import com.project.domain.entity.PhysicalCopyEntity;
import com.project.filter.Filter;
import com.project.helpers.Constant;
import com.project.repository.PhysicalCopyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhysicalCopyImpl implements PhysicalCopyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String SELECT_ALL = "SELECT b FROM PhysicalCopyEntity b WHERE 1 = 1";

    @Override
    public List<PhysicalCopyEntity> getAll(Filter... filters) {
        String dynamicQuery = SELECT_ALL;

        if(filters != null){
            if(filters[0].getValue() != null){
                dynamicQuery += "AND c." + filters[0].getField() + " " +
                        filters[0].getOperator() + " '%" + filters[0].getValue() + "%' ";
            }
            if (filters[0].getSort() != null) {
                dynamicQuery += "ORDER BY c." + filters[0].getField() + " " + filters[0].getSort();
            }
            if (filters[0].getPageSize() != null && filters[0].getPageNumber() != null) {
                return entityManager.createQuery(dynamicQuery, PhysicalCopyEntity.class)
                        .setFirstResult((filters[0].getPageNumber() - 1) * filters[0].getPageSize())
                        .setMaxResults(filters[0].getPageSize())
                        .getResultList();
            }
        }
        return entityManager.createQuery(dynamicQuery, PhysicalCopyEntity.class).getResultList();
    }

    @Transactional
    @Override
    public PhysicalCopyEntity save(PhysicalCopyEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public PhysicalCopyEntity update(PhysicalCopyEntity entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public PhysicalCopyEntity findById(Integer id) {
        return entityManager.createQuery(Constant.SELECT_BOOK_BY_ID,PhysicalCopyEntity.class)
                .setParameter("id",id).getSingleResult();
    }

    @Transactional
    @Override
    public PhysicalCopyEntity delete(PhysicalCopyEntity entity) {
        entityManager.remove(entity);
        return entity;
    }

    @Override
    public List<PhysicalCopyEntity> findByTitle(String title) {
        return entityManager.createQuery(Constant.SELECT_BOOKS_BY_TITLE,PhysicalCopyEntity.class)
                .setParameter("title",title).getResultList();
    }

    @Override
    public List<PhysicalCopyEntity> findByAuthor(String author) {
        return entityManager.createQuery(Constant.SELECT_BOOKS_BY_AUTHOR,PhysicalCopyEntity.class)
                .setParameter("author",author).getResultList();
    }

    @Override
    public PhysicalCopyEntity findByTitleAndAuthor(String title, String author) {
        return entityManager.createQuery(Constant.SELECT_BOOKS_BY_TITLE_AND_AUTHOR,PhysicalCopyEntity.class)
                .setParameter("title",title).setParameter("author",author).getSingleResult();
    }
}
