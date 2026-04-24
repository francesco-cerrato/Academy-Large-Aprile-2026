package com.ProjectGiorno5;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingFilter
 */
//@WebFilter("/LoggingFilter")
public class LoggingFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoggingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	//All'interno del file web.xml ho indicato come mappatura URL del filter questo "/*"...
	//Questo permette al filter di intercettare tutte le richieste in entrata dell'app Java indipendentemente dall'URL specifico
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//Il metodo nanoTime() è utilizzato per misurare il tempo trascorso
		long tempoDiInizioFilter = System.nanoTime();
		
		System.out.println("Prima del filter");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String metodoHttp = httpRequest.getMethod();
		String url = httpRequest.getRequestURI().toString();
		String timestamp = LocalDateTime.now().format(formatter);
		//All'interno della classe generale di questo Filter ho dichiarato un DateTimeFormatter per l'inserimento della data attuale
		
		System.out.print("Metodo Http: " + metodoHttp + "\nUrl: " + url + "\ntimestamp: " + timestamp);
		
		long durataIntercettazioneFilter = System.nanoTime() - tempoDiInizioFilter;
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("\nDopo il filter, tempo trascorso: " + durataIntercettazioneFilter);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
