package com.example.demo.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Number {

    @Indexed(unique = true)
    public int number;
    public String insertDate;
    @Id
    private String id;

    public Number() {
    }

    public Number(int number, String insertDate) {
        this.number = number;
        this.insertDate = insertDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", number=" + number +
                ", insertDate='" + insertDate + '\'' +
                '}';
    }
}
