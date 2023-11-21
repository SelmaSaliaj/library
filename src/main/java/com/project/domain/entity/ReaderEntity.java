package com.project.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reader")
public class ReaderEntity extends BaseEntity{

    @Column(name = "first_name")
    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private String address;

    private String phoneNumber;

    @OneToMany(mappedBy = "reader")
    private List<ReservationEntity> reservations;

    @OneToOne(mappedBy = "reader")
    private UserEntity user;
}
