package com.project.controller;

import com.project.domain.dto.EBookDTO;
import com.project.domain.dto.EBookRequest;
import com.project.service.EBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ebook")
public class EBookController {

    @Autowired
    private EBookService eBookService;

    @GetMapping("/{id}")
    public ResponseEntity<EBookDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(eBookService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody EBookRequest ebookDTO){
        eBookService.save(ebookDTO);
    }

    @PutMapping
    public void update(@RequestBody EBookDTO ebookDTO){
        eBookService.update(ebookDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        eBookService.delete(id);
    }

}
