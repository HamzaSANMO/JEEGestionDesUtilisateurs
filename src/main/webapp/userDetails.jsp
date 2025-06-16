<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="user.model.User" %>

<%
    // Récupération des données depuis la session
    User user = (User) session.getAttribute("dernierUtilisateur");
    List<User> users = (List<User>) session.getAttribute("utilisateurs");

    // Redirection si les données n'existent pas
    if (user == null || users == null) {
        response.sendRedirect("userForm.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>userDetails</title>
</head>
<body>
    <h1>Bienvenue, <%= user.getNom() %> !</h1>
    <p><strong>Email :</strong> <%= user.getEmail() %></p>

    <hr>

    <h2>Liste des utilisateurs enregistrés :</h2>
    <ul>
        <% for (User u : users) { %>
            <li><%= u.getNom() %> - <%= u.getEmail() %></li>
        <% } %>
    </ul>

    <br>
    <a href="<%= request.getContextPath() %>/UserServlet">Ajouter un autre utilisateur</a>


</body>
</html>
