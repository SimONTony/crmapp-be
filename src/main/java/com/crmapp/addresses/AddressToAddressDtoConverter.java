package com.crmapp.addresses;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressDtoConverter implements Converter<Address, AddressDto> {

    @Override
    public AddressDto convert(Address source) {
        return null; //todo
    }

}
