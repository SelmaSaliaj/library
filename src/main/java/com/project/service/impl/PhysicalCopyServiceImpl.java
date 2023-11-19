package com.project.service.impl;

import com.project.domain.dto.PhysicalCopyDTO;
import com.project.domain.mapper.PhysicalCopyMapper;
import com.project.repository.PhysicalCopyRepository;
import com.project.service.PhysicalCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhysicalCopyServiceImpl implements PhysicalCopyService {

    @Autowired
    private PhysicalCopyRepository repository;


    @Override
    public PhysicalCopyDTO findById(Integer id) {
        return PhysicalCopyMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<PhysicalCopyDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(PhysicalCopyDTO request) {
        repository.save(PhysicalCopyMapper.toEntity(request));
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

}
