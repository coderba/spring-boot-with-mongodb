package com.example.demo.data.entity;

import com.example.demo.data.entity.base.DataEntity;
import org.springframework.data.mongodb.core.index.Indexed;

public class Numerus extends DataEntity {

    @Indexed(unique = true)
    public int number;
    public String insertDate;

    public Numerus() {
    }

    public Numerus(int number, String insertDate) {
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
        return "Numerus{" +
                "id=" + id +
                ", number=" + number +
                ", insertDate='" + insertDate + '\'' +
                '}';
    }
}
