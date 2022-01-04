package guice.web.servlet.demo;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Singleton;

@Singleton
public class GuiceServlet extends HttpServlet {

	private static final long serialVersionUID = 8749035492233249707L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Select e from Employee e");
        @SuppressWarnings("unchecked")
        List<String> list = query.getResultList();
        request.setAttribute("list",list);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        em.getTransaction().commit();
       
	
	}

}
