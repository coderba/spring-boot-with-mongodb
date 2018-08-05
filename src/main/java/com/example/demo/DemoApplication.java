package com.example.demo;

import com.example.demo.data.entity.Numerus;
import com.example.demo.data.repository.NumerusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private NumerusRepository numerusRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        numerusRepository.deleteAll();

        Calendar calendar = Calendar.getInstance();

        // save a couple of numbers
        numerusRepository.save(new Numerus(1, calendar.getTime().toString()));
        numerusRepository.save(new Numerus(2, calendar.getTime().toString()));
        numerusRepository.save(new Numerus(3, calendar.getTime().toString()));
        numerusRepository.save(new Numerus(4, calendar.getTime().toString()));
        numerusRepository.save(new Numerus(5, calendar.getTime().toString()));
        numerusRepository.save(new Numerus(6, calendar.getTime().toString()));
        numerusRepository.save(new Numerus(7, calendar.getTime().toString()));

        // fetch all numbers
        System.out.println("\nCustomers found with findAll():");
        System.out.println("-------------------------------");
        for (Numerus numerus : numerusRepository.findAll()) {
            System.out.println(numerus);
        }
        System.out.println("-----------------------------------------------------------------------------------------");


        // fetch an individual number
        System.out.println("\nNumerus found with findByNumber(1):");
        System.out.println("--------------------------------");
        System.out.println(numerusRepository.findByNumber(1));
        System.out.println("-----------------------------------------------------------------------------------------");

        // fetch a max individual number
        System.out.println("\nNumerus found with minValue():");
        System.out.println("--------------------------------");
        System.out.println(numerusRepository.findTopByOrderByNumberAsc());
        System.out.println("-----------------------------------------------------------------------------------------");

        // fetch a max individual number
        System.out.println("\nNumerus found with maxValue():");
        System.out.println("--------------------------------");
        System.out.println(numerusRepository.findTopByOrderByNumberDesc());
        System.out.println("-----------------------------------------------------------------------------------------");

        // fetch a max individual number
        System.out.println("\nNumerus deleted for number eq 1:");
        System.out.println("--------------------------------");
        numerusRepository.deleteByNumber(7);
        System.out.println("-----------------------------------------------------------------------------------------");

        // fetch all numbers
        System.out.println("\nCustomers found with findAll():");
        System.out.println("-------------------------------");
        for (Numerus numerus : numerusRepository.findAll()) {
            System.out.println(numerus);
        }
        System.out.println("-----------------------------------------------------------------------------------------");

    }

}
