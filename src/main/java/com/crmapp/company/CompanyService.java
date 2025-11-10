package com.crmapp.company;


import com.crmapp.company.converter.CompanyDtoToCompanyEntityConverter;
import com.crmapp.company.converter.CompanyEntityToCompanyDtoConverter;
import com.crmapp.company.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyEntityToCompanyDtoConverter companyEntityToCompanyDtoConverter;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyDtoToCompanyEntityConverter companyDtoToCompanyEntityConverter;


    public List<CompanyDto> getAllCompanies() {
        List<CompanyEntity> companies = companyRepository.findAll();
        List<CompanyDto> companyDtos = companies.stream()
                .map(companyEntity -> companyEntityToCompanyDtoConverter.convert(companyEntity))
                .toList();
        return companyDtos;
    }


    public CompanyDto getCompanyById(Integer companyId) {
        CompanyEntity company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company was not found"));
        CompanyDto companyDto = companyEntityToCompanyDtoConverter.convert(company);
        return companyDto;
    }


    public void deleteCompany(Integer companyId) {
        companyRepository.deleteById(companyId);
    }


    public CompanyDto addCompany(CompanyDto companyDto) {
        CompanyEntity companyEntity = companyDtoToCompanyEntityConverter.convert(companyDto);
        CompanyEntity saved = companyRepository.save(companyEntity);
        return companyEntityToCompanyDtoConverter.convert(saved);
    }

}

