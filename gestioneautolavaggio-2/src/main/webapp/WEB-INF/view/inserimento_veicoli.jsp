<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione veicoli</title>
</head>
<body>
<h1>Registrazione Veicoli</h1>
        <h3>Inserisci i seguenti dati:</h3>
        <form action="/registrazioneVeicoli" method="post">
            <input type=text name=nTelaio required placeholder="Numero Telaio..."><br>
            <input type=text name=targa required placeholder="Targa..."><br>
            <input type=text name=cfCliente required placeholder="Codice Fiscale cliente..."><br>
            <input type=submit value=Registra>
        </form>
</body>
</html>