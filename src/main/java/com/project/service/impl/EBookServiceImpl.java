package com.project.service.impl;

import com.project.domain.dto.EBookDTO;
import com.project.domain.dto.EBookRequest;
import com.project.domain.entity.EBookEntity;
import com.project.domain.exception.ResourceNotFoundException;
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
        EBookEntity eBook = repository.findById(id);
        if(eBook == null){
            throw new ResourceNotFoundException("EBook does not exist.");
        }
        return EBookMapper.toDTO(eBook);
    }

    @Override
    public void save(EBookRequest request) {
        EBookMapper.toDTO(repository.save(EBookMapper.toEntity(request)));
    }

    @Override
    public void update(EBookDTO request) {
        repository.update(EBookMapper.toEntity(request));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public List<EBookDTO> getAllEBooks(Filter... filters) {
        List<EBookEntity> ebooks = repository.getAll(filters);
        return ebooks.stream()
                .map(e -> EBookMapper.toDTO(e))
                .collect(Collectors.toList());
    }

}
