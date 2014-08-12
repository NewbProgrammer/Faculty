package com.itstep.ppjava13v1.prepod.academy.db.utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by strazhko on 26.07.14.
 */
public class Bootstrap {

    ConnectionManager connectionManage;

    public Bootstrap(ConnectionManager connectionManage) {
        this.connectionManage = connectionManage;
    }

    public void init() throws SQLException {
        Connection connection = null;
        try {
            connection = connectionManage.getConnection();
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();

            st.executeUpdate("CREATE TABLE IF NOT EXISTS person (id SERIAL, name VARCHAR(100), birthday DATE, " +
                    "passport VARCHAR(8), PRIMARY KEY(id))");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS teacher (id SERIAL, start DATE, finish DATE, " +
                    "person_id BIGINT UNSIGNED, PRIMARY KEY(id), FOREIGN KEY(person_id) REFERENCES person(id) ON UPDATE CASCADE ON DELETE RESTRICT )");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS student (id SERIAL, start DATE, finish DATE, " +
                    "person_id BIGINT UNSIGNED, PRIMARY KEY(id), FOREIGN KEY(person_id) REFERENCES person(id) ON UPDATE CASCADE ON DELETE RESTRICT )");
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw new SQLException(e);
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
        }
    }


}
