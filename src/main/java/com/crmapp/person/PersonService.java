package com.crmapp.person;

import com.crmapp.person.conveter.PersonDtoToPersonEntityConverter;
import com.crmapp.person.conveter.PersonEntityToPersonDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonEntityToPersonDtoConverter personEntityToPersonDtoConverter;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter;

    public List<PersonDto> getAllPersons() {
        List<PersonEntity> persons = personRepository.findAll();
        List<PersonDto> personDtos = persons.stream()
                .map(person -> personEntityToPersonDtoConverter.convert(person))
                .toList();
        return personDtos;
    }

    public PersonDto getPersonById(Integer personId) {
        PersonEntity person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person was not found"));
        PersonDto personDto = personEntityToPersonDtoConverter.convert(person);
        return personDto;
    }

    public void deletePerson(Integer personId) {
        personRepository.deleteById(personId);
    }

    public PersonDto editPerson(PersonDto personDto) {
        PersonEntity personEntity = personDtoToPersonEntityConverter.convert(personDto);
        //todo
        return null;
    }

    public PersonDto addPerson(PersonDto personDto) {
        PersonEntity personEntity = personDtoToPersonEntityConverter.convert(personDto);
        PersonEntity savedPersonEntity = personRepository.save(personEntity);
        PersonDto savedPersonDto = personEntityToPersonDtoConverter.convert(savedPersonEntity);
        return savedPersonDto;
    }

}
