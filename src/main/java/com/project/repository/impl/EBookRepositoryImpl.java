package com.project.repository.impl;

import com.project.domain.entity.EBookEntity;
import com.project.repository.EBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EBookRepositoryImpl implements EBookRepository {

    private static final String FIND_QUERY = "SELECT e FROM EBookEntity WHERE e.id = :id";

    private static final String GET_ALl_QUERY = "SELECT * FROM EBookEntity";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EBookEntity> getAll() {
        return entityManager.createQuery(GET_ALl_QUERY, EBookEntity.class).getResultList();
    }

    @Override
    public EBookEntity save(EBookEntity eBook) {
        entityManager.persist(eBook);
        return eBook;
    }

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
