package com.example.session456.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String branch;
    private String cpu;
    private Integer ram;
    private LocalDate manufacturingDate;

}
