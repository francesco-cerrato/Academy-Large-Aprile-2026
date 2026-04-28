<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcolatrice</title>
</head>
<body>

	<%-- La seguente JSP ottiene, tramite l'URL, i parametri num1 e num2. Verifica che non siano vuoti e --%>
	<%-- effettua il casting (conversione) da stringa a double per effettuare la loro somma --%>
	<%-- al termine della pagina, tramite la direttiva include, si stampa lato server il contenuto della jsp footer.jsp--%>
	<%
		String messaggioDaStampare = "";
		String primoNumero = request.getParameter("num1");
		String secondoNumero = request.getParameter("num2");
		if (primoNumero == null || secondoNumero == null)
		{
			messaggioDaStampare = "Parametri mancanti!";
			
		}
		else
		{
			Double risultato = Double.parseDouble(primoNumero) + Double.parseDouble(secondoNumero);
			messaggioDaStampare = primoNumero + " + " + secondoNumero + " = " + risultato;
		}
		//double primoNumero =  Double.parseDouble(request.getParameter("num1"));
		//double secondoNumero = Double.parseDouble(request.getParameter("num2"));;
	%>
	<p> Risposta: <br> <%= messaggioDaStampare  %> </p>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>