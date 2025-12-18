package com.crmapp.addresses;

import com.crmapp.company.CompanyDto;
import com.crmapp.company.CompanyEntity;
import com.crmapp.company.CompanyRepository;
import com.crmapp.company.converter.CompanyDtoToCompanyEntityConverter;
import com.crmapp.company.converter.CompanyEntityToCompanyDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressesService {


    @Autowired
    private AddressEntityToCompanyDtoConverter companyEntityToCompanyDtoConverter;

    @Autowired
    private AddressesRepository addressesRepository;

    @Autowired
    private AddressesDtoToCompanyEntityConverter addressesDtoToCompanyEntityConverter;



    public List<`AddressDto`> getAllAddresses() {
        List<AddressesEntity> addresses = addressesRepository.findAll();
        List<AddressesDto> addressesDtos = addresses.stream()
                .map(addressesEntity -> addressesEntityToAddressesDtoConverter.convert(addressesEntity))
                .toList();
        return addressesDtos;
    }



}
