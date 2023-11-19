package com.project.domain.entity;

import com.project.domain.enums.BookReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_reservation")
public class BookReservationEntity extends BaseEntity{

    @Temporal(TemporalType.DATE)
    private LocalDate toBeReturnedDate;

    @Enumerated(EnumType.STRING)
    private BookReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "reservation_id" , referencedColumnName = "id")
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "book_id" , referencedColumnName = "isbn")
    private PhysicalCopyEntity book;

}
