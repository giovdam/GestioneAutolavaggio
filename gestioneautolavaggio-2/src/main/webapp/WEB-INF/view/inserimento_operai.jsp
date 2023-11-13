<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione operai</title>
</head>
<body>
	<form action="/registrazioneOperai" method="post">
		<input type=text name=nomeOperaio required placeholder="Nome operatore..."><br>
        <input type=text name=cognomeOperaio required placeholder="Cognome operatore..."><br>
        <input type=text name=cfOperaio required placeholder="Codice Fiscale..."><br>
        <input type=submit value=Registra>
    </form>
</body>
</html>