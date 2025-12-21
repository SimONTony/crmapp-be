package com.crmapp.addresses;

import jakarta.persistence.Convert;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class AddressesDtoToAddressesEntityConverter implements Converter<AddressEntity, AddressDto> {


    @Override
    public AddressDto convert(AddressEntity source) {
        return null;
    }
}
