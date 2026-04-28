<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista numeri</title>
	<%@page contentType="text/html; charset=UTF-8" %> 
</head>
<body>

	<%-- Metodo classico tramite scriplet per generare una lista elementi tramite ciclo for --%>
	<ul>
		<% 
			for (int i=1; i<=10;i++)
			{ %>
				<li> Elemento numero: <%= i %> </li>
			<% } %>
	</ul>
	
	<%-- questa direttiva include carica, durante la fase di compilazione, il contenuto di un file esterno (in questo caso header.jsp)--%>
	<%@ include file="header.jsp" %>
	
  
    
</body>
</html>