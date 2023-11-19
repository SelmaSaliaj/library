package com.project.service.impl;

import com.project.domain.dto.EBookDTO;
import com.project.domain.mapper.EBookMapper;
import com.project.repository.EBookRepository;
import com.project.service.EBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EBookServiceImpl implements EBookService {

    @Autowired
    private EBookRepository repository;

    @Override
    public EBookDTO findById(Integer id) {
        return EBookMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<EBookDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(EBookDTO request) {
        repository.save(EBookMapper.toEntity(request));
    }

    @Override
    public void update(EBookDTO request) {
        repository.update(EBookMapper.toEntity(request));
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
