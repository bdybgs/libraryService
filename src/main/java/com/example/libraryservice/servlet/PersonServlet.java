package com.example.libraryservice.servlet;


import com.example.libraryservice.service.PersonService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {

    private final PersonService personService;

    public PersonServlet() {
        try {
            this.personService = new PersonService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("1ggg");
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/person.jsp");
        requestDispatcher.forward(request, response);
        personService.getAllPersons();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}