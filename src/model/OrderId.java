package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private Timestamp date;	
	
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
	
	@Override
	public int hashCode(){
		return (int) date.hashCode() + userId;
	}
	@Override
	public boolean equals(Object obj){
		if (obj == this) return true;
		if(!(obj instanceof OrderId)) return false;
		if (obj == null) return false;
		OrderId orderId = (OrderId) obj;
		return orderId.userId == this.userId && orderId.date == this.date;
	}
}
