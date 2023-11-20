package com.project.service;

import com.project.domain.dto.BookReservationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookReservationService extends IBaseService<BookReservationDTO,Integer> {

    Page<BookReservationDTO> getAllBookReservations(Pageable pageable);

}
