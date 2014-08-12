package com.itstep.ppjava13v1.prepod.academy.db.dao;

import com.itstep.ppjava13v1.prepod.academy.db.entities.Person;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Stuff;

import java.util.Date;
import java.util.List;

/**
 * Created by strazhko on 26.07.14.
 */
public interface StuffDAO {
    List<Stuff> findAll(String tabName);
    List<Stuff> findByName(String name, String tabName);
    List<Stuff> findByStart(Date date, String tabName);
    Stuff findById(long id, String tabName);
    boolean save(Stuff s);
    boolean delete(Stuff s);
    boolean deleteById(long id);
}
