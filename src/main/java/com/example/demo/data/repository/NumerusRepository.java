package com.example.demo.data.repository;

import com.example.demo.data.entity.Numerus;
import com.example.demo.data.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumerusRepository extends BaseRepository<Numerus, String> {

    Numerus findByNumber(int number);

    Numerus findTopByOrderByNumberAsc();

    Numerus findTopByOrderByNumberDesc();

    Long deleteByNumber(int number);

}
