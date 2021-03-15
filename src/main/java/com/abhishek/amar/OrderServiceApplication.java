package com.abhishek.amar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderServiceApplication { 
    
    @GetMapping("/demo")
	String home() {
		System.out.println("Hii its demo !!!!!!");
		return "Spring is here!  CICD application by Abhishek Amar...";
	}
    @GetMapping("/demo1")
	String demo() {
		System.out.println("Hii its demo !!!!!!");
		return "Spring is here!  CICD application by demo1";
	}
     

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
