package com.project.controller;

import com.project.domain.dto.LocationDTO;
import com.project.domain.dto.LocationRequest;
import com.project.domain.dto.ReaderDTO;
import com.project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(locationService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody LocationRequest locationDTO){
        locationService.save(locationDTO);
    }

    @PutMapping
    public void update(@RequestBody LocationDTO locationDTO){
        locationService.update(locationDTO);
    }

    @PutMapping("/softDelete/{id}")
    public void softDelete(@PathVariable("id") Integer id){
        locationService.softDelete(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        locationService.delete(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable("id") Integer id){
        locationService.restore(id);
    }

}
