package com.crmapp.person;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToSimplePersonDtoConverter implements Converter<PersonEntity, PersonDto> {
    public PersonDto convert(PersonEntity source) {
        PersonDto target = new PersonDto();
        target.setPersonId(source.getPerson_id());
        target.setFirstName(source.getFirstName());
        target.setSecondName(source.getSecondName());
        target.setLastName(source.getLastName());
        target.setHasFop(source.getHasFop());
        target.setEmail(source.getEmail());

        return target;

//        return PersonDto.builder()
//                .personId(source.getPerson_id())
//                .firstName(source.getFirstName())
//                .lastName(source.getLastName())
//                .email(source.getEmail())
//                .birthday(source.getBirth())
//                .hasFop(source.getHasFop())
//                .gender(source.getGender())
//                .build();


    }

}
