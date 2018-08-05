package com.example.demo.data.entity.base;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class DataEntity {

    @Id
    protected String id;

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEntity that = (DataEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
