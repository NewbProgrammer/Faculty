package com.itstep.ppjava13v1.prepod.academy;

import com.itstep.ppjava13v1.prepod.academy.UI.Impl.ConsoleUserInterface;
import com.itstep.ppjava13v1.prepod.academy.UI.UserInterface;
import com.itstep.ppjava13v1.prepod.academy.db.dao.PersonDAO;
import com.itstep.ppjava13v1.prepod.academy.db.dao.StuffDAO;
import com.itstep.ppjava13v1.prepod.academy.db.dao.impl.JDBCPersonDAO;
import com.itstep.ppjava13v1.prepod.academy.db.dao.impl.JDBCStuffDAO;
import com.itstep.ppjava13v1.prepod.academy.db.utils.Bootstrap;
import com.itstep.ppjava13v1.prepod.academy.db.utils.ConnectionManager;
import com.itstep.ppjava13v1.prepod.academy.db.utils.SingleConnectionManager;
import com.itstep.ppjava13v1.prepod.academy.services.PersonService;

import java.sql.SQLException;

public class Main {

    private static ConnectionManager connectionManager;
    private static PersonService personService;

    public static void main(String[] args) throws SQLException {
        init();
        new Bootstrap(connectionManager).init();
        UserInterface userInterface = new ConsoleUserInterface(personService);
        userInterface.run();
    }

    private static void init() {
        connectionManager = new SingleConnectionManager("jdbc:mysql://localhost:3306/ppjava13v1", "root", "qqqq");
        PersonDAO personDAO = new JDBCPersonDAO(connectionManager);
        StuffDAO stuffDAO = new JDBCStuffDAO(connectionManager);
        personService = new PersonService(personDAO, stuffDAO);
    }


}
