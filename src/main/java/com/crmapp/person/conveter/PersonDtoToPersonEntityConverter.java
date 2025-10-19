package com.crmapp.person.conveter;

import com.crmapp.person.PersonDto;
import com.crmapp.person.PersonEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPersonEntityConverter implements Converter<PersonDto, PersonEntity> {

    @Override
    public PersonEntity convert(PersonDto source) {
        return PersonEntity.builder()
                .personId(source.getPersonId())
                .firstname(source.getFirstname())
                .surname(source.getSurname())
                .lastname(source.getLastname())
                .email(source.getEmail())
                .hasFop(source.isHasFop())
                .birthday(source.getBirthday())
                .build();
    }
}
