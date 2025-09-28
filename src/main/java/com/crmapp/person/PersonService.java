package com.crmapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonEntityToSimplePersonDtoConverter personEntityToSimplePersonDtoConverter ;

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDto> getAllPersons() {
        List<PersonEntity> persons = personRepository.findAll();
        List<PersonDto> personDtos = persons.stream()
                .map(person -> personEntityToSimplePersonDtoConverter.convert(person))
                .toList();
        return personDtos;
    }



}
