package com.crmapp.addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressEntityToAddressDtoConverter addressEntityToAddressDtoConverter;

    @Autowired
    private AddressesRepository addressesRepository;

    @Autowired
    private AddressesDtoToAddressesEntityConverter addressesDtoToAddressesEntityConverter;

//
//
//    public List<AddressDto> getAllAddresses() {
//        List<AddressEntity> addresses = addressesRepository.findAll();
//        List<AddressEntity> addressesDtos = addresses.stream()
//                .map(addressesEntity -> addressEntityToAddressDtoConverter.convert(addressesEntity))
//                .toList();
//        return addressesDtos;
//    }
//


}
