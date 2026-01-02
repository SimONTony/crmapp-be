package com.crmapp.addresses;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAllAddresses();

    AddressDto getAddressById(Long addressId);

    void delete(Long addressId);

    AddressDto addAddress(AddressDto addressDto);

    AddressDto editAddress(AddressDto addressDto);
}
