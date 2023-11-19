package com.project.service.impl;

import com.project.domain.dto.LocationDTO;
import com.project.domain.mapper.LocationMapper;
import com.project.repository.LocationRepository;
import com.project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public LocationDTO findById(Integer id) {
        return LocationMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<LocationDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(LocationDTO request) {
        repository.save(LocationMapper.toEntity(request));
    }

    @Override
    public void update(LocationDTO request) {
        repository.update(LocationMapper.toEntity(request));
    }

    @Override
    public void softDelete(Integer id) {
        repository.softDelete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void restore(Integer id) {
        repository.restore(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }
}
