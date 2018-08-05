package com.example.demo.data.repository;

import com.example.demo.data.entity.Numerus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumerusRepository extends MongoRepository<Numerus, String> {

    Numerus findByNumber(int number);

    Numerus findTopByOrderByNumberAsc();

    Numerus findTopByOrderByNumberDesc();

    Long deleteByNumber(int number);

    List<Numerus> findAllByOrderByNumberAsc();

    List<Numerus> findAllByOrderByNumberDesc();


}
