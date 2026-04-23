package com.packagegiorno4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BenvenutoServlet
 */
//@WebServlet("/BenvenutoServlet") Questo è stato aggiunto di default alla creazione della Servlet. Causava errori al server.
public class BenvenutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenvenutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    static int ContatoreInizializzazioni = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter printWriter = response.getWriter();
		
		//Questo serve a gestire la concorrenza, garantisce che un blocco di codice sia eseguito un solo thread alla volta
		synchronized(this) {
			ContatoreInizializzazioni++;
        }
		
		printWriter.print("<h1> Ciao! Questa è la mia prima Servlet </h1> " + ContatoreInizializzazioni);
		
		//Il parametro è inserito all'interno dell'Url. I parametri sono inseriti dopo la mappatura a partire dal punto interrogativo
		//Esempio http://localhost:8080/ProjectGiorno4/benvenuto?nome=Mario
		String utente = request.getParameter(("nome"));
		if (utente == null)
		{
			printWriter.print("<h2> Ciao Ospite! </h2>");
		}
		else
		{
			printWriter.print("<h2> Ciao " + utente + "! </h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	
	
	@Override
	public void init()
	{
		try {
			super.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ContatoreInizializzazioni++;
		System.out.println("La servlet è stata inizializzata!");
	}
	
	@Override
	public void destroy()
	{
		super.destroy();
		System.out.println("La servlet è stata interrotta!");
	}
	

}
