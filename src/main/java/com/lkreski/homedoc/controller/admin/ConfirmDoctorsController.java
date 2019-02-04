package com.lkreski.homedoc.controller.admin;

import com.lkreski.homedoc.model.Doctor;
import com.lkreski.homedoc.model.Role;
import com.lkreski.homedoc.model.User;
import com.lkreski.homedoc.service.DoctorService;
import com.lkreski.homedoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class ConfirmDoctorsController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/doctors", method = RequestMethod.GET)
    public ModelAndView applyDoctors(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("doctors", doctorService.findAllNotVerified());
        modelAndView.setViewName("admin/doctors");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/details", method = RequestMethod.GET)
    public ModelAndView viewSingleDoctor(@RequestParam("param") String did, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Doctor doctor = doctorService.findByDid(Integer.parseInt(did));
        model.addAttribute("doctor", doctor);
        modelAndView.setViewName("admin/details");

        return modelAndView;
    }

    @RequestMapping(value = "/admin/download", method = RequestMethod.GET, params = {"confirm"})
    public ModelAndView acceptDoctor(Doctor doctor, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Doctor byDid = doctorService.findByDid(doctor.getDid());
        Role doctorRole = userService.findByRole("Doctor");
        Role userRole = userService.findByRole("USER");
        User user = byDid.getUser();
        HashSet<Role> roleHashSet = new HashSet<Role>(Arrays.asList(doctorRole, userRole));
        byDid.setVerified(true);
        doctorService.updateDoctor(byDid);
        userService.saveDoctorUser(user, roleHashSet);
        modelAndView.setViewName("admin/doctors");
        return modelAndView;

    }

    @RequestMapping(value = "/admin/download", method = RequestMethod.GET, params = {"show"})
    public void downloadFile3(Doctor doctor, HttpServletResponse resonse) throws IOException {
        Doctor byDid = doctorService.findByDid(doctor.getDid());
        File file = new File(byDid.getDiploma());

        resonse.setContentType("application/pdf");
        resonse.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
        BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = inStrem.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        inStrem.close();
    }
}
