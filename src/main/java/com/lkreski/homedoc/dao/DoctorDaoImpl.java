package com.lkreski.homedoc.dao;

import com.lkreski.homedoc.model.Doctor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.print.Doc;
import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao<Doctor, Integer> {



    @Autowired
    EntityManagerFactory entityManagerFactory;


    protected Session getSession(){
        Session unwrap = entityManagerFactory.unwrap(Session.class);
        return unwrap;
    }
    @Override
    public void persist(Doctor entity) {

    }

    @Override
    public void update(Doctor entity) {

    }

    @Override
    public Doctor findById(Integer integer) {
        return null;
    }

    @Override
    public List<Doctor> findAll() {
        return null;
    }

    @Override
    public void delete(Doctor entity) {

    }
    @Override
    public List<Doctor> findAllByCity(String city){
//    Session session = getSession();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Doctor.class);
        List<Doctor> list= criteria.add(Restrictions.eq("city", city)).add(Restrictions.eq("verified", true)).list();
return list;
    }
}
