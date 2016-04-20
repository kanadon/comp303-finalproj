package model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@EmbeddedId
	private OrderId orderId;	
	@OneToMany(targetEntity=OrderProduct.class, mappedBy="order")
	private List<OrderProduct> orderProducts;	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="userId", referencedColumnName="userId")
	private User user;
	
	
	public OrderId getOrderId(){
		return orderId;
	}
	public void setOrderId(OrderId orderId){
		this.orderId = orderId;
	}
	
	public List<OrderProduct> getOrderProducts(){
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProduct> orderProducts){
		this.orderProducts = orderProducts;
	}
	
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}

//	public int getUserId() {
//		return userId();
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public Timestamp getDate() {
//		return date;
//	}
//
//	public void setDate(Timestamp date) {
//		this.date = date;
//	}	
}
