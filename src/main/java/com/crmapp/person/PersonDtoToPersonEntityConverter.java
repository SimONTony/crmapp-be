package com.crmapp.person;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPersonEntityConverter implements Converter<PersonDto, PersonEntity> {


    @Override
    public PersonEntity convert(PersonDto source) {
        return PersonEntity.builder()
                .personId(source.getPersonId())
                .firstname(source.getFirstName())
                .surname(source.getSurname())
                .lastname(source.getLastname())
                .email(source.getEmail())
                .hasFop(source.isHasFop())
                .birthday(source.getBirthday())
                .build();
    }
}
