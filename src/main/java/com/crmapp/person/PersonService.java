package com.crmapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    private PersonEntityToSimplePersonDtoConverter personEntityToSimplePersonDtoConverter;

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDto> getAllPersons() {
        List<PersonEntity> persons = personRepository.findAll();
        List<PersonDto> personDtos = persons.stream()
                .map(person -> personEntityToSimplePersonDtoConverter.convert(person))
                .toList();
        return personDtos;
    }


    public PersonDto getPersonById(Integer personId) {
        PersonEntity person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person was not found"));
        PersonDto personDto = personEntityToSimplePersonDtoConverter.convert(person);
        return personDto;
    }



}
