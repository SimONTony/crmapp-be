package com.crmapp.company;

import com.crmapp.company.converter.CompanyDtoToCompanyEntityConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CompanyDto getCompanyById(@PathVariable Long companyId) {
        CompanyDto company = companyService.getCompanyById((companyId));
        return company;
    }


    @DeleteMapping(value = "/{companyId}")
    public void deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto saveCompany = companyService.addCompany(companyDto);
        return ResponseEntity.ok(saveCompany);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<CompanyDto> editCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto updatedCompany = companyService.editCompany(companyDto);
        return ResponseEntity.ok(updatedCompany);
    }
}
