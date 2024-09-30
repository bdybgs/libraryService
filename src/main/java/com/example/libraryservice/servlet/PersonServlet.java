package com.example.libraryservice.servlet;


import com.example.libraryservice.entity.Person;
import com.example.libraryservice.service.PersonService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {

    private PersonService personService;

    @Override
    public void init() throws ServletException {
        try {
            this.personService = new PersonService();
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> personList = null;
        try {
            personList = personService.getAllPersons();
            System.out.println(personService.getAllPersons());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/person.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            personService
                    .createPerson(request.getParameter("name"),
                            request.getParameter("date_of_birthday"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}