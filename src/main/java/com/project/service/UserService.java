package com.project.service;

import com.project.domain.dto.UserDTO;
import com.project.domain.dto.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO findById(Integer id);

    UserDTO save(UserRequest request);

    UserDTO update(UserRequest request, Integer id);

    UserDTO delete(Integer id);

}
