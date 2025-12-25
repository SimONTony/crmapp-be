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
    private AddressesDtoToAddressesEntityConverter addressesDtoToAddressesEntityConverter;


    @GetMapping
    public List<AddressDto> getAllAddresses() {
        List<AddressDto> addresses = addressService.getAllAddresses();
        return addresses;
    }

    @GetMapping(value = "/{addressId}")
    public AddressDto getAddressById(@PathVariable Long addressId) {
        AddressDto address = addressService.getAddressById((addressId));
        return address;
    }


    @DeleteMapping(value = "/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressService.deleteCompany(addressId);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
        AddressDto saveAddress = addressService.addAddress(addressDto);
        return ResponseEntity.ok(saveAddress);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<AddressDto> editAddress(@RequestBody AddressDto addressDto) {
        AddressDto updatedAddress = addressService.editAddress(addressDto);
        return ResponseEntity.ok(updatedAddress);
    }



}
