package com.project.repository;

import com.project.domain.entity.BookReservationEntity;
import com.project.domain.entity.ReservationEntity;
import com.project.helpers.Constant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends JpaRepository<ReservationEntity,Integer> {
}
