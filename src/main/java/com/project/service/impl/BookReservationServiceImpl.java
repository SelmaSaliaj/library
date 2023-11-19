package com.project.service.impl;

import com.project.domain.dto.BookReservationDTO;
import com.project.domain.mapper.BookReservationMapper;
import com.project.repository.BookReservationDao;
import com.project.service.BookReservationService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private BookReservationDao repository;

    private static final BookReservationMapper BOOK_RESERVATION_MAPPER = Mappers.getMapper(BookReservationMapper.class);

    public BookReservationServiceImpl(BookReservationDao repository) {
        this.repository = repository;
    }

    @Override
    public BookReservationDTO findById(Integer id) {
        return BOOK_RESERVATION_MAPPER.toBookReservationDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<BookReservationDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(BookReservationDTO request) {
        repository.save(BOOK_RESERVATION_MAPPER.toBookReservationEntity(request));
    }

    @Override
    public void update(BookReservationDTO request) {
        repository.save(BOOK_RESERVATION_MAPPER.toBookReservationEntity(request,
                repository.findById(request.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public void softDelete(Integer id) {
        repository.softDelete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void restore(Integer id) {
        repository.restore(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

}
