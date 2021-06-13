package com.andrey.simpleApp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    String url = "jdbc:postgresql://localhost:5432/userdb";
            /*"jdbc:postgresql://localhost/UserDB";*/
    String username = "postgres";
    String password = "admin";



    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }

}
