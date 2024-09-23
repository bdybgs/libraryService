package com.example.libraryservice.service;

import com.example.libraryservice.config.JDBCConnection;
import com.example.libraryservice.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    Connection connection = JDBCConnection.getConnection();

    public PersonService() throws SQLException {
    }

    public List<Person> getAllPersons() throws SQLException {
        final List<Person> persons = new ArrayList<Person>();
        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * from person");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setBirthday(resultSet.getString("birthday"));
            persons.add(person);
        }
        return persons;
    }

    public void createPerson() throws SQLException {

    }
    public void editPerson(int id) {

    }
    public void deletePerson(int id) {

    }
}
