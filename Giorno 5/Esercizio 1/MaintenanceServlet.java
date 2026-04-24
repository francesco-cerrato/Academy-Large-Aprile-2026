package com.ProjectGiorno5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaintenanceServlet
 */
//@WebServlet("/MaintenanceServlet")
public class MaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintenanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter printWriter = response.getWriter();
		
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Sito in Manutenzione</title>");
		printWriter.println("<style>");
		printWriter.println("body { font-family: Arial, sans-serif; text-align: center; }");
		printWriter.println("h1 { color: #333; }");
		printWriter.println("p { font-size: 18px; color: #666; }");
		printWriter.println("</style>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>Sito in manutenzione, torna presto!</h1>");
        printWriter.println("<p>Stiamo lavorando per migliorare l'esperienza utente.</p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

}
