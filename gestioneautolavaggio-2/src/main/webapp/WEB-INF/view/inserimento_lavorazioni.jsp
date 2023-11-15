<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento delle Lavorazioni</title>
</head>
<body>
	<h1>Inserimento delle lavorazioni:</h1>
	<h3>Compila i seguenti campi:</h3>
	
	<form action="/creazione_lavorazione" method="post">
		<input type=text name="nomeLavorazione" required placeholder="Nome Servizio">
		<input type=text name="costoLavorazione" required placeholder="Costo Servizio">
		<input type=submit value=Crea>
	</form>
</body>
</html>