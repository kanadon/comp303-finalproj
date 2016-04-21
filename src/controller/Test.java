package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderBean;
import model.Order;
import model.OrderId;
import model.OrderProduct;
import model.OrderProductId;
import model.Product;
import model.User;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User user = em.find(User.class, 100);
		List<Order> orders = user.getOrders();
//		ob = new OrdersBean();//		
//		ArrayList<String> list = new ArrayList<String>();
//		for (Order order : orders){
//			list.add(Integer.toString(order.getUser().getUserId()));
//		}		
//		ob.setOrders(list);
//		request.getSession().setAttribute("orderBean", ob);		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/orders.xhtml");
//		rd.forward(request, response);
		
		
		//entering new order and orderproduct -- works
//		Timestamp now = new Timestamp(System.currentTimeMillis());
//		List<OrderProduct> lop = orders.get(0).getOrderProducts();
//		int x = lop.size();
//		Order o = new Order();
//		OrderId oid = new OrderId();
//		OrderProduct op = new OrderProduct();
//		OrderProductId opid = new OrderProductId();
//		
//		oid.setDate(now);
//		oid.setUserId(100);
//		o.setOrderId(oid);
//		o.setUser(user);
//		
//		opid.setDate(now);
//		opid.setProductId(100);
//		opid.setUserId(100);
//		op.setOrder(o);
//		op.setQuantity(10);
//		op.setOrderProductId(opid);
//		
//		em.persist(o);
//		em.persist(op);
		
		//testing relationship product -> orderproduct -- works
//		Product product = em.find(Product.class, 100);
//		int x = product.getOrderProducts().size();
		
		ArrayList<OrderBean> lob = new ArrayList<OrderBean>();
		for (int i = 0; i < 4; i++){
			OrderBean ob = new OrderBean();
			lob.add(ob);
		}
		
		request.getSession().setAttribute("orderBeanList", lob);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/orders.xhtml");
		rd.forward(request, response);
		
//		em.getTransaction().commit();
		em.close();
		emf.close();
		
		
//		response.getWriter().append(Integer.toString(x));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
