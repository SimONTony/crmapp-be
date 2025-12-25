package com.crmapp.addresses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressToAddressDtoConverter addressEntityToAddressDtoConverter;
    private final AddressesRepository addressesRepository;
    private final AddressesDtoToAddressesEntityConverter addressesDtoToAddressesEntityConverter;

    @Autowired
    public AddressServiceImpl(AddressToAddressDtoConverter addressEntityToAddressDtoConverter, AddressesRepository addressesRepository, AddressesDtoToAddressesEntityConverter addressesDtoToAddressesEntityConverter) {
        this.addressEntityToAddressDtoConverter = addressEntityToAddressDtoConverter;
        this.addressesRepository = addressesRepository;
        this.addressesDtoToAddressesEntityConverter = addressesDtoToAddressesEntityConverter;
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressesRepository.findAll();
        List<AddressDto> addressesDtos = addresses.stream()
                .map(addressesEntity -> addressEntityToAddressDtoConverter.convert(addressesEntity))
                .toList();
        log.info("getAllAddresses: addressesDtos: " + addressesDtos);
        return addressesDtos;
    }

    @Override
    public AddressDto getAddressById(Long addressId) {
        Address address = addressesRepository.findById(addressId)
                .orElseThrow(() -> new IllegalArgumentException("Address was not found"));
        AddressDto addressDto = addressEntityToAddressDtoConverter.convert(address);
        log.info("getAddressById addressId: {}", addressDto.getAddressId());
        return addressDto;
    }

    @Override
    public void deleteCompany(Long addressId) {
        addressesRepository.deleteById(addressId);
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        Address addressEntity = addressesDtoToAddressesEntityConverter.convert(addressDto);
        Address saved = addressesRepository.save(addressEntity);
        return addressEntityToAddressDtoConverter.convert(saved);
    }

    @Override
    public AddressDto editAddress(AddressDto addressDto) {
        Address addressEntity = addressesDtoToAddressesEntityConverter.convert(addressDto);
        Address updatedAddress = addressesRepository.save(addressEntity);
        return addressEntityToAddressDtoConverter.convert(updatedAddress);
    }

}
