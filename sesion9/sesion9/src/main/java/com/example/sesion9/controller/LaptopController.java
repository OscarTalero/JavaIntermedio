package com.example.sesion9.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sesion9.entity.Laptop;
import com.example.sesion9.repository.LaptopRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class LaptopController {

    private Logger log = LoggerFactory.getLogger(LaptopController.class);
    
    private LaptopRepository laptopRepository;

    private LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    //CRUD

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOp = laptopRepository.findById(id);
        if (laptopOp.isPresent())
            return ResponseEntity.ok(laptopOp.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if(laptop.getId() !=null){
            log.warn("Trying to create a Laptop with Id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null){
            log.warn("Trying update a non existent Laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying update a non existent Laptop");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }
    
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if (!laptopRepository.existsById(id)){
            log.warn("Trying update a non existent Laptop");
            return ResponseEntity.badRequest().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all Laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
