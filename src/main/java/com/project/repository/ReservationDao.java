package com.project.repository;

import com.project.domain.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends JpaRepository<ReservationEntity,Integer> {

    default void softDelete(ReservationEntity entity){
        entity.setDeleted(true);
    }

    default void restore(ReservationEntity entity) {
        entity.setDeleted(false);
    }

}
