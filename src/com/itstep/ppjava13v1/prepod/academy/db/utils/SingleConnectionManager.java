package com.itstep.ppjava13v1.prepod.academy.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnectionManager implements ConnectionManager {

    private Connection connection;
    private String url;
    private String userName;
    private String password;

    public SingleConnectionManager(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(url,userName, password);
        }

        return connection;
    }

    public void close() throws SQLException {
        connection.close();
        connection = null;
    }
}
