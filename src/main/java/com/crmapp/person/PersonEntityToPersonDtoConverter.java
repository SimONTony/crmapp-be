package com.crmapp.person;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToPersonDtoConverter implements Converter<PersonEntity, PersonDto> {

    @Override
    public PersonDto convert(PersonEntity source) {
        return PersonDto.builder()
                .personId(source.getPersonId())
                .firstName(source.getFirstname())
                .surname(source.getSurname())
                .email(source.getEmail())
                .birthday(source.getBirthday())
                .hasFop(source.getHasFop())
//                .gender(source.getGender())
                .build();
    }



}
