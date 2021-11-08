package com.sda.project.service;


import com.sda.project.dto.CompanyDto;
import com.sda.project.mapper.CompanyMapper;
import com.sda.project.model.Company;
import com.sda.project.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.CheckedOutputStream;

@Service
public class CompanyService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final CompanyRepository componyRepository;
    private final CompanyMapper companyMapper;
    private UserService userService;


    @Autowired
    public CompanyService(CompanyRepository componyRepository, CompanyMapper companyMapper, UserService userService) {
        this.componyRepository = componyRepository;
        this.companyMapper = companyMapper;
        this.userService = userService;
    }

    public CompanyDto save(CompanyDto companyDto){
        Company company = companyMapper.map(companyDto);
        Company  savedCompany = componyRepository.save(company);
        CompanyDto savedDto = companyMapper.map(savedCompany);
        return savedDto;

    }

    public List<CompanyDto> findAll(){
        return componyRepository.findAll().stream()
                .map(company-> companyMapper.map(company))
                .collect(Collectors.toList());
    }
}
