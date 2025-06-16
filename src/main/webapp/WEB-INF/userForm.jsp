<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>UserServlet</title>
	</head>
	
	<body>
		<div class="nameForm">
			<h2>Bienvenu sur notre formulaire</h2>
		</div>
		
		<div class="info"> 
		    <form method="post" action="UserServlet">
		        <label for="nom">Nom :</label>
		        <input type="text" id="nom" name="nom" required><br><br>
		
		        <label for="email">Email :</label>
		        <input type="email" id="email" name="email" required><br><br>
		
		        <input type="submit" value="Envoyer">
		    </form>
		</div>
	</body>
</html>