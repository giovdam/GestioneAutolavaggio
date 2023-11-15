<%@page import="it.rf.autolavaggio.model.DTO.RecuperoCodaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evasione degli Ordini</title>
</head>
<body>
	<% ArrayList <RecuperoCodaDTO> lista=(ArrayList<RecuperoCodaDTO>)session.getAttribute("listacoda"); 
	if(lista!=null){%>
	<table>
		<tr>
		<th><h3>Targa</h3></th>
		<th><h3>Codice Ordine</h3></th>
		<th>Lavorazione</th>
		<th>Codice Lavorazione</th>
		</tr>
		<form action=/evasione_ordini method=post>
			<% for(RecuperoCodaDTO coda: lista){%>
			<tr>
			
				<td><%=coda.getTarga() %></td>
				<td><input type=text  name=codOrdine readonly value="<%= coda.getCodOrdine() %>" ></td>
				<td><%= coda.getNomeLavorazione() %></td>
				<td><input type=text name=codLavorazione readonly value="<%= coda.getCodLavorazione() %>"></td>
				<td><input type=submit value=Evadi></td>
				</tr>
			<%} %>
			</form>
		
	</table>
	
	
	<%} %>
</body>
</html>