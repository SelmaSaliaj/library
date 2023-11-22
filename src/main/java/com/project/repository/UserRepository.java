package com.project.repository;

import com.project.domain.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {

    UserEntity findById(Integer id);

    UserEntity save(UserEntity request);

    UserEntity update(UserEntity dto);

    UserEntity delete(UserEntity user);

    Optional<UserEntity> findByUsername(String username);

}
