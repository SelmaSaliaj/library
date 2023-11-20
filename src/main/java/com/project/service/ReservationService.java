package com.project.service;

import com.project.domain.dto.ReservationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService extends IBaseService<ReservationDTO,Integer> {

    Page<ReservationDTO> getAllReservations(Pageable pageable);

}
