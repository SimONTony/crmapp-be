package com.crmapp.person.conveter;

import com.crmapp.person.PersonDto;
import com.crmapp.person.PersonEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToPersonDtoConverter implements Converter<PersonEntity, PersonDto> {

    @Override
    public PersonDto convert(PersonEntity source) {
        return PersonDto.builder()
                .personId(source.getPersonId())
                .firstname(source.getFirstname())
                .surname(source.getSurname())
                .email(source.getEmail())
                .birthday(source.getBirthday())
                .hasFop(source.getHasFop())
//                .gender(source.getGender())
                .build();
    }



}
