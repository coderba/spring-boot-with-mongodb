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
public class DemoApplication {

    @Autowired
    private NumerusRepository numerusRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
