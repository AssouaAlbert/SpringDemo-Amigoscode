package com.personal.demo.service;

import com.personal.demo.dao.PersonDao;
import com.personal.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier ("fakePersonID") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int insertPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public int deletePerson(UUID id){
        return personDao.deletePerson(id);
    }
    public Optional<Person> getPersonById(UUID uuid) {
       return personDao.selectPersonById(uuid);
    }

    public int updatePerson (UUID uuid, Person person) {
        return personDao.updataPersonById(uuid, person);
    }
}