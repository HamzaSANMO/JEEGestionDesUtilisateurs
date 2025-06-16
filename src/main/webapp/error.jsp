<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Erreur - Application Utilisateur</title>

</head>
<body>
    <div class="error-box">
        <h1>Une erreur est survenue</h1>
        <p>Désolé, une erreur inattendue a été rencontrée.</p>
        <p><strong>Détail technique :</strong> <%= exception.getMessage() %></p>
        <p><a href="<%= request.getContextPath() %>/userForm.jsp">Retour au formulaire</a></p>
    </div>
</body>
</html>
