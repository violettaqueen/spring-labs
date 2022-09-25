package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createEmployee());
        return "employee/register";
    }
}
