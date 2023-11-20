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
public class BookReservationRequest extends BaseRequest {

    private LocalDateTime toBeReturnedDate;

    private BookReservationStatus status;

    private Integer reservationId;

    private Integer bookId;

}
