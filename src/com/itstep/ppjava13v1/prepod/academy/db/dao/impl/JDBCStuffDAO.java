package com.itstep.ppjava13v1.prepod.academy.db.dao.impl;

import com.itstep.ppjava13v1.prepod.academy.db.dao.StuffDAO;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Person;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Student;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Stuff;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Teacher;
import com.itstep.ppjava13v1.prepod.academy.db.utils.ConnectionManager;
import com.itstep.ppjava13v1.prepod.academy.db.utils.Tables;

import java.sql.*;
import java.util.*;
import java.util.Date;


public class JDBCStuffDAO implements StuffDAO,Tables {

    private JDBCPersonDAO personDAO = null;
    private ConnectionManager connectionManager;

    public JDBCStuffDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        personDAO = new JDBCPersonDAO(connectionManager);
    }


    @Override
    public List<Stuff> findAll(String tabName) {
        List<Stuff> result = new ArrayList<Stuff>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+tabName);
            if (tabName.equals("students")) {
                while (resultSet.next()) {
                    result.add(formStudent(resultSet));
                }
            } else if (tabName.equals("teachers")) {
                while (resultSet.next()) {
                    result.add(formTeacher(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Stuff formStudent(ResultSet resultSet) throws SQLException {
        return new Student(resultSet.getDate(2),resultSet.getDate(3), personDAO.findById(resultSet.getLong(4)));
    }
    private Stuff formTeacher(ResultSet resultSet) throws SQLException {
        return new Teacher(resultSet.getDate(2),resultSet.getDate(3),personDAO.findById(resultSet.getLong(4)) );
    }

    @Override
    public List<Stuff> findByName(String name, String tabName) {

        return null;
    }

    @Override
    public List<Stuff> findByStart(Date date, String tabName) {
        return null;
    }

    @Override
    public Stuff findById(long id, String tabName) {
        Stuff result = (tabName.equals("students")?new Student():new Teacher());
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from "+tabName+" where id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            result = (tabName.equals("students")?formStudent(resultSet):formStudent(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean save(Stuff s) {
        return false;
    }

    @Override
    public boolean delete(Stuff s) {

        return false;
    }

    @Override
    public boolean deleteById(long id) {

        return false;
    }
}
