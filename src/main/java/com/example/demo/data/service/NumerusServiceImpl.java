package com.example.demo.data.service;

import com.example.demo.data.entity.Numerus;
import com.example.demo.data.repository.NumerusRepository;
import com.example.demo.data.service.base.NumerusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumerusServiceImpl implements NumerusService {

    @Autowired
    NumerusRepository numerusRepository;

    @Override
    public Numerus addNumerus(Numerus numerus) {
        return numerusRepository.save(new Numerus(numerus.getNumber(), numerus.getinsert_date()));
    }

    @Override
    public Numerus getNumerusByMaxNumber() {
        return numerusRepository.findTopByOrderByNumberDesc();
    }

    @Override
    public Numerus getNumerusByMinNumber() {
        return numerusRepository.findTopByOrderByNumberAsc();
    }

    @Override
    public Numerus getNumerusByNumber(int number) {
        return numerusRepository.findByNumber(number);
    }

    @Override
    public List<Numerus> getNumerusAll() {
        return numerusRepository.findAll();
    }

    @Override
    public Long removeNumerusByNumber(int number) {
        return numerusRepository.deleteByNumber(number);
    }
}
