package com.project.domain.entity;

import com.project.domain.enums.ReaderStatus;
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

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private String address;

    private String phoneNumber;

    @Transient
    @Enumerated(EnumType.STRING)
    private ReaderStatus status;

    @OneToMany(mappedBy = "reader")
    private List<ReservationEntity> reservations;

    @OneToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id" , unique = true)
    private UserEntity user;
}
