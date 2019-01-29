package com.lkreski.homedoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/doctorSignUp")
public class DoctorSignUpController {
    @GetMapping
    public String show(WebRequest request, Model model){
        return "registration";
    }
}
