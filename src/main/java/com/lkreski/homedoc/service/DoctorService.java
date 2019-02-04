package com.lkreski.homedoc.service;

import com.lkreski.homedoc.dao.DoctorDao;
import com.lkreski.homedoc.model.Doctor;
import com.lkreski.homedoc.model.User;
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
        return this.doctorDao.findAllByCityAndVerified(city,true);
    }
    @Transactional
    public List<Doctor> findAll(String city){
        return this.doctorDao.findAll();
    }
    @Transactional
    public List<Doctor> findAllNotVerified(){
        return this.doctorDao.findAllByVerified(false);
    }
    @Transactional
    public Doctor findByDid(int did){
        return this.doctorDao.findByDid(did);
    }


    @Transactional
    public Doctor findByUser(User user){return this.doctorDao.findByUser(user);
    }
    public void saveDoctor(Doctor doctor, User user){
        doctor.setUser(user);
        doctorDao.save(doctor);
    }
    public void updateDoctor(Doctor doctor){
        doctorDao.save(doctor);
    }
}
