package com.crmapp.addresses;

import com.crmapp.company.CompanyDto;
import com.crmapp.company.CompanyEntity;
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



    public List<AddressDto> getAllAddresses() {
        List<AddressEntity> addresses = addressesRepository.findAll();
        List<AddressDto> addressesDtos = addresses.stream()
                .map(addressesEntity -> addressEntityToAddressDtoConverter.convert(addressesEntity))
                .toList();
        return addressesDtos;
    }


    public AddressDto getAddressById(Long addressId) {
        AddressEntity address = addressesRepository.findById(addressId)
                .orElseThrow(() -> new IllegalArgumentException("Address was not found"));
        AddressDto addressDto = addressEntityToAddressDtoConverter.convert(address);
        return addressDto;
    }


    public void deleteCompany(Long addressId) {
        addressesRepository.deleteById(addressId);
    }


    public AddressDto addAddress(AddressDto addressDto) {
        AddressEntity addressEntity = addressesDtoToAddressesEntityConverter.convert(addressDto);
        AddressEntity saved = addressesRepository.save(addressEntity);
        return addressEntityToAddressDtoConverter.convert(saved);
    }

    public AddressDto editAddress(AddressDto addressDto) {
        AddressEntity addressEntity = addressesDtoToAddressesEntityConverter.convert(addressDto);
        AddressEntity updatedAddress = addressesRepository.save(addressEntity);
        return addressEntityToAddressDtoConverter.convert(updatedAddress);

    }

}
