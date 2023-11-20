package com.project.service.impl;

import com.project.domain.dto.EBookDTO;
import com.project.domain.entity.EBookEntity;
import com.project.domain.mapper.EBookMapper;
import com.project.filter.Filter;
import com.project.repository.EBookRepository;
import com.project.service.EBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EBookServiceImpl implements EBookService {

    @Autowired
    private EBookRepository repository;

    @Override
    public EBookDTO findById(Integer id) {
        return EBookMapper.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
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

    @Override
    public List<EBookDTO> getAllEBooks(Filter... filters) {
        List<EBookEntity> ebooks = repository.getAll(filters);
        return ebooks.stream()
                .map(e -> EBookMapper.toDTO(e))
                .collect(Collectors.toList());
    }

}
