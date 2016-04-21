package bean;

import java.sql.Timestamp;
import java.util.AbstractMap;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="orderBean")
public class OrderBean {
	private int uid;
	private Timestamp date;
	private double cost;
	private ArrayList<AbstractMap.SimpleEntry<String, Integer>> products;
	
	public OrderBean(){
		products = new ArrayList<AbstractMap.SimpleEntry<String, Integer>>();
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ArrayList<AbstractMap.SimpleEntry<String, Integer>> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<AbstractMap.SimpleEntry<String, Integer>> products) {
		this.products = products;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
