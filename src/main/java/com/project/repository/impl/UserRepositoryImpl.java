package com.project.repository.impl;

import com.project.domain.entity.UserEntity;
import com.project.domain.exception.ResourceNotFoundException;
import com.project.helpers.Constant;
import com.project.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity findById(Integer id) {
        try{
            TypedQuery<UserEntity> findQuery = entityManager.createQuery(Constant.FIND_QUERY_BY_ID_USER,UserEntity.class);
            findQuery.setParameter("id",id);
            return findQuery.getSingleResult();
        }catch (NoResultException e){
            throw new ResourceNotFoundException("User with id: " + id + " doesn't exist");
        }
    }

    @Override
    public UserEntity save(UserEntity request) {
        entityManager.persist(request);
        return request;
    }

    @Override
    public UserEntity update(UserEntity dto) {
        entityManager.merge(dto);
        return dto;
    }

    @Override
    public UserEntity delete(UserEntity user) {
        entityManager.remove(user);
        return user;
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        try{
            TypedQuery<UserEntity> findQuery = entityManager.createQuery(Constant.FIND_QUERY_BY_USERNAME_USER,UserEntity.class);
            findQuery.setParameter("username",username);
            return Optional.of(findQuery.getSingleResult());
        }catch (NoResultException e){
            throw new ResourceNotFoundException("User with username: " + username + " doesn't exist");
        }
    }
}
