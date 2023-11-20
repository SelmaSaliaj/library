package com.project.service;

import com.project.domain.dto.ReaderDTO;
import com.project.filter.Filter;

import java.util.List;

public interface ReaderService extends IBaseService<ReaderDTO,Integer> {

    List<ReaderDTO> getAllEBooks(Filter... filters);

}
