package com.crmapp.person;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToSimplePersonDtoConverter implements Converter<PersonEntity, PersonDto> {

    @Override
    public PersonDto convert(PersonEntity source) {
        return PersonDto.builder()
                .personId(source.getPersonId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .birthday(source.getBirth())
                .hasFop(source.getHasFop())
                .gender(source.getGender())
                .build();
    }

}
