<%@page import="java.util.List"%>
<%@page import="it.rf.autolavaggio.model.Lavorazione"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>HomePage</title>


</head>
<body style="background-color: 	#f0ffff;">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>



  <!---<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #e3f2fd;">!--->
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
            
     <% List<Lavorazione>lista=(List<Lavorazione>) session.getAttribute("listaLavorazioni");
     Integer codOrdine=(Integer) session.getAttribute("codOrdine");%>
     <% if(lista!=null){%>
     <% if(codOrdine==null) {
     	codOrdine=1;
     	}%>
     <h2>Ordine numero: <%=codOrdine%></h2> 
    <center>
    
     	<table>
     	<tr>
     	<th  colspan=2>
     	<h3>Scegli le lavorazioni da eseguire</h3>
     	</th>
     	</tr>
     	<th colspan=2>
     	<h5>Nome Lavorazione</h5>
     	</th>
     	<form action="/creazione_ordine" method="post">
     		<%for(Lavorazione l: lista){ %>
     			<tr>
     			<td><%= l.getNomeLavorazione() %></td>
     			<td><input type="checkbox" class="form-check-input" value=<%=l.getCodLavorazione() %> name="codLavorazione" id="flexCheckDefault">
     				 <label class="form-check-label" for="flexCheckDefault">
     			</td>
     			</tr>
     		<%} %>
     		<h3>Inserisci targa:</h3>
     		<input type=text name=targa required placeholder="Targa" style="width: 40%; border-radius: 5px; border-color: blue;"><br><br>
     		<input type=submit value=Invia class="btn btn-primary">
     	</form>
     </table>
     </center>
     <%} %>
     

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