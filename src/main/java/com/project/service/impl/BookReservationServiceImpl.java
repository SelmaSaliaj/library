package com.project.service.impl;

import com.project.domain.dto.BookReservationDTO;
import com.project.domain.entity.BookReservationEntity;
import com.project.domain.exception.ResourceNotFoundException;
import com.project.domain.mapper.BookReservationMapper;
import com.project.repository.BookReservationDao;
import com.project.service.BookReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private BookReservationDao repository;

    private static final BookReservationMapper BOOK_RESERVATION_MAPPER = Mappers.getMapper(BookReservationMapper.class);

    public BookReservationServiceImpl(BookReservationDao repository) {
        this.repository = repository;
    }

    @Override
    public BookReservationDTO findById(Integer id) {
        return BOOK_RESERVATION_MAPPER.toBookReservationDTO(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Reservation does not exist.")));
    }

    @Override
    public Page<BookReservationDTO> getAllBookReservations(Pageable pageable) {
        var bookReservationPage = repository.findAll(pageable);
        var content = bookReservationPage.getContent().stream()
                .map(b -> BOOK_RESERVATION_MAPPER.toBookReservationDTO(b))
                .collect(Collectors.toList());
        return new PageImpl<>(content,bookReservationPage.getPageable(),bookReservationPage.getTotalElements());
    }

    @Override
    public void save(BookReservationDTO request) {
        request.setCreatedDate(LocalDateTime.now());
        request.setLastModified(LocalDateTime.now());
        repository.save(BOOK_RESERVATION_MAPPER.toBookReservationEntity(request));
    }

    @Override
    public void update(BookReservationDTO request) {
        request.setLastModified(LocalDateTime.now());
        repository.save(BOOK_RESERVATION_MAPPER.toBookReservationEntity(request,
                repository.findById(request.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public void softDelete(Integer id) {
        repository.softDelete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Book Reservation not found with id: " + id);
        }
    }

    @Override
    public void restore(Integer id) {
        repository.restore(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

}
