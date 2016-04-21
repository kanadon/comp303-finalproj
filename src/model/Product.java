package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	private int productId;
	private String name;
	private double price;
	private String description;
	@OneToMany(targetEntity=OrderProduct.class, mappedBy="product")
	private List<OrderProduct> orderProducts;
	
	
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public List<OrderProduct> getOrderProducts(){
		return orderProducts;
	}
}
