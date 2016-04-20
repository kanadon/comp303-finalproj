package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private int userId;
	private String username;
	private String password;
	private String name;
	@OneToMany(targetEntity=Order.class, mappedBy="user")
	private List<Order> orders;
	
	public List<Order> getOrders(){
		return orders;
	}
	public int getUserId(){
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
