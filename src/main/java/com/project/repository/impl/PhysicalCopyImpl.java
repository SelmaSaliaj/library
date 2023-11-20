package com.project.repository.impl;

import com.project.domain.entity.PhysicalCopyEntity;
import com.project.filter.Filter;
import com.project.repository.PhysicalCopyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PhysicalCopyImpl implements PhysicalCopyRepository {

    private static final String FIND_QUERY = "SELECT b FROM PhysicalCopyEntity b WHERE b.id = :id";

    private static final String SELECT_ALL = "SELECT b FROM PhysicalCopyEntity b WHERE 1 = 1";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PhysicalCopyEntity> getAll(Filter... filters) {
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
    public PhysicalCopyEntity save(PhysicalCopyEntity book) {
        entityManager.persist(book);
        return book;
    }

    @Transactional
    @Override
    public PhysicalCopyEntity update(PhysicalCopyEntity book) {
        entityManager.merge(book);
        return book;
    }

    @Override
    public Optional<PhysicalCopyEntity> findById(Integer id) {
        return Optional.of(entityManager.createQuery(FIND_QUERY,PhysicalCopyEntity.class)
                .setParameter("id",id).getSingleResult());
    }

    @Override
    public void softDelete(PhysicalCopyEntity entity) {
        entity.setDeleted(true);
    }

    @Transactional
    @Override
    public PhysicalCopyEntity delete(PhysicalCopyEntity book) {
        entityManager.remove(book);
        return book;
    }

    @Override
    public void restore(PhysicalCopyEntity entity) {
        entity.setDeleted(false);
    }
}
