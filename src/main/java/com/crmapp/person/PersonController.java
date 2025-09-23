package com.crmapp.person;


import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonEntity> getAllPersons() {
        List<PersonEntity> persons = personService.getAllPersons();
        return persons;

    }

}
