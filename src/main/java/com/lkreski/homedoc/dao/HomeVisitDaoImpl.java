package com.lkreski.homedoc.dao;

import com.lkreski.homedoc.model.HomeVisit;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeVisitDaoImpl implements HomeVisitDao {
    private static final Logger logger = LoggerFactory.getLogger(HomeVisitDaoImpl.class);
    @Setter
    private SessionFactory sessionFactory;



    @Override
    public void addHomeVisit(HomeVisit visit) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(visit);
        logger.info("Wizyta zapisana prawidłowo." + visit);

    }
}
