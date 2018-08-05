package com.example.demo.data.repository.base;

import com.example.demo.data.entity.base.DataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public interface BaseRepository<T extends DataEntity, ID extends Serializable> extends MongoRepository<T, ID> {

}
