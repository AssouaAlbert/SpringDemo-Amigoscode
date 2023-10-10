package com.personal.demo.dao;

import com.personal.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson (UUID id, Person person);
    default  int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        insertPerson(id, person);
        return 1;
    }
    List<Person> selectAllPeople();

    int deletePerson(UUID id);
    int updataPersonById(UUID id, Person person);
    Optional<Person> selectPersonById(UUID id);
}
