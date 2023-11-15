<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione clienti</title>
</head>
<body>
	<h1>Registrazione Clienti</h1>
	<h3>Compila i seguenti campi:</h3>
    	<form action="/ins_clienti" method="post">
        	<input type=text name=nomeCliente required placeholder="Nome cliente..."><br>
            <input type=text name=cognomeCliente required placeholder="Cognome cliente..."><br>
            <input type=text name=cfCliente required placeholder="Codice Fiscale..."><br>
            <input type=text name=telefonoCliente required placeholder="Cellulare..."><br>
            <input type=submit value=Registra>
        </form>
</body>
</html>