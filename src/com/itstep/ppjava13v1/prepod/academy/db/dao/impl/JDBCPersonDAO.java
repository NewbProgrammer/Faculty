package com.itstep.ppjava13v1.prepod.academy.db.dao.impl;

import com.itstep.ppjava13v1.prepod.academy.db.dao.PersonDAO;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Person;
import com.itstep.ppjava13v1.prepod.academy.db.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCPersonDAO implements PersonDAO {

    private ConnectionManager connectionManager;

    public JDBCPersonDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<Person>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                result.add(formPerson(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> result = new ArrayList<Person>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM person WHERE person.name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(formPerson(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Person findById(long id) {
        Person result = new Person();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM person WHERE person.id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = formPerson(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean save(Person p) {
        String sqlStatement = p.getId() == 0 ?
                "INSERT INTO person VALUES (NULL, ?, ?, ?)" :
                "UPDATE person SET name=?, birthday=?, passport=? WHERE id=?";
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    (sqlStatement, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, p.getName());
            preparedStatement.setDate(2, new Date(p.getBirthday().getTime()) );
            preparedStatement.setString(3, p.getPassport());
            if(p.getId() != 0) {
                preparedStatement.setLong(4, p.getId());
            }

            if (preparedStatement.executeUpdate() != 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                p.setId(resultSet.getLong(1));
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Person p) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }


    private Person formPerson(ResultSet resultSet) throws SQLException {
        return new Person(resultSet.getString(2),
                resultSet.getDate(3),
                resultSet.getString(4));
    }
}
