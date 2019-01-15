package com.lkreski.homedoc.dao;

import com.lkreski.homedoc.model.HomeVisit;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeVisitDaoImpl implements HomeVisitDao {
    private static final Logger logger = LoggerFactory.getLogger(HomeVisitDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }



    @Override
    public void addHomeVisit(HomeVisit visit) {
        getSession().saveOrUpdate(visit);
        logger.info("Wizyta zapisana prawidłowo." + visit);

    }
}
