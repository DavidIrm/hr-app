package com.sda.project.controller;

import com.sda.project.DTO.UserDto;
import com.sda.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


    @GetMapping(value = "/register")
    public String getRegistrationpage(Model model) {
        System.out.println("S-a apelat get Registration page");
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "register";

    }


    @PostMapping(value = "/register")
    public String postRegistrationPage(@ModelAttribute UserDto userDto) {
        System.out.println("S-a apelat post Registration page");
        System.out.println(userDto);


        //   userService.addUser(userDto);
        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    public String showHome(Model model) {

        return "home";

    }
}
