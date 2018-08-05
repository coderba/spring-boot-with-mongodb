package com.example.demo.data.entity;

import com.example.demo.data.entity.base.DataEntity;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Objects;

public class Numerus extends DataEntity {

    @Indexed(unique = true)
    public int number;

    public String insert_date;

    public Numerus() {
    }

    public Numerus(int number, String insert_date) {
        this.number = number;
        this.insert_date = insert_date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getinsert_date() {
        return insert_date;
    }

    public void setinsert_date(String insert_date) {
        this.insert_date = insert_date;
    }

    @Override
    public String toString() {
        return "Numerus{" +
                "id=" + id +
                ", number=" + number +
                ", insert_date='" + insert_date + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Numerus numerus = (Numerus) o;
        return number == numerus.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), number);
    }
}
