package com.packagegiorno4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EchoServlet
 */
//@WebServlet("/EchoServlet")
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String testoRicevuto = request.getParameter("testo");
		String rispostaDaStampare = "";
		
		
		//Salvato attributo testoRicevuto nello scope di REQUEST. Si azzera ad ogni richiesta
		request.setAttribute("testoSalvato", testoRicevuto);
		
		
		if (testoRicevuto == null)
		{
			rispostaDaStampare = "Nessun testo inserito come parametro!";
		}
		else
		{
			rispostaDaStampare = (String) request.getAttribute("testoSalvato");
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.print("Testo ricevuto: " + rispostaDaStampare);
		//Nel caso in cui si volesse utilizzare una JSP
		
		/*Un forward a una JSP è un'operazione lato server che trasferisce la gestione di una richiesta HTTP da una risorsa 
		(come una Servlet o un'altra JSP) a una specifica pagina JSP, mantenendo l'URL originale nel browser. 
		Si differenzia dal reindirizzamento perché avviene internamente senza coinvolgere il client. */
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/showEcho.jsp"); 
		//il dispatcher invia a un'altra risorsa server, in questo caso la jsp
        //dispatcher.forward(request, response);
		
		//In questo caso risponde direttamente
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
