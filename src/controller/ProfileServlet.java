package controller;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.OrderProduct;
import model.User;
import bean.OrderBean;
import bean.UserBean;

@WebServlet({ "/ProfileServlet", "/Profile" })
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		UserBean ub = (UserBean) request.getSession().getAttribute("userBean");
		User user = em.find(User.class, ub.getUserId());
		ArrayList<OrderBean> orderBeans = new ArrayList<OrderBean>();
		
		for(Order o : user.getOrders()){
			int cost = 0;
			OrderBean ob = new OrderBean();
			ob.setDate(o.getOrderId().getDate());
			
			for(OrderProduct op : o.getOrderProducts()){
				ob.getProducts().add(new AbstractMap.SimpleEntry<String, Integer>(op.getProduct().getName(), op.getQuantity()));
				cost += op.getQuantity() + op.getProduct().getPrice();
			}
			ob.setCost(cost);
			
			orderBeans.add(ob);
		}
		
		request.getSession().setAttribute("orderBeanList", orderBeans);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/profile.xhtml");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
