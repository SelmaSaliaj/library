package com.project.repository.impl;

import com.project.domain.entity.PhysicalCopyEntity;
import com.project.repository.PhysicalCopyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PhysicalCopyImpl implements PhysicalCopyRepository {

    private static final String FIND_QUERY = "SELECT b FROM PhysicalCopyEntity WHERE b.id = :id";

    private static final String GET_ALL_QUERY = "SELECT * FROM PhysicalCopyEntity";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PhysicalCopyEntity> getAll() {
        return entityManager.createQuery(GET_ALL_QUERY, PhysicalCopyEntity.class).getResultList();
    }

    @Override
    public PhysicalCopyEntity save(PhysicalCopyEntity book) {
        entityManager.persist(book);
        return book;
    }

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
