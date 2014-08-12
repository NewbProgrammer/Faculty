package com.itstep.ppjava13v1.prepod.academy.db.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by strazhko on 19.07.14.
 */
public interface ConnectionManager {
    Connection getConnection() throws SQLException;
    public void close() throws SQLException;
}
