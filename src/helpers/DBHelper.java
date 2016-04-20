package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.UserBean;
import model.User;

public class DBHelper {

	public static User authenticate(String username, String password){
		EntityManagerFactory ef = Persistence.createEntityManagerFactory( "FinalProject" );
		EntityManager em = ef.createEntityManager( );
		Query q = em.createQuery("SELECT u FROM User AS u WHERE u.username = 'denisd'");
		q.setFirstResult(0);
		User result = (User) q.getSingleResult();
		return result;
		
//		UserBean ub = new UserBean();
//		ub.setUsername(result.getUsername());
//		ub.setFirstName(result.getFirstName());
//		ub.setLastName(result.getLastName());
		
//		return new UserBean();
	}
}
