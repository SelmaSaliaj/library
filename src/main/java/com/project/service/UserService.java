package com.project.service;

import com.project.domain.dto.UserDTO;
import com.project.domain.dto.UserRequest;
import com.project.filter.Filter;

import java.util.List;

public interface UserService{

    UserDTO findById(Integer id);

    void save(UserRequest request);

    void update(UserDTO request);

    void softDelete(Integer id);

    void delete(Integer id);

    void restore(Integer id);

    List<UserDTO> getAllEBooks(Filter... filters);

}
