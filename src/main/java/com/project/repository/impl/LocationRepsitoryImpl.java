package com.project.repository.impl;

import com.project.domain.entity.LocationEntity;
import com.project.filter.Filter;
import com.project.repository.LocationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepsitoryImpl implements LocationRepository {

    private static final String FIND_QUERY = "SELECT l FROM LocationEntity WHERE l.id = :id";

    private static final String SELECT_ALL = "SELECT l FROM LocationEntity WHERE 1 = 1";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LocationEntity> getAll(Filter... filters) {
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
                return entityManager.createQuery(dynamicQuery, LocationEntity.class)
                        .setFirstResult((filters[0].getPageNumber() - 1) * filters[0].getPageSize())
                        .setMaxResults(filters[0].getPageSize())
                        .getResultList();
            }
        }
        return entityManager.createQuery(dynamicQuery, LocationEntity.class).getResultList();
    }

    @Override
    public LocationEntity save(LocationEntity location) {
        entityManager.persist(location);
        location.setCreatedDate(LocalDateTime.now());
        location.setLastModified(LocalDateTime.now());
        return location;
    }

    @Override
    public LocationEntity update(LocationEntity location) {
        entityManager.merge(location);
        location.setLastModified(LocalDateTime.now());
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
