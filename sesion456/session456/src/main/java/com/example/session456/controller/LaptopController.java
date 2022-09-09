package com.example.session456.controller;

import com.example.session456.entity.Laptop;
import com.example.session456.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity findOneById(@PathVariable Long id) {
        Optional<Laptop> laptopOP = laptopRepository.findById(id);
        if (laptopOP.isPresent())
            return ResponseEntity.ok(laptopOP.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }
    

}
