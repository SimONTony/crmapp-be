package com.crmapp.person;

import com.crmapp.person.conveter.PersonDtoToPersonEntityConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    private final PersonService personService;
    private final PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter;

    public PersonController(PersonService personService, PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter) {
        this.personService = personService;
        this.personDtoToPersonEntityConverter = personDtoToPersonEntityConverter;
    }

    @GetMapping
    public List<PersonDto> getAllPersons() {
        List<PersonDto> persons = personService.getAllPersons();
        return persons;
    }

    @GetMapping(value = "/{personId}")
    public PersonDto getPersonById(@PathVariable Long personId) {
        PersonDto person = personService.getPersonById((personId));
        return person;
    }


    @DeleteMapping(value = "/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);

    }

    @PostMapping(value = "/addPerson")
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        PersonDto savedPerson = personService.addPerson(personDto);
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<PersonDto> editPerson(@RequestBody PersonDto personDto) {
        PersonDto updatedPerson = personService.editPerson(personDto);
        return ResponseEntity.ok(updatedPerson);
    }

}
