package com.sofkau.mysql.repository;

import com.sofkau.mysql.model.Cita;

import java.util.List;

public interface IRepository<T> {

    List<T> findAll();
    T findById(Long id);

    void save(T value);


}
