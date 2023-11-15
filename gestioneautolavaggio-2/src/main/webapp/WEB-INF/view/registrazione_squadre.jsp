<%@page import="it.rf.autolavaggio.model.Operaio"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Registrazione squadre</title>
</head>
<body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

  <nav class="navbar bg-primary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/clienti">Registra Clienti</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/veicolo">Registra Veicolo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/operai">Registra Operaio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/squadra">Creazione Squadra</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/lavorazione">Inserimento Servizi</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/coda">Gestione Coda</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	<%Integer numeroSquadra=(Integer)session.getAttribute("numero"); %>
	<center>
	<table>
		<tr><th colspan=3 ><h2>Creazione della squadra numero <%= numeroSquadra+1%></h2></th></tr>
		<tr>
			<td><h5>NOME</h5></td>
			<td><h5>COGNOME</h5></td>
			<td><h5>CODICE FISCALE</h5></td>
		</tr>
		
			<% ArrayList<Operaio> lista=(ArrayList <Operaio>) session.getAttribute("tabellaOperai");
			 	if(lista!=null){%>
			 	<form action="/creazioneSquadra" method="post">
				<% for(Operaio o: lista){%>	
					<tr>
						<td><%= o.getNomeOperaio()%></td>
						<td><%= o.getCognomeOperaio()%></td>
						<td><%= o.getCfOperaio()%></td>
						<td><input type="checkbox" value="<%= o.getCfOperaio()%>" name="cfOperaio" class="form-check-input" id="flexCheckDefault">
						<label class="form-check-label" for="flexCheckDefault">
						</td>
				<% }%>
				
			 <%} %>
		</tr>
	
	</table>
		<br><input type=submit value=Crea class="btn btn-primary">
	</form>
	
	</center>
</body>

 <footer>
 <br><br><br><br><br><br><br><br><br>
 <div class="card text-center">
  <div class="card-footer text-body-secondary">
   <h5 class="card-title">AutoLavaggio Carwashing</h5>
    <p class="card-text">Tel: +39 081857414</p>
    <p class="card-text">Email: info@CarWashing.com</p>
    <p class="card-text">Ci troviamo presso: Via Roma 17(NA)</p>
  </div>
</div>
 
 </footer>
</html>