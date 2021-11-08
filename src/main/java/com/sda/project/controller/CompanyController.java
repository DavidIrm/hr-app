package com.sda.project.controller;

import com.sda.project.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String showCompaniesPage(Model model){
        model.addAttribute("companiesDto", companyService.findAll());
        return "company/companies";
    }

    // TODO: /companies/{id}/edit

    // TODO: /companies/{id}/delete
}
