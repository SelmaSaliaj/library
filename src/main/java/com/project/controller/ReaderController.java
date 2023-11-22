package com.project.controller;

import com.project.domain.dto.ReaderDTO;
import com.project.domain.dto.ReaderRequest;
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
    public void save(@RequestBody ReaderRequest readerDTO){
        readerService.save(readerDTO);
    }

    @PutMapping
    public void update(@RequestBody ReaderDTO readerDTO){
        readerService.update(readerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        readerService.delete(id);
    }


}
