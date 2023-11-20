package com.project.service;

import com.project.domain.dto.PhysicalCopyDTO;
import com.project.domain.dto.PhysicalCopyRequest;
import com.project.filter.Filter;

import java.util.List;

public interface PhysicalCopyService{

    PhysicalCopyDTO findById(Integer id);

    void save(PhysicalCopyRequest request);

    void update(PhysicalCopyDTO request);

    void softDelete(Integer id);

    void delete(Integer id);

    void restore(Integer id);

    List<PhysicalCopyDTO> getAllEBooks(Filter... filters);

}
