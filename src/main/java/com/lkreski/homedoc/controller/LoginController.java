package com.lkreski.homedoc.controller;

import com.lkreski.homedoc.model.Doctor;
import com.lkreski.homedoc.model.User;
import com.lkreski.homedoc.service.DoctorService;
import com.lkreski.homedoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    private static String UPLOADED_FOLDER = "D://aaInzynierka//";

    @RequestMapping(value = "/doctor/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Witaj " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("user", user);
        Doctor doctor = doctorService.findByUser(user);
        if (doctor==null) {
            doctor = new Doctor();
        }
        modelAndView.addObject("doctor", doctor);
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("doctor/home");
        return modelAndView;
    }

    @RequestMapping(value = "/doctor/home", method = RequestMethod.POST)
    public ModelAndView homePost(@Valid Doctor doctor, @RequestParam("file") MultipartFile file, BindingResult bindingResult, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String userName = principal.getName();
        User userByEmail = userService.findUserByEmail(userName);
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
        } else {
            doctor.setVerified(false);
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path,bytes);
                doctor.setDiploma(UPLOADED_FOLDER+file.getOriginalFilename());
                doctorService.saveDoctor(doctor, userByEmail);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "Istnieje już użytkownik ze wskazanym adresem email");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Użytkownik został dodany poprawnie");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
}
