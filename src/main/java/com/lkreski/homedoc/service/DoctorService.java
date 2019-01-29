package com.lkreski.homedoc.service;

import com.lkreski.homedoc.dao.DoctorDao;
import com.lkreski.homedoc.dao.DoctorDaoImpl;
import com.lkreski.homedoc.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("doctorService")
@Transactional
public class DoctorService {
    private DoctorDao doctorDao;

    @Autowired
    public void setDoctorDao(DoctorDao doctorDao){
        this.doctorDao = doctorDao;
    }

    @Transactional
    public List<Doctor> findAllByCity(String city){
        return this.doctorDao.findAllByCity(city);
    }
}
