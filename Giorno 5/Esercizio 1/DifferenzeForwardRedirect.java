package packageGiorno5_DifferenzeForwardRedirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DifferenzeForwardRedirect
 */
//@WebServlet("/DifferenzeForwardRedirect")
public class DifferenzeForwardRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DifferenzeForwardRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter printWriter = response.getWriter();
		String ServletPath = request.getServletPath();
		
		
		//Questa servlet nel file xml ha una doppia mappatura
		//In base al Path esegue o il redirect mappato in "/azione-redirect" 
		//oppure il forward mappato in "/azione-forward"
		if (ServletPath.equals("/azione-redirect"))
		{
			//Metodo redirect
			response.sendRedirect(request.getContextPath() + "/destinazione.jsp");
		}
		else if (ServletPath.equals("/azione-forward"))
		{
			//Metodo forward
			RequestDispatcher dispatcher = request.getRequestDispatcher("destinazione.jsp");
			dispatcher.forward(request, response);
		} else { printWriter.println("Path non riconosciuta"); }
		
		
		//Il forward è un'operazione interna al server che mantiene l'URL originale, 
		//mentre il redirect informa il browser di cambiare URL.
		//Il redirect risulta dunque più lento rispetto al forward
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
