package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String url = "jdbc:mysql://localhost:3306/todo";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
