package com.project.domain.dto;

import com.project.domain.enums.BookReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReservationRequest {

    private LocalDate createdDate;

    private LocalDate toBeReturnedDate;

    private BookReservationStatus status;

    private Integer reservationId;

    private Integer bookId;

}
