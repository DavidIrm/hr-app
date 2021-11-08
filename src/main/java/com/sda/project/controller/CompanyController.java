package com.sda.project.controller;


import com.sda.project.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CompanyController {

    private final CompanyService companyService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/company")
    public String showCompany(Model model){

        model.addAttribute("companyDto", companyService.findAll());
        return "company";
    }

}
