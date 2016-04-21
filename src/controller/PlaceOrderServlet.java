package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import bean.OrderBean;
import bean.UserBean;
import model.Order;
import model.OrderId;
import model.OrderProduct;
import model.OrderProductId;
import model.Product;

@WebServlet({ "/PlaceOrderServlet", "/PlaceOrder" })
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlaceOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		long now = System.currentTimeMillis();
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		

		// create order record
		Order o = new Order();
		OrderId oid = new OrderId();
		oid.setDate(new Timestamp(now));
		oid.setUserId(userBean.getUserId());
		o.setOrderId(oid);
		em.persist(o);

		Query q = em.createQuery("SELECT p FROM Product p");
		List<Product> products = q.getResultList();

		for (Product p : products) {
			int quantity = Integer.parseInt(request.getParameter(Integer.toString(p.getProductId())));

			if (quantity > 0) {
				// create orderproduct record for each product
				OrderProduct op = new OrderProduct();
				OrderProductId opid = new OrderProductId();
				opid.setProductId(p.getProductId());
				opid.setUserId(userBean.getUserId());
				opid.setDate(new Timestamp(now));
				op.setOrderProductId(opid);
				op.setQuantity(quantity);
				em.persist(op);
			}
		}

		em.getTransaction().commit();
		em.getEntityManagerFactory().getCache().evictAll();
		em.close();
		emf.close();
		response.sendRedirect("/Comp303FinalProject/Profile");
	}
}
