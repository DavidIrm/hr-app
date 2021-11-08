package com.sda.project.mapper;


import com.sda.project.dto.CompanyDto;
import com.sda.project.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company map(CompanyDto dto){
        Company entity = new Company();
        entity .setName(dto.getName());
        entity.setLocation(dto.getLocation());

        return entity;
    }

    public CompanyDto map(Company entity){
        CompanyDto dto = new CompanyDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        return dto;

    }


}
