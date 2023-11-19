package com.project.service.impl;

import com.project.domain.dto.ReaderDTO;
import com.project.domain.mapper.ReaderMapper;
import com.project.repository.ReaderRepository;
import com.project.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository repository;

    @Override
    public ReaderDTO findById(Integer id) {
        return ReaderMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<ReaderDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(ReaderDTO request) {
        repository.save(ReaderMapper.toEntity(request));
    }

    @Override
    public void update(ReaderDTO request) {
        repository.update(ReaderMapper.toEntity(request));
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
