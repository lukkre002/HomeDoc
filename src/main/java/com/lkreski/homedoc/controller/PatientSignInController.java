package com.lkreski.homedoc.controller;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.lkreski.homedoc.model.Doctor;
import com.lkreski.homedoc.model.Dotpay;
import com.lkreski.homedoc.model.HomeVisit;
import com.lkreski.homedoc.service.DoctorService;
import com.lkreski.homedoc.service.DotpayService;
import com.lkreski.homedoc.service.HomeVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.AsyncRestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Controller
public class PatientSignInController {
    String result;

    @Autowired
    private HomeVisitService homeVisitService;
    @Autowired
    private DotpayService dotpayService;
    @Autowired
    private HttpServletRequest context;
    @Autowired
    private DoctorService doctorService;

    public String description=new String();



    @RequestMapping("/patientSignIn")
    public String signIn(Model model) throws NoSuchAlgorithmException {
        model.addAttribute("homeVisit", new HomeVisit());

        return "patientsignin";
    }

    @RequestMapping(value = "/patientSignIn/add", method = RequestMethod.POST)
    public String addNewVisit(@Valid HomeVisit homeVisit, BindingResult result, Model model){
        System.out.println(homeVisit);

        return patientSigninStep2(homeVisit, model);
    }

    @RequestMapping(value = "/patientSignIn/step2", method = RequestMethod.POST)
    public String patientSigninStep2(HomeVisit homeVisit,  Model model){
        List<String> cityList = new ArrayList<>();
        List<Doctor> doctorList = doctorService.findAllByCity(homeVisit.getCity());
        for(Doctor doc: doctorList){
            cityList.add(doc.getCity());
        }
        if(cityList.contains(homeVisit.getCity().trim())){
            homeVisitService.addVisit(homeVisit);
            model.addAttribute("homeVisit", homeVisit);

            return step2Registration(homeVisit, model);
        }
        else {
            return regFailed();
        }

    }

    @GetMapping("/patientSignIn/step2Registration")
    public String step2Registration(HomeVisit homeVisit,  Model model){
        model.addAttribute("homeVisit", homeVisit);
        homeVisit.toString();
        return "step2Registration";
    }
    @RequestMapping(value = "/goToDotPay", method = RequestMethod.POST)
    public String goToDotPay(@ModelAttribute("homeVisit") HomeVisit homeVisit, Model model){

        String description = "Wizyta HomeDoc numer "+homeVisit.getId().toString();
        String control = homeVisit.getId().toString();

        HashMap<String,String> checkerValues = new HashMap<>();
        checkerValues.put("PIN","PfyPuBxoowYLeuCGqQwIj59JUTzEqa3w");
        checkerValues.put("api_version","dev");
        checkerValues.put("id","723751");
        checkerValues.put("amount","322.00");
        checkerValues.put("currency","PLN");
        checkerValues.put("description",description);
        checkerValues.put("ignore_last_payment_channel","1");
//            checkerValues.put("ignore_last_payment_channel","1");
        checkerValues.put("channel_groups","K,T,P,M");
        checkerValues.put("url","http://192.168.0.12:8080/patientSignIn/regCompleted");
        checkerValues.put("control",control);
        checkerValues.put("type","0");
        checkerValues.put("buttontext","Wróc do HomeDoc");

        String s = dotpayService.generateChk(checkerValues);
        String hashCode = Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString();

        String result2 = "https://ssl.dotpay.pl/test_payment/?api_version=dev&id=723751&kwota=322.00&waluta=PLN&opis=" +description+
                "&ignore_last_payment_channel=1&grupykanalow=K,T,P,M&URL=http://192.168.0.12:8080/patientSignIn/regCompleted&typ=0&txtguzik=Wróc do HomeDoc&control="+control+"&chk="+hashCode;
        return "redirect:"+result2;
    }

    @PostMapping("/patientSignIn/regCompleted")
    public String regComplited(@RequestParam String status){

        return null;
    }
    @GetMapping("/patientSignIn/patientsigninFailedNoDocs")
    public String regFailed(){
        return "patientsigninFailedNoDocs";
    }

    @GetMapping(path = "/testingAsync")
    public ListenableFuture<ResponseEntity<Dotpay>> value() throws ExecutionException, InterruptedException, TimeoutException {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        String baseUrl = "https://api.github.com/users/XXX";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String value = "";

        HttpEntity entity = new HttpEntity("parameters", requestHeaders);
        return restTemplate.getForEntity(baseUrl, Dotpay.class);
    }



}
