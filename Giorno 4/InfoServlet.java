package com.packagegiorno4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
//@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecuperaInfo(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecuperaInfo(request,response);
	}
	
	private void RecuperaInfo(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			//Recupera metodo Http
			String metodoHttp = request.getMethod();
			//Recupera URL
			String interoURL = request.getRequestURI().toString();
			//Recupera tutti i parametri
			Enumeration<String> nomiParametri = request.getParameterNames();
			String elencoParametri = "";
			while(nomiParametri.hasMoreElements())
			{
				//Per ogni parametro recupera ogni singolo valore
				String nomeSingoloParametro = nomiParametri.nextElement();
				String[] valoriSingoloParametro = request.getParameterValues(nomeSingoloParametro);
				for (String valore : valoriSingoloParametro) 
				{	
	                elencoParametri += valore + " ";
	            }
			}
			//Stampa tutti i dati
			PrintWriter printWriter;
			printWriter = response.getWriter();
			printWriter.print("<h1> Metodo utilizzato: " + metodoHttp + "<br> Intero URL: " + interoURL + 
					"<br>" + "Elenco parametri: " + elencoParametri + "</h1>");
			//printWriter.print("Qui inserisco l'elenco: " + elencoParametri);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
