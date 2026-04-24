package packageGiorno5LoginSession;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener 
{
	  @Override
	    public void sessionCreated(HttpSessionEvent se) {
	        HttpSession session = se.getSession();
	        System.out.println(">>> SESSIONE CREATA: " + session.getId());
	    }

	    @Override
	    public void sessionDestroyed(HttpSessionEvent se) {
	        HttpSession session = se.getSession();
	        // Nota: sessionDestroyed viene chiamato PRIMA che la sessione sia fisicamente rimossa.
	        System.out.println("<<< SESSIONE DISTRUTTA: " + session.getId());
	    }
  	
}
