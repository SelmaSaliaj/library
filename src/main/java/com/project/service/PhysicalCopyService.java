package com.project.service;

import com.project.domain.dto.PhysicalCopyDTO;
import com.project.filter.Filter;

import java.util.List;

public interface PhysicalCopyService extends IBaseService<PhysicalCopyDTO,Integer>{

    List<PhysicalCopyDTO> getAllEBooks(Filter... filters);

}
