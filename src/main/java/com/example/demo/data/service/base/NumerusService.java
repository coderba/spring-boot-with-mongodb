package com.example.demo.data.service.base;

import com.example.demo.data.entity.Numerus;

import java.util.List;

public interface NumerusService {

    Numerus addNumerus(Numerus numerus);

    Numerus getNumerusByMaxNumber();

    Numerus getNumerusByMinNumber();

    Numerus getNumerusByNumber(int number);

    List<Numerus> getNumerusAll();

    Long removeNumerusByNumber(int number);
}
