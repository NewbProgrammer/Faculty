package com.itstep.ppjava13v1.prepod.academy.db.dao;

import com.itstep.ppjava13v1.prepod.academy.db.entities.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> findAll();
    List<Person> findByName(String name);
    Person findById(long id);
    boolean save(Person p);
    boolean delete(Person p);
    boolean deleteById(long id);

}
