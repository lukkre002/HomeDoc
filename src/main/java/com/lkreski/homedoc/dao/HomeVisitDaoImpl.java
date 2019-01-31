package com.lkreski.homedoc.dao;

import com.lkreski.homedoc.model.HomeVisit;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class HomeVisitDaoImpl implements HomeVisitDao {
    private static final Logger logger = LoggerFactory.getLogger(HomeVisitDaoImpl.class);

    @Autowired
    EntityManager entityManagerFactory;


    protected Session getSession(){
        SessionFactory unwrap = entityManagerFactory.unwrap(SessionFactory.class);
        return unwrap.getCurrentSession();
    }



    @Override
    public void addHomeVisit(HomeVisit visit) {
        entityManagerFactory.persist(visit);
        logger.info("Wizyta zapisana prawidłowo." + visit);

    }
}
