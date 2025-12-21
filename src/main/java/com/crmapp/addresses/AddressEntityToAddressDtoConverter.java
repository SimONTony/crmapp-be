package com.crmapp.addresses;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityToAddressDtoConverter implements Converter<AddressEntity, AddressDto> {


    @Override
    public AddressDto convert(AddressEntity source) {
        return null;
    }

}
