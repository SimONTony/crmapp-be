package com.crmapp.company;

import com.crmapp.company.converter.CompanyDtoToCompanyEntityConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

@Autowired
private CompanyService companyService;

@Autowired
private CompanyDtoToCompanyEntityConverter companyDtoToCompanyEntityConverter;



@GetMapping
public List<CompanyDto> getAllCompanies() {
    List<CompanyDto> companies = companyService.getAllCompanies();
    return companies;
}

    @GetMapping(value = "/{companyId}")
    public CompanyDto getCompanyById(@PathVariable Integer companyId) {
        CompanyDto company = companyService.getCompanyById((companyId));
        return company;
    }


    @DeleteMapping(value = "/{companyId}")
    public void deleteCompany(@PathVariable Integer companyId) {
        companyService.deleteCompany(companyId);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto saveCompany = companyService.addCompany(companyDto);
        return ResponseEntity.ok(saveCompany);
    }
}
