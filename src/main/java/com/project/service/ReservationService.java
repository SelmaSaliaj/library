package com.project.service;

import com.project.domain.dto.ReservationDTO;
import com.project.domain.dto.ReservationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService{

    ReservationDTO findById(Integer id);

    void save(ReservationDTO request);

    void update(ReservationDTO request);

    void softDelete(Integer id);

    void delete(Integer id);

    void restore(Integer id);

    Page<ReservationDTO> getAllReservations(Pageable pageable);

}
