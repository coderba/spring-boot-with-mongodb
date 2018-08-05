package com.example.demo.controller;

import com.example.demo.controller.base.GlobalExceptionHandler;
import com.example.demo.data.entity.Numerus;
import com.example.demo.data.model.Message;
import com.example.demo.data.service.NumerusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


import static com.example.demo.helper.Constant.ASCENDING;
import static com.example.demo.helper.Constant.DESCENDING;

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

    @GetMapping(value = "numerus/{param}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity getNumerusByNumber(@PathVariable String param) {

        if (param.matches("[0-9]+") && param.length() > 0) {
            return ResponseEntity.ok(numerusService.getNumerusByNumber(Integer.valueOf(param)));
        } else if (param.contains("[a-zA-Z]+") == false && param.length() > 0) {
            if (param.equals(DESCENDING) || param.equals(ASCENDING)) {
                return ResponseEntity.ok(numerusService.getNumerusAll(param));
            } else {
                return ResponseEntity.badRequest().body(new Message("wrong params"));
            }
        }

        return ResponseEntity.badRequest().body(new Message("wrong params"));
    }

    @GetMapping(value = "numerus", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity getNumerus() {
        return ResponseEntity.ok(numerusService.getNumerusAll(ASCENDING));
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
