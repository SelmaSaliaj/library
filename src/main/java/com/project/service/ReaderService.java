package com.project.service;

import com.project.domain.dto.ReaderDTO;
import com.project.domain.dto.ReaderRequest;
import com.project.filter.Filter;

import java.util.List;

public interface ReaderService {

    ReaderDTO findById(Integer id);

    void save(ReaderRequest request);

    void update(ReaderDTO request);

    void softDelete(Integer id);

    void delete(Integer id);

    void restore(Integer id);

    List<ReaderDTO> getAllEBooks(Filter... filters);

}
