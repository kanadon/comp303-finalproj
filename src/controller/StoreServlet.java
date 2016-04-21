package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import model.Product;

@WebServlet({ "/StoreServlet", "/Store" })
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StoreServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Query q = em.createQuery("SELECT p FROM Product p");
		List<Product> products = q.getResultList();
		ArrayList<ProductBean> lpb = new ArrayList<ProductBean>();
		for(Product p : products){
			ProductBean pb = new ProductBean();
			pb.setName(p.getName());
			pb.setPrice(p.getPrice());
			pb.setProductId(p.getProductId());
			lpb.add(pb);
		}
		
		request.getSession().setAttribute("productList", lpb);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/store.xhtml");
		rd.forward(request, response);

		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append(Integer.toString(products.size()));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
