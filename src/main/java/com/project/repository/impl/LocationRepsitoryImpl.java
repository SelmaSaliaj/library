package com.project.repository.impl;

import com.project.domain.entity.LocationEntity;
import com.project.repository.LocationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepsitoryImpl implements LocationRepository {

    private static final String FIND_QUERY = "SELECT l FROM LocationEntity WHERE l.id = :id";

    private static final String GET_ALL_QUERY = "SELECT * FROM LocationEntity";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LocationEntity> getAll() {
        return entityManager.createQuery(GET_ALL_QUERY, LocationEntity.class).getResultList();
    }

    @Override
    public LocationEntity save(LocationEntity location) {
        entityManager.persist(location);
        return location;
    }

    @Override
    public LocationEntity update(LocationEntity location) {
        entityManager.merge(location);
        return location;
    }

    @Override
    public Optional<LocationEntity> findById(Integer id) {
        return Optional.of(entityManager.createQuery(FIND_QUERY,LocationEntity.class)
                .setParameter("id",id).getSingleResult());
    }

    @Override
    public void softDelete(LocationEntity entity) {
        entity.setDeleted(true);
    }

    @Override
    public LocationEntity delete(LocationEntity location) {
        entityManager.remove(location);
        return location;
    }

    @Override
    public void restore(LocationEntity entity) {
        entity.setDeleted(false);
    }

}
