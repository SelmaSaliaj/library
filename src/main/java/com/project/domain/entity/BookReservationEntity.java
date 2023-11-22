package com.project.domain.entity;

import com.project.domain.enums.BookReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_reservation")
public class BookReservationEntity extends BaseEntity{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    private LocalDateTime returnedDate;

    @Enumerated(EnumType.STRING)
    private BookReservationStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id" , referencedColumnName = "id")
    private ReservationEntity reservation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id" , referencedColumnName = "isbn")
    private PhysicalCopyEntity book;

}
