package com.example.sesion9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sesion9.entity.Laptop;

public interface LaptopRepository extends JpaRepository <Laptop, Long>{
    
}
