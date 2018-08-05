package com.example.demo.controller;

import com.example.demo.controller.base.GlobalExceptionHandler;
import com.example.demo.data.entity.Numerus;
import com.example.demo.data.model.Message;
import com.example.demo.data.service.NumerusServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController extends GlobalExceptionHandler {

    @Autowired
    NumerusServiceImpl numerusService;

    @GetMapping("hello")
    public void mainMethod() {
        System.out.println("logi log");
    }

    @PostMapping(value = "numerus", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    private ResponseEntity addNumerus(@RequestBody Numerus numerus) {

        Numerus numerusTEMP = numerusService.getNumerusByNumber(numerus.getNumber());

        if (ObjectUtils.isEmpty(numerusTEMP)) {
            return ResponseEntity.ok(numerusService.addNumerus(numerus));
        } else {
            return ResponseEntity.badRequest().body(new Message("already exist"));
        }

    }

    @GetMapping(value = "numerus/{number}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<Numerus> getNumerusByNumber(@PathVariable int number) {
        return ResponseEntity.ok(numerusService.getNumerusByNumber(number));
    }

    @GetMapping(value = "numerus", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<List<Numerus>> getNumerus() {
        return ResponseEntity.ok(numerusService.getNumerusAll());
    }


    @DeleteMapping(value = "numerus/{number}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity deleteNumerus(@PathVariable int number) {
        if (numerusService.removeNumerusByNumber(number).equals(1)) {
            return ResponseEntity.ok(numerusService.removeNumerusByNumber(number));
        } else {
            return ResponseEntity.badRequest().body(new Message("not found"));
        }

    }

}
