package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private Timestamp date;	
	private int productId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	
	@Override
	public int hashCode(){
		return (int) date.hashCode() + userId + productId;
	}
	@Override
	public boolean equals(Object obj){
		if (obj == this) return true;
		if(!(obj instanceof OrderProductId)) return false;
//		if (obj == null) return false;
		OrderProductId orderProductId = (OrderProductId) obj;
		return orderProductId.userId == this.userId && orderProductId.date == this.date && orderProductId.productId == this.productId;
	}
}