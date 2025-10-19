package com.crmapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/{personId}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Integer personId) {
        PersonDto person = personService.getPersonById((personId));
        return ResponseEntity.ok(person);
    }

    @DeleteMapping(value = "/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/addPerson")
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        PersonDto savedPerson = personService.addPerson(personDto);
        return ResponseEntity.ok(savedPerson);
    }

}
