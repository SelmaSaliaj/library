package com.project.service;

import com.project.domain.dto.LocationDTO;
import com.project.domain.dto.LocationRequest;
import com.project.filter.Filter;

import java.util.List;

public interface LocationService {

    LocationDTO findById(Integer id);

    void save(LocationRequest request);

    void update(LocationDTO request);

    void softDelete(Integer id);

    void delete(Integer id);

    void restore(Integer id);

    List<LocationDTO> getAllEBooks(Filter... filters);

}
