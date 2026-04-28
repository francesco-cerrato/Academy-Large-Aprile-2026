<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettaglio Prodotto</title>
</head>
<body>
	<%--  Istanziazione del Bean --%>
	<jsp:useBean id="mioProdotto" class="packageProjectGiorno6.Prodotto" scope="page" />
	
	 <%--  Settaggio delle proprietà --%>
	 <jsp:setProperty name="mioProdotto" property="nome" value="Laptop" />
	 <jsp:setProperty name="mioProdotto" property="prezzo" value="999.99" />
	 <jsp:setProperty name="mioProdotto" property="disponibile" value="true" />
	 
	<%--  Visualizzazione delle proprietà --%>
	<h1> Informazioni prodotto </h1>
	<p><strong>Nome:</strong> <jsp:getProperty name="mioProdotto" property="nome" /></p>
	<p><strong>Prezzo:</strong> <jsp:getProperty name="mioProdotto" property="prezzo" /></p>
	<p><strong>Disponibilità:</strong> <jsp:getProperty name="mioProdotto" property="disponibile" /></p>
	   
</body>
</html>