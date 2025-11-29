package com.crmapp.person;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAllPersons();

    PersonDto getPersonById(Long personId);

    void deletePerson(Long personId);

    PersonDto addPerson(PersonDto personDto);

    PersonDto editPerson(PersonDto personDto);
}
