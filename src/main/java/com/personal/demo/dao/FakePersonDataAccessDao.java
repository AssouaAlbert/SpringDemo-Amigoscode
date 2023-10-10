package com.personal.demo.dao;

import com.personal.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakePersonID")
public class FakePersonDataAccessDao implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.name()));
        return 1;
    }

    public List<Person> selectAllPeople() {
        return DB;
    }

    public int deletePerson(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if (person.isPresent()) {
            DB.remove(person.get());
            return 1;
        }
        return 0;

    }

    @Override
    public int updataPersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(person1 -> {
            int indexOfPersonToUpdate = DB.indexOf(person1);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, person.name()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.id().equals(id)).findFirst();
    }
}
