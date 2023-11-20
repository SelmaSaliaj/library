package com.project.service;

import com.project.domain.dto.EBookDTO;
import com.project.filter.Filter;

import java.util.List;

public interface EBookService extends IBaseService<EBookDTO,Integer> {

    List<EBookDTO> getAllEBooks(Filter... filters);

}
