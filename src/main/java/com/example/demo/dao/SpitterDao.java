package com.example.demo.dao;

import com.example.demo.model.Spitter;

/**
 * Created by OL-PC on 2018/04/11.
 */
public interface SpitterDao {
    Spitter save(Spitter spitter);
    Spitter findById(Integer id);
}
