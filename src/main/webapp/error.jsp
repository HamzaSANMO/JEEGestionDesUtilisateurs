<%@ page isErrorPage="true" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur</title>
</head>
<body>
    <div class="error-box">
        <h1>Une erreur est survenue</h1>
        <p>Désolé, une erreur inattendue a été rencontrée.</p>

        <% if (exception != null) { %>
            <p><strong>Détail technique :</strong> <%= exception.getMessage() %></p>
        <% } else { %>
            <p><strong>Code d’erreur :</strong> <%= request.getAttribute("jakarta.servlet.error.status_code") %></p>
            <p><strong>URL demandée :</strong> <%= request.getAttribute("jakarta.servlet.error.request_uri") %></p>
        <% } %>

        <p><a href="<%= request.getContextPath() %>/userForm.jsp">Retour au formulaire</a></p>
    </div>
</body>
</html>
