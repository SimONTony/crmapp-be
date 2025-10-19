package com.crmapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonEntityToPersonDtoConverter personEntityToSimplePersonDtoConverter;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter;


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


    public void deletePerson(Integer personId) {
        personRepository.deleteById(personId);
    }
//
//
//    public PersonDto editPerson(PersonDto personDto) {
//        PersonEntity personEntity = PersonDtoToPersonEntityConverter.convert(personDto);
//        return personRepository.save(personEntity);
//    }

    public PersonDto addPerson(PersonDto personDto) {
        PersonEntity personEntity = personDtoToPersonEntityConverter.convert(personDto);
        PersonEntity saved = personRepository.save(personEntity);
        return personEntityToSimplePersonDtoConverter.convert(saved);
    }

//    public PersonDto savePerson(PersonDto personDto){
//        PersonEntity personEntity = personDtoToPersonEntityConverter.convert(personDto);
//        return null;
//    }
}
