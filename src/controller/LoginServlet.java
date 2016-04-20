package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import helpers.DBHelper;
import model.User;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean userBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		EntityManagerFactory ef = Persistence.createEntityManagerFactory("DataJPA");
//		EntityManager em = ef.createEntityManager();
//		User user = em.find(User.class, 100);
//		response.getWriter().append("Served at: ").append(user.getFirstName());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.xhtml");
		rd.forward(request, response);
		
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		User user = DBHelper.authenticate(username, password);
		
		userBean = new UserBean();
		userBean.setUserId(user.getUserId());
		userBean.setUsername(user.getUsername());
		userBean.setName(user.getName());
		request.getSession().setAttribute("userBean", userBean);
		response.sendRedirect("/Comp303FinalProject/Profile");
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/profile.xhtml");
//		rd.forward(request, response);
	}

}
