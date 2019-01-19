package com.lkreski.homedoc.controller;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.lkreski.homedoc.model.HomeVisit;
import com.lkreski.homedoc.service.DotpayService;
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
import java.util.HashMap;

@Controller
public class PatientSignInController {

    @Autowired
     HomeVisitService homeVisitService;
    @Autowired
    DotpayService dotpayService;



    @RequestMapping("/patientSignIn")
    public String signIn(Model model) throws NoSuchAlgorithmException {
        model.addAttribute("homeVisit", new HomeVisit());

        HashMap<String,String> checkerValues = new HashMap<>();
        checkerValues.put("PIN","PfyPuBxoowYLeuCGqQwIj59JUTzEqa3w");
        checkerValues.put("api_version","dev");
        checkerValues.put("id","723751");
        checkerValues.put("amount","322.00");
        checkerValues.put("currency","PLN");
        checkerValues.put("description","aaac");
        checkerValues.put("ignore_last_payment_channel","1");
        checkerValues.put("ignore_last_payment_channel","1");
        checkerValues.put("channel_groups","K,T,P,M");
        checkerValues.put("url","http://localhost:8080/patientSignIn/step2");
        checkerValues.put("type","0");
        checkerValues.put("buttontext","Wróc do HomeDoc");
        String s = dotpayService.generateChk(checkerValues);
        String hashCode = Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString();

        String result2 = "https://ssl.dotpay.pl/test_payment/?api_version=dev&id=723751&kwota=322.00&waluta=PLN&opis=aaac" +
                "&ignore_last_payment_channel=1&grupykanalow=K,T,P,M&URL=http://localhost:8080/patientSignIn/step2&typ=0&txtguzik=Wróc do HomeDoc&chk="+hashCode;



        return "patientsignin";
    }

    @RequestMapping(value = "/patientSignIn/add", method = RequestMethod.POST)
    public String addNewVisit(@Valid HomeVisit homeVisit, BindingResult result, Model model){
        System.out.println(homeVisit);
        homeVisitService.addVisit(homeVisit);
        HashMap<String,String> checkerValues = new HashMap<>();
        checkerValues.put("PIN","PfyPuBxoowYLeuCGqQwIj59JUTzEqa3w");
        checkerValues.put("api_version","dev");
        checkerValues.put("id","723751");
        checkerValues.put("amount","322.00");
        checkerValues.put("currency","PLN");
        checkerValues.put("description","aaac");
        checkerValues.put("ignore_last_payment_channel","1");
        checkerValues.put("ignore_last_payment_channel","1");
        checkerValues.put("channel_groups","K,T,P,M");
        checkerValues.put("url","http://localhost:8080/patientSignIn/step2");
        checkerValues.put("type","0");
        checkerValues.put("buttontext","Wróc do HomeDoc");
        String s = dotpayService.generateChk(checkerValues);
        String hashCode = Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString();

        String result2 = "https://ssl.dotpay.pl/test_payment/?api_version=dev&id=723751&kwota=322.00&waluta=PLN&opis=aaac" +
                "&ignore_last_payment_channel=1&grupykanalow=K,T,P,M&URL=http://localhost:8080/patientSignIn/step2&typ=0&txtguzik=Wróc do HomeDoc&chk="+hashCode;
        return "redirect:"+result2;
    }

    @RequestMapping(value = "/patientSignIn/step2", method = RequestMethod.GET)
    public String patientSigninStep2(){

        return "patientsigninStep2";
    }



}
