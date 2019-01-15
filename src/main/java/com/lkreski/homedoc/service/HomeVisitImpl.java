package com.lkreski.homedoc.service;

import com.lkreski.homedoc.dao.HomeVisitDao;
import com.lkreski.homedoc.model.HomeVisit;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("homeVisitService")
@Transactional
public class HomeVisitImpl implements HomeVisitService {

     HomeVisitDao homeVisitDao;

     @Autowired
     public void setHomeVisitDao(HomeVisitDao homeVisitDao){
         this.homeVisitDao=homeVisitDao;
     }
    @Override
    @Transactional
    public void addVisit(HomeVisit visit) {
    this.homeVisitDao.addHomeVisit(visit);
    }
}
