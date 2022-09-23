package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
@RequestMapping("/login/{email}/{phoneNumber}")
    public String loginPage(@PathVariable String email, @PathVariable String phoneNumber, Model model){

    model.addAttribute("email", email);
    model.addAttribute("phoneNumber", phoneNumber);
    model.addAttribute("loginMessage", "Login successfull");

    return "login/login-info";
    }
}
