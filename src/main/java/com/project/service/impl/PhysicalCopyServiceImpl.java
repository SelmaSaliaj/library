package com.project.service.impl;

import com.project.domain.dto.PhysicalCopyDTO;
import com.project.domain.dto.PhysicalCopyRequest;
import com.project.domain.entity.PhysicalCopyEntity;
import com.project.domain.mapper.PhysicalCopyMapper;
import com.project.filter.Filter;
import com.project.repository.PhysicalCopyRepository;
import com.project.service.PhysicalCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhysicalCopyServiceImpl implements PhysicalCopyService {

    @Autowired
    private PhysicalCopyRepository repository;


    @Override
    public PhysicalCopyDTO findById(Integer id) {
        return PhysicalCopyMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void save(PhysicalCopyRequest request) {
        PhysicalCopyMapper.toDTO(repository.save(PhysicalCopyMapper.toEntity(request)));
    }

    @Override
    public void update(PhysicalCopyDTO request) {
        repository.update(PhysicalCopyMapper.toEntity(request));
    }

    @Override
    public void softDelete(Integer id) {
        repository.softDelete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.delete(repository.findById(id).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public void restore(Integer id) {
        repository.restore(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public List<PhysicalCopyDTO> getAllEBooks(Filter... filters) {
        List<PhysicalCopyEntity> books = repository.getAll(filters);
        return books.stream()
                .map(b -> PhysicalCopyMapper.toDTO(b))
                .collect(Collectors.toList());
    }

}
