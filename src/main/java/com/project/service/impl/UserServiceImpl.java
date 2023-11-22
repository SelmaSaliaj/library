package com.project.service.impl;

import com.project.domain.dto.UserDTO;
import com.project.domain.dto.UserRequest;
import com.project.domain.entity.UserEntity;
import com.project.domain.mapper.UserMapper;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO findById(Integer id) {
        return UserMapper.toDTO(repository.findById(id));
    }

    @Override
    public UserDTO save(UserRequest request) {
        String password = request.getPassword();
        request.setPassword(passwordEncoder.encode(password));
        return UserMapper.toDTO(repository.save(UserMapper.toEntity(request)));
    }

    @Override
    public UserDTO update(UserRequest request, Integer id) {
        UserDTO userDTO = UserMapper.toDTO(request);
        userDTO.setId(id);
        return UserMapper.toDTO(repository.update(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO delete(Integer id) {
        UserEntity entity = repository.findById(id);
        return UserMapper.toDTO(repository.delete(entity));
    }
}
