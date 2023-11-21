package com.project.service;

import com.project.domain.dto.BookReservationDTO;
import com.project.domain.dto.ReservationDTO;
import com.project.domain.dto.ReservationRequest;
import com.project.domain.entity.BookReservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService{

    ReservationDTO findById(Integer id);

    void save(ReservationDTO request);

    void update(ReservationDTO request);

    void delete(Integer id);

    Page<ReservationDTO> getAllReservations(Pageable pageable);

}
