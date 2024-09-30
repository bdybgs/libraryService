package com.example.libraryservice.service;

import com.example.libraryservice.config.JDBCConnection;
import com.example.libraryservice.entity.Person;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.jboss.logging.Log4j2LoggerProvider;
import org.jboss.logging.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PersonService {

    Connection connection = JDBCConnection.getConnection();

    public PersonService() throws SQLException {
    }

    

    public List<Person> getAllPersons() throws SQLException {
        final List<Person> persons = new ArrayList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from library.library_schema.person");
            log.log(Level.INFO, resultSet.toString());
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setName(resultSet.getString("name"));
                person.setBirthday(resultSet.getString("date_of_birthday"));
                persons.add(person);

                log.info("Получен человек: ID=" + person.getId() + ", Имя=" + person.getName());

            }
        } catch (SQLException e) {
            log.log(Level.ERROR, e.getMessage());
            throw new SQLException("Ошибка при получении списка людей", e);
        }
        return persons;
    }

    public void createPerson(String name, String birthday) throws SQLException {
        try {
            String query = "INSERT INTO library.library_schema.person (name, date_of_birthday) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, birthday);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("ошбка добавления", e);
        }
    }

    public void editPerson(int id) {

    }

    public void deletePerson(int id) {

    }
}
