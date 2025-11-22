package com.crmapp.company;


import com.crmapp.company.converter.CompanyDtoToCompanyEntityConverter;
import com.crmapp.company.converter.CompanyEntityToCompanyDtoConverter;
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


    public CompanyDto getCompanyById(Long companyId) {
        CompanyEntity company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company was not found"));
        CompanyDto companyDto = companyEntityToCompanyDtoConverter.convert(company);
        return companyDto;
    }


    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }


    public CompanyDto addCompany(CompanyDto companyDto) {
        CompanyEntity companyEntity = companyDtoToCompanyEntityConverter.convert(companyDto);
        CompanyEntity saved = companyRepository.save(companyEntity);
        return companyEntityToCompanyDtoConverter.convert(saved);
    }

    public CompanyDto editCompany(CompanyDto companyDto) {
        CompanyEntity companyEntity = companyDtoToCompanyEntityConverter.convert(companyDto);
        CompanyEntity updatedCompany = companyRepository.save(companyEntity);
        return companyEntityToCompanyDtoConverter.convert(updatedCompany);
    }
}

