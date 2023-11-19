package com.project.controller;

import com.project.domain.dto.ReservationDTO;
import com.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(reservationService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody ReservationDTO reservationDTO){
        reservationService.save(reservationDTO);
    }

    @PutMapping
    public void update(@RequestBody ReservationDTO reservationDTO){
        reservationService.update(reservationDTO);
    }

    @PutMapping("/softDelete/{id}")
    public void softDelete(@PathVariable("id") Integer id){
        reservationService.softDelete(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        reservationService.delete(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable("id") Integer id){
        reservationService.restore(id);
    }

}
