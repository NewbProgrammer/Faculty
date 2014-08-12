package com.itstep.ppjava13v1.prepod.academy.services;

import com.itstep.ppjava13v1.prepod.academy.db.dao.PersonDAO;
import com.itstep.ppjava13v1.prepod.academy.db.dao.StuffDAO;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Person;

import java.util.Date;
import java.util.List;

public class PersonService {

    PersonDAO personDAO;
    StuffDAO stuffDAO;

    public PersonService(PersonDAO personDAO, StuffDAO stuffDAO) {
        this.personDAO = personDAO;
        this.stuffDAO = stuffDAO;
    }

    public boolean save(String name, Date birthday, String passport) {
        Person person = new Person(name, birthday, passport);

        return validatePerson(person) && personDAO.save(person);
    }

    public boolean validatePerson(Person p) {
        //TODO Implement validation
        return true;
    }

    public List<Person> findAll() {
        return personDAO.findAll();
    }
}
