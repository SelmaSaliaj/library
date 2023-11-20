package com.project.domain.dto;

import com.project.domain.enums.BookReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReservationDTO extends BaseDTO{

    private LocalDateTime returnedDate;

    private BookReservationStatus status;

    private ReservationDTO reservation;

    private PhysicalCopyDTO book;

}
