package com.example.demo;

import com.example.demo.data.entity.Number;
import com.example.demo.data.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private NumberRepository numberRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        numberRepository.deleteAll();


        // save a couple of numbers
        numberRepository.save(new Number(1, "11"));
        numberRepository.save(new Number(2, "12"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Number number : numberRepository.findAll()) {
            System.out.println(number);
        }
        System.out.println();

        // fetch an individual number
        System.out.println("Number found with findByNumber(1):");
        System.out.println("--------------------------------");
        System.out.println(numberRepository.findByNumber(1));


    }

}
