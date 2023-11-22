package com.project.service.impl;

import com.project.domain.dto.ReaderDTO;
import com.project.domain.dto.ReaderRequest;
import com.project.domain.entity.ReaderEntity;
import com.project.domain.mapper.ReaderMapper;
import com.project.filter.Filter;
import com.project.repository.ReaderRepository;
import com.project.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository repository;

    @Override
    public ReaderDTO findById(Integer id) {
        return ReaderMapper.toDTO(repository.findById(id));
    }

    @Override
    public void save(ReaderRequest request) {
        ReaderMapper.toDTO(repository.save(ReaderMapper.toEntity(request)));
    }

    @Override
    public void update(ReaderDTO request) {
        repository.update(ReaderMapper.toEntity(request));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public List<ReaderDTO> getAllEBooks(Filter... filters) {
        List<ReaderEntity> readers = repository.getAll(filters);
        return readers.stream()
                .map(r -> ReaderMapper.toDTO(r))
                .collect(Collectors.toList());
    }

}
