<%@ page import="com.example.libraryservice.entity.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список людей</title>
</head>
<body>
<h1>Список людей</h1>
<br/>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Др</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Предположим, что список людей передан в request как атрибут "people"
        List<Person> people = (List<Person>) request.getAttribute("personList");
        if (people != null) {
            for (Person person : people) {
    %>
    <tr>
        <td><%= person.getId() %></td>
        <td><%= person.getName() %></td>
        <td><%= person.getBirthday() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<a href="<%= request.getContextPath() %>/PersonServlet">Назад</a>
</body>
</html>
