package com.project.service.impl;

import com.project.domain.dto.UserDTO;
import com.project.domain.mapper.UserMapper;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO findById(Integer id) {
        return UserMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<UserDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(UserDTO request) {
        repository.save(UserMapper.toEntity(request));
    }

    @Override
    public void update(UserDTO request) {
        repository.update(UserMapper.toEntity(request));
    }

    @Override
    public void softDelete(Integer id) {
        repository.softDelete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void restore(Integer id) {
        repository.restore(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

}
