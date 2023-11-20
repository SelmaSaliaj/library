package com.project.service;

import com.project.domain.dto.UserDTO;
import com.project.filter.Filter;

import java.util.List;

public interface UserService extends IBaseService<UserDTO,Integer>{

    List<UserDTO> getAllEBooks(Filter... filters);

}
