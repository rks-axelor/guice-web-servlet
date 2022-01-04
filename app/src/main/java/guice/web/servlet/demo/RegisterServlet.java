package guice.web.servlet.demo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;
@Singleton
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
     EntityManager em = emf.createEntityManager();
     em.getTransaction().begin();
     Employee emp = new Employee();
     int eid = Integer.parseInt(req.getParameter("eid"));
     emp.setEid(eid);
     String ename=req.getParameter("ename");
     emp.setEname(ename);
     int esal= Integer.parseInt(req.getParameter("esal"));
     emp.setEsal(esal);
     em.persist(emp);
     em.getTransaction().commit();
	super.service(req, resp);
	RequestDispatcher rq = req.getRequestDispatcher("/index.jsp");
	rq.forward(req, resp);
}
}
