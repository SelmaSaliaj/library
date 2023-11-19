package com.project.controller;

import com.project.domain.dto.ReaderDTO;
import com.project.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("/{id}")
    public ResponseEntity<ReaderDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(readerService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody ReaderDTO readerDTO){
        readerService.save(readerDTO);
    }

    @PutMapping
    public void update(@RequestBody ReaderDTO readerDTO){
        readerService.update(readerDTO);
    }

    @PutMapping("/softDelete/{id}")
    public void softDelete(@PathVariable("id") Integer id){
        readerService.softDelete(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        readerService.delete(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable("id") Integer id){
        readerService.restore(id);
    }

}
