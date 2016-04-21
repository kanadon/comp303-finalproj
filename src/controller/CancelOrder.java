package controller;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.OrderProduct;

@WebServlet("/CancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CancelOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();	
		Query q = em.createQuery("SELECT o FROM Order o WHERE o.uid = " + uid);
		q.setFirstResult(0);
		Order order = (Order) q.getSingleResult();
		List<OrderProduct> lop = order.getOrderProducts();
		
		for(OrderProduct op : lop){
			em.getTransaction().begin();		
			em.remove(op);
			em.getTransaction().commit();
		}
		em.getTransaction().begin();	
		em.remove(order);
		em.getTransaction().commit();
		em.getEntityManagerFactory().getCache().evictAll();
		em.close();
		emf.close();
		
		response.setContentType("application/json");
		JsonObject json = Json.createObjectBuilder().add("error", false).build();
		response.getWriter().write(json.toString());
	}

}
