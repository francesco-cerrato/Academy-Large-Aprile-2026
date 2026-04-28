<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista prodotti </title>
</head>
<body>
	<h2> Elenco Prodotti </h2>
	<table>
        <thead>
            <tr>
                <th>Nome Prodotto</th>
                <th>Prezzo</th>
                <th>Disponibilità</th>
            </tr>
        </thead>
        <tbody>
        	<%-- Inizializza il totale a 0 prima del ciclo --%>
        	<c:set var="totaleComplessivo" value="0" />
            <%-- 
              Iterazione sulla lista 'listaProdotti' passata dalla Servlet
              'prodotto' rappresenta l'oggetto corrente nel ciclo
            --%> 
            <c:forEach var="prodotto" items="${prodotti}">
             <%-- Somma il prezzo al totale ad ogni iterazione --%>
            <c:set var="totaleComplessivo" value="${totaleComplessivo + prodotto.prezzo}" />
                <tr>
                    <td>${prodotto.nome}</td>
                    <td>${prodotto.prezzo}</td>
                    <td>${prod.disponiblità}</td>
                    
                     <td>
                        <%-- C:IF per la disponibilità --%>
                        <c:if test="${prodotto.disponibile}">
                            <span style="color: green;">Disponibile</span>
                        </c:if>
                        <c:if test="${!prodotto.disponibile}">
                            <span style="color: red;">Non disponibile</span>
                        </c:if>
                    </td>
                    
                    <td>
                        <%-- C:CHOOSE per la fascia di prezzo --%>
                        <c:choose>
                            <c:when test="${prodotto.prezzo < 20}">
                                Economico
                            </c:when>
                            <c:when test="${prodotto.prezzo >= 20 && prodotto.prezzo <= 100}">
                                Medio
                            </c:when>
                            <c:otherwise>
                                Costoso
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            
            <tr>
            	 <td><strong>Totale</strong></td>
            <%-- Stampa il totale finale --%>
            	<td><strong> <p> Totale prodotti: ${numeroTotaleProdotti} | Prezzo medio: ${totaleComplessivo/numeroTotaleProdotti}</p> </strong></td>
            </tr>
            
            
        </tbody>
    </table>
    
    
</body>
</html>