package com.lkreski.homedoc.controller;

import com.lkreski.homedoc.model.HomeVisit;
import com.lkreski.homedoc.service.HomeVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientSignIn {

    private HomeVisitService homeVisitService;

    @Autowired(required = true)
    @Qualifier(value = "homeVisitService")
    public void setHomeVisitService(HomeVisitService visitService){
        this.homeVisitService = visitService;
    }


    @RequestMapping("/patientSignIn")
    public String signIn(){
        return "patientsignin";
    }

    @RequestMapping(value = "/patientSignIn/add", method = RequestMethod.POST)
    public String addNewVisit(){
        return "patientsignin";
    }

}
