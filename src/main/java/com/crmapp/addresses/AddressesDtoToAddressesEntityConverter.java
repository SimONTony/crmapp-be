

package com.crmapp.addresses;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressesDtoToAddressesEntityConverter implements Converter<AddressDto, Address> {

    @Override
    public Address
    convert(AddressDto source) {
        return Address.builder()
                .country(source.getCountry())
                .state(source.getState())
                .city(source.getCity())
                .district(source.getDistrict())
                .street(source.getStreet())
                .building(source.getBuilding())
                .apartment(source.getApartment())
                .postalCode(source.getPostalCode())
                .build();
    }
}
