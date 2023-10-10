package com.personal.demo.api;

import com.personal.demo.model.Person;
import com.personal.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(  @NonNull @RequestBody Person person) {
        personService.insertPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID uuid) {
        return Optional.ofNullable(personService.getPersonById(uuid).orElse(null));
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable("id") UUID uuid, @RequestBody Person person) {
        return personService.updatePerson(uuid, person);
    }
}
