package com.project.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class ReservationEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id_reader" , referencedColumnName = "id")
    private ReaderEntity reader;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.EAGER)
    private List<BookReservationEntity> bookReservations = new ArrayList<>();

}
