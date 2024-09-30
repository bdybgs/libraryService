package com.example.libraryservice.config;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class JDBCConnection {

    public static Connection getConnection() throws SQLException {
        try {
            log.info("Подключение к базе данных успешно установлено.");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL Driver not found", e);
        }
        Connection connection;
        try {
            String URL = "jdbc:postgresql://localhost:5432/library";
            String USER = "postgres";
            String PASSWORD = "testtest";
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
