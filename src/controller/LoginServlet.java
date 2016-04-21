package controller;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import model.User;

@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.xhtml");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean userBean = new UserBean();
		;
		User user;
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = ef.createEntityManager();
		Query q = em.createQuery("SELECT u FROM User AS u WHERE u.username = '" + username + "' AND u.password = '" + password +"'");
		q.setFirstResult(0);

		try {
			user = (User) q.getSingleResult();
			userBean.setUserId(user.getUserId());
			userBean.setUsername(user.getUsername());
			userBean.setName(user.getName());
			userBean.setAuthenticated(true);
			request.getSession().setAttribute("userBean", userBean);

			response.setContentType("application/json");
			JsonObject json = Json.createObjectBuilder().add("error", false)
					.add("redirect", "/Comp303FinalProject/Profile").build();
			response.getWriter().write(json.toString());

//			response.sendRedirect("/Comp303FinalProject/Profile");
		} catch (NoResultException nre) {
			userBean.setAuthenticated(false);
			response.setContentType("application/json");
			JsonObject json = Json.createObjectBuilder().add("error", true).build();
			response.getWriter().write(json.toString());
		}
	}
}
