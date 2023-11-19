package com.project.repository.impl;

import com.project.domain.entity.ReaderEntity;
import com.project.repository.ReaderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private static final String FIND_QUERY = "SELECT r FROM ReaderEntity WHERE r.id = :id";

    private static final String GET_ALL_QUERY = "SELECT * FROM ReaderEntity";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ReaderEntity> getAll() {
        return entityManager.createQuery(GET_ALL_QUERY, ReaderEntity.class).getResultList();
    }

    @Override
    public ReaderEntity save(ReaderEntity reader) {
        entityManager.persist(reader);
        return reader;
    }

    @Override
    public ReaderEntity update(ReaderEntity reader) {
        entityManager.merge(reader);
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
