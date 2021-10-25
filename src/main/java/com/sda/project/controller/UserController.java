package com.sda.project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @GetMapping(value ="/home")
    public String getHomePage(){
        return "home";

    }

}
