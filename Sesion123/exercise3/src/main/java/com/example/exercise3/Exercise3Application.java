package com.example.exercise3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Exercise3Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Exercise3Application.class, args);
		CarRepository repository = context.getBean(CarRepository.class);

		Car Porshe = new Car(null, "Porshe", "Cayene",2020);
		repository.save(Porshe);
		System.out.println("The numbers cars is: " + repository.count());

		System.out.println(repository.findAll());

	}

}
