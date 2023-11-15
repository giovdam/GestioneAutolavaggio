<%@page import="it.rf.autolavaggio.model.Lavorazione"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HompePage</title>
</head>
<body>
	<nav>
        <ul>
        	<li><a href="/">Home</a></li>
            <li><a href="/clienti">Registra Clienti</a></li>
            <li><a href="/veicolo">Registra Veicolo</a></li>
            <li><a href="/operai">Registra Operaio</a></li>
            <li><a href="/squadra">Creazione Squadra</a></li>
            <li><a href="/lavorazione">Inserimento Servizi</a></li>
            <li><a href="/coda">Gestione Coda</a></li>
        </ul>
     </nav>
     
     <% ArrayList<Lavorazione>lista=(ArrayList<Lavorazione>) session.getAttribute("listaLavorazioni");
     Integer codOrdine=(Integer) session.getAttribute("codOrdine");%>
     <% if(lista!=null){%>
     <b>Ordine numero:<%=codOrdine%></b>
     	<table>
     	<tr>
     	<th colspan=2>
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
     			<td><input type="checkbox" value=<%= l.getCodLavorazione()%> name="codLavorazione"></td>
     			</tr>
     		<%} %>
     		<h3>Inserisci targa:</h3>
     		<input type=text name=targa required placeholder="Targa">
     		<input type=submit value=Invia>
     	</form>
     </table>
     <%} %>
</body>
</html>