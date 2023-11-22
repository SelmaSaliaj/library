package com.project.repository;

import com.project.domain.entity.BookReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReservationDao extends JpaRepository<BookReservationEntity,Integer> {


}
