package com.crmapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {


    @Autowired
    private PersonRepository personRepository;

    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

}
