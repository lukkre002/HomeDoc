package com.lkreski.homedoc.dao;

import com.lkreski.homedoc.model.Doctor;
import com.lkreski.homedoc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.io.Serializable;
import java.util.List;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long>{
    Doctor findByUser(User user);
    List<Doctor> findAllByCityAndVerified(String city, Boolean very);
    List<Doctor> findAll();
    List<Doctor> findAllByVerified(Boolean verified);
    Doctor findByDid(int did);

    }
