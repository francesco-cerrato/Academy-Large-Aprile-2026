package packageProjectGiorno6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProdottiServlet
 */
@WebServlet("/ProdottiServlet")
public class ProdottiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Prodotto> listaProdotti = new ArrayList<>();
		listaProdotti.add(new Prodotto("Smartphone",15.99,true));
		listaProdotti.add(new Prodotto("PlayStation5",49.99,false));
		listaProdotti.add(new Prodotto("Monitor",199.99,false));
		listaProdotti.add(new Prodotto("Tastiera",50.0,true));
		listaProdotti.add(new Prodotto("Mouse",19.99,true));
		
		// "prodotti" è il nome utilizzato per recuperare la lista nella JSP
		request.setAttribute("prodotti", listaProdotti);
		request.setAttribute("numeroTotaleProdotti", listaProdotti.size());
		
		// Inoltro alla pagina JPS
		request.getRequestDispatcher("lista-prodotti.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

}
