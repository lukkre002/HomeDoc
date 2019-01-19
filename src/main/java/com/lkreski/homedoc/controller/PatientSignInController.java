package com.lkreski.homedoc.controller;

import com.google.common.hash.Hashing;
import com.lkreski.homedoc.model.HomeVisit;
import com.lkreski.homedoc.service.HomeVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class PatientSignInController {

    @Autowired
     HomeVisitService homeVisitService;



    @RequestMapping("/patientSignIn")
    public String signIn(Model model) throws NoSuchAlgorithmException {
        model.addAttribute("homeVisit", new HomeVisit());
        String originalString = "PfyPuBxoowYLeuCGqQwIj59JUTzEqa3w"+"dev"+"723751"+"322.00"+"PLN"+"aaac";

        String sha256hex = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
        String result = "https://ssl.dotpay.pl/test_payment/?api_version=dev&id=723751&kwota=322.00&waluta=PLN&opis=aaac&chk="+sha256hex;
        return "patientsignin";
    }

    @RequestMapping(value = "/patientSignIn/add", method = RequestMethod.POST)
    public String addNewVisit(@Valid HomeVisit homeVisit, BindingResult result, Model model){
        System.out.println(homeVisit);
        homeVisitService.addVisit(homeVisit);
        return "patientsigninStep2";
    }



}
