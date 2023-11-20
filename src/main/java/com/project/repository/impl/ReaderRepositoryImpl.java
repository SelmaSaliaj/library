package com.project.repository.impl;

import com.project.domain.entity.EBookEntity;
import com.project.domain.entity.ReaderEntity;
import com.project.filter.Filter;
import com.project.repository.ReaderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private static final String FIND_QUERY = "SELECT r FROM ReaderEntity WHERE r.id = :id";

    private static final String SELECT_ALL = "SELECT r FROM ReaderEntity WHERE 1 = 1";

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

    @Override
    public ReaderEntity save(ReaderEntity reader) {
        entityManager.persist(reader);
        reader.setCreatedDate(LocalDateTime.now());
        reader.setLastModified(LocalDateTime.now());
        return reader;
    }

    @Override
    public ReaderEntity update(ReaderEntity reader) {
        entityManager.merge(reader);
        reader.setLastModified(LocalDateTime.now());
        return reader;
    }

    @Override
    public Optional<ReaderEntity> findById(Integer id) {
        return Optional.of(entityManager.createQuery(FIND_QUERY,ReaderEntity.class)
                .setParameter("id",id).getSingleResult());
    }

    @Override
    public void softDelete(ReaderEntity entity) {
        entity.setDeleted(true);
    }

    @Override
    public ReaderEntity delete(ReaderEntity reader) {
        entityManager.remove(reader);
        return reader;
    }

    @Override
    public void restore(ReaderEntity entity) {
        entity.setDeleted(false);
    }
}
