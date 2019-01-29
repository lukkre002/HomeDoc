package com.lkreski.homedoc.dao;

import com.lkreski.homedoc.model.Doctor;

import java.io.Serializable;
import java.util.List;

public interface DoctorDao<T, Id extends Serializable> {
    public void persist(T entity);
    public void update(T entity);
    public T findById(Id id);
    public List<T> findAll();
    public void delete(T entity);
    public List<T> findAllByCity(String city);


    }
