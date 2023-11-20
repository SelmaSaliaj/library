package com.project.service;

import com.project.domain.dto.BaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface IBaseService<T extends BaseDTO, I extends Serializable> {

    T findById(I id);

    void save(T request);

    void update(T request);

    void softDelete(I id);

    void delete(I id);

    void restore(I id);

}
