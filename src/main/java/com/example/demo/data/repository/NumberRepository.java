package com.example.demo.data.repository;

import com.example.demo.data.entity.Number;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NumberRepository extends MongoRepository<Number, String> {

    Number findByNumber(int number);

}
