package com.crmapp.person;

import com.crmapp.core.response.dto.BaseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public BaseResponseDto<List<PersonDto>> getAllPersons() {
        List<PersonDto> persons = personService.getAllPersons();
        return new BaseResponseDto<>(persons);
    }

    @GetMapping(value = "/{personId}")
    public BaseResponseDto<PersonDto> getPersonById(@PathVariable Long personId) {
        PersonDto person = personService.getPersonById((personId));
        return new BaseResponseDto<>(person);
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
