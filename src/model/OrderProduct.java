package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders_products")
public class OrderProduct {
	@EmbeddedId
	private OrderProductId orderProductId;	
	private int quantity;
	@ManyToOne
	@JoinColumns({
        @JoinColumn(name="userId", referencedColumnName="userId", insertable=false, updatable=false),
        @JoinColumn(name="date", referencedColumnName="date", insertable=false, updatable=false)
    })
	private Order order;	
	@ManyToOne
	@JoinColumn(name="productId", referencedColumnName="productId", insertable=false, updatable=false)
	private Product product;


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderProductId getOrderProductId(){
		return orderProductId;
	}
	public void setOrderProductId(OrderProductId orderProductId){
		this.orderProductId = orderProductId;
	}
	public Order getOrder(){
		return order;
	}
	public void setOrder(Order order){
		this.order = order;
	}
	public Product getProduct(){
		return product;
	}
	public void setProduct(Product product){
		this.product = product;
	}
}
