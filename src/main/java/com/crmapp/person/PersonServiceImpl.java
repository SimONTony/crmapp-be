package com.crmapp.person;

import com.crmapp.person.conveter.PersonDtoToPersonEntityConverter;
import com.crmapp.person.conveter.PersonEntityToPersonDtoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonEntityToPersonDtoConverter personEntityToPersonDtoConverter;
    private final PersonRepository personRepository;
    private final PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter;

    public PersonServiceImpl(PersonEntityToPersonDtoConverter personEntityToPersonDtoConverter, PersonRepository personRepository, PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter) {
        this.personEntityToPersonDtoConverter = personEntityToPersonDtoConverter;
        this.personRepository = personRepository;
        this.personDtoToPersonEntityConverter = personDtoToPersonEntityConverter;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<PersonEntity> persons = personRepository.findAll();
        List<PersonDto> personDtos = persons.stream()
                .map(personEntityToPersonDtoConverter::convert)
                .toList();
        log.info("All persons: {}", personDtos);
        return personDtos;
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        PersonEntity person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person was not found"));
        PersonDto personDto = personEntityToPersonDtoConverter.convert(person);
        log.info("Person found: {}", personDto);
        return personDto;
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
        log.info("Person deleted: {}", personId);
    }

    @Override
    public PersonDto addPerson(PersonDto personDto) {
        PersonEntity personEntity = personDtoToPersonEntityConverter.convert(personDto);
        PersonEntity saved = personRepository.save(personEntity);
        PersonDto savedPersonDto = personEntityToPersonDtoConverter.convert(saved);
        log.info("Person saved: {}", savedPersonDto);
        return savedPersonDto;
    }

    @Override
    public PersonDto editPerson(PersonDto personDto) {
        PersonEntity personEntity = personDtoToPersonEntityConverter.convert(personDto);
        PersonEntity updatedPerson = personRepository.save(personEntity);
        PersonDto updatedPersonDto = personEntityToPersonDtoConverter.convert(updatedPerson);
        log.info("Person updated: {}", updatedPerson);
        return updatedPersonDto;
    }

}
