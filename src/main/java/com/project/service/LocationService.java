package com.project.service;

import com.project.domain.dto.LocationDTO;
import com.project.filter.Filter;

import java.util.List;

public interface LocationService extends IBaseService<LocationDTO,Integer> {

    List<LocationDTO> getAllEBooks(Filter... filters);

}
