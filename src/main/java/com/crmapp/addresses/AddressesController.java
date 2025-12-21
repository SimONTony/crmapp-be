package com.crmapp.addresses;


import com.crmapp.company.CompanyDto;
import com.crmapp.company.converter.CompanyDtoToCompanyEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AddressesController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CompanyDtoToCompanyEntityConverter companyDtoToCompanyEntityConverter;

//
//    @GetMapping
//    public List<CompanyDto> getAllAddresses() {
//        List<CompanyDto> companies = addressService.getAllAddresses();
//        return companies;
//    }
//
//    @GetMapping(value = "/{companyId}")
//    public CompanyDto getCompanyById(@PathVariable Long companyId) {
//        CompanyDto company = addressService.getAddressessById((companyId));
//        return company;
//    }
//
//
//    @DeleteMapping(value = "/{companyId}")
//    public void deleteCompany(@PathVariable Long companyId) {
//        addressService.deleteCompany(companyId);
//
//    }
//
//    @PostMapping(value = "/add")
//    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
//        CompanyDto saveCompany = addressService.addCompany(companyDto);
//        return ResponseEntity.ok(saveCompany);
//    }
//
//    @PutMapping(value = "/edit")
//    public ResponseEntity<CompanyDto> editCompany(@RequestBody CompanyDto companyDto) {
//        CompanyDto updatedCompany = addressService.editAddress(companyDto);
//        return ResponseEntity.ok(updatedCompany);
//    }
//


}
