package com.lkreski.homedoc.service;

import com.lkreski.homedoc.dao.HomeVisitDao;
import com.lkreski.homedoc.model.HomeVisit;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("homeVisitService")
public class HomeVisitImpl implements HomeVisitService {

    @Setter
    private HomeVisitDao homeVisitDao;
    @Override
    @Transactional
    public void addVisit(HomeVisit visit) {
    this.homeVisitDao.addHomeVisit(visit);
    }
}
