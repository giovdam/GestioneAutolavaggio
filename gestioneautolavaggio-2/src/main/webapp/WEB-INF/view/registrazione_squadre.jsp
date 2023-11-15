<%@page import="it.rf.autolavaggio.model.Operaio"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione squadre</title>
</head>
<body>
	<%Integer numeroSquadra=(Integer)session.getAttribute("numero"); %>
	<table>
		<tr><th>Creazione della squadra numero <%= numeroSquadra+1%></th></tr>
		<tr>
			<td>NOME</td>
			<td>COGNOME</td>
			<td>CODICE FISCALE</td>
		</tr>
		
			<% ArrayList<Operaio> lista=(ArrayList <Operaio>) session.getAttribute("tabellaOperai");
			 	if(lista!=null){%>
			 	<form action="/creazioneSquadra" method="post">
				<% for(Operaio o: lista){%>	
					<tr>
						<td><%= o.getNomeOperaio()%></td>
						<td><%= o.getCognomeOperaio()%></td>
						<td><%= o.getCfOperaio()%></td>
						<td><input type="checkbox" value="<%= o.getCfOperaio()%>" name="cfOperaio"></td>
				<% }%>
				
			 <%} %>
		</tr>
	
	</table>
		<input type=submit value=Crea>
	</form>
</body>
</html>