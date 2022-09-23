package com.cydeo.controller;

import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String profilePage(Model model){

        Profile profile = new Profile("violetta@gmail.com", "256-570-6124", "Violetta", "Queen", "Vi123", LocalDateTime.of(2021,12,5, 12, 34));
        model.addAttribute("profile", profile);


        return "profile/profile-info.html";
    }
}
