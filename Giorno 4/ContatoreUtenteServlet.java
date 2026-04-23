package com.packagegiorno4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContatoreUtenteServlet
 */
//@WebServlet("/ContatoreUtenteServlet")
public class ContatoreUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatoreUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 Per impostare un attributo in una sessione all'interno di una Java Servlet, si utilizza il metodo setAttribute() dell'oggetto 
	 HttpSession. Questo permette di memorizzare oggetti (come user ID, carrelli, preferenze) associandoli all'utente corrente. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessioneCorrente = request.getSession();
		//Controlla se il contatore esiste già nella sessione
		Integer contatoreVisitePagina = (Integer) sessioneCorrente.getAttribute("visite");
		if (contatoreVisitePagina == null)
		{
			contatoreVisitePagina = 1;
		}
		else
		{
			contatoreVisitePagina++;
		}
		//Salva il contatore aggiornato nella sessione
		sessioneCorrente.setAttribute("visite", contatoreVisitePagina);
		
		//Mostra il risultato
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<h1>Hai visitato questa pagina " + contatoreVisitePagina + " volte.</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
