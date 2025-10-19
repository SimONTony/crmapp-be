package com.crmapp.person;


import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonDtoToPersonEntityConverter personDtoToPersonEntityConverter;

    @GetMapping
    public List<PersonDto> getAllPersons() {
        List<PersonDto> persons = personService.getAllPersons();
        return persons;
    }

    @GetMapping(value = "/{personId}")
    public PersonDto getPersonById(@PathVariable Integer personId) {
        PersonDto person = personService.getPersonById((personId));
        return person;
    }


    @DeleteMapping(value = "/{personId}")
    public void deletePerson(@PathVariable Integer personId) {
        personService.deletePerson(personId);

    }

    @PostMapping(value = "/addPerson")
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        PersonDto savedPerson = personService.addPerson(personDto);
        return ResponseEntity.ok(savedPerson);
    }

//
//    @PutMapping(value = "/{personId}/editPerson")
//    public String editPerson(@PathVariable Integer personId, @RequestBody PersonDto personDto) {
//        return personService.(personDto);
//    }

}
