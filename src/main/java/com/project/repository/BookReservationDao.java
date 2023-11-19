package com.project.repository;

import com.project.domain.entity.BookReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationDao extends JpaRepository<BookReservationEntity,Integer> {

    default void softDelete(BookReservationEntity entity){
        entity.setDeleted(true);
    }

    default void restore(BookReservationEntity entity) {
        entity.setDeleted(false);
    }

}
