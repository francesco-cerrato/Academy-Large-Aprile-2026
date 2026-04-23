package com.packagegiorno4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContatorePaginaServlet
 */
//@WebServlet("/ContatorePaginaServlet")
public class ContatorePaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatorePaginaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext applicazione = getServletContext();
        Integer contatore = (Integer) applicazione.getAttribute("visiteTotali");
        
        synchronized(this) 
        {
            contatore++;
            applicazione.setAttribute("visiteTotali", contatore);
        }
        
        PrintWriter printWriter = response.getWriter();
        printWriter.print(" Questa pagina è stata visitata " + contatore + " volte in totale (da tutti gli utenti)");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
	
	@Override
	public void init()
	{
		getServletContext().setAttribute("visiteTotali", 0);
	}

}
