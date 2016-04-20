//package model;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "products")
//public class Product {
//	@Id
//	private int productId;
//	private String name;
//	private double price;
//	private String description;
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="orders")
//	private List<Order> orders;
//
//	public double getPrice() {
//		return price;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public String getName() {
//		return name;
//	}
//	
//	public List<Order> getOrders(){
//		return orders;
//	}
//	
//}
