package com.lkreski.homedoc.controller;

import com.lkreski.homedoc.model.HomeVisit;
import com.lkreski.homedoc.service.HomeVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PatientSignInController {

    @Autowired
     HomeVisitService homeVisitService;



    @RequestMapping("/patientSignIn")
    public String signIn(Model model){
        model.addAttribute("homeVisit", new HomeVisit());
        return "patientsignin";
    }

    @RequestMapping(value = "/patientSignIn/add", method = RequestMethod.POST)
    public String addNewVisit(@Valid HomeVisit homeVisit, BindingResult result, Model model){
        System.out.println(homeVisit);
        homeVisitService.addVisit(homeVisit);
        return "patientsignin";
    }

}