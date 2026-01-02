package com.crmapp.addresses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplVer2 implements AddressService {

    private final AddressesRepository addressesRepository;

    @Autowired
    public AddressServiceImplVer2(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        return List.of();
    }

    @Override
    public AddressDto getAddressById(Long addressId) {
        return null;
    }

    @Override
    public void delete(Long addressId) {

    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto editAddress(AddressDto addressDto) {
        return null;
    }
}
