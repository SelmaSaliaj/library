package com.project.service;

import com.project.domain.dto.EBookDTO;
import com.project.domain.dto.EBookRequest;
import com.project.filter.Filter;

import java.util.List;

public interface EBookService {

    EBookDTO findById(Integer id);

    void save(EBookRequest request);

    void update(EBookDTO request);

    void delete(Integer id);

    List<EBookDTO> getAllEBooks(Filter... filters);

}
