package com.project.controller;

import com.project.domain.dto.PhysicalCopyDTO;
import com.project.domain.dto.PhysicalCopyRequest;
import com.project.service.PhysicalCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class PhysicalCopyController {

    @Autowired
    private PhysicalCopyService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<PhysicalCopyDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody PhysicalCopyRequest physicalCopyDTO){
        bookService.save(physicalCopyDTO);
    }

    @PutMapping
    public void update(@RequestBody PhysicalCopyDTO physicalCopyDTO){
        bookService.update(physicalCopyDTO);
    }

    @PutMapping("/softDelete/{id}")
    public void softDelete(@PathVariable("id") Integer id){
        bookService.softDelete(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookService.delete(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable("id") Integer id){
        bookService.restore(id);
    }

}
