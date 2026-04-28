<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	Pagina di benvenuto</title>
</head>
	<%-- La seguente direttiva è utilizzata per importare classi o pacchetti Java all'interno del codice JSP --%>
	<%@page import="java.io.*, java.util.Date, java.util.Enumeration" %> 
	
	<!--  Questo è un commento statico dunque è visibile anche lato client da parte del browser -->
	<%--Questo è un commento dinamico JSP visibile esclusivamente lato server, dunque da Tomcat --%>
<body>

	<%-- Questa JSP di benvenuto semplicemente stampa, in maniera dinamica lato server, la data odierna --%>
	<% 
		Date dataCorrente = new java.util.Date(); 
	%>

	<h1> Data corrente:  <%= dataCorrente %> </h1>
	
	
	
</body>
</html>