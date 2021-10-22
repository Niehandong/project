package com.oracleoaec.pojo;


import java.util.List;

public class OrderView {
	private Order oder;
	private List<Shopping> shoppinglist;
	
	
	public OrderView() {

	}


	public OrderView(Order oder, List<Shopping> shoppinglist) {
		
		this.oder = oder;
		this.shoppinglist = shoppinglist;
	}


	public Order getOder() {
		return oder;
	}


	public void setOder(Order oder) {
		this.oder = oder;
	}


	public List<Shopping> getShoppinglist() {
		return shoppinglist;
	}


	public void setShoppinglist(List<Shopping> shoppinglist) {
		this.shoppinglist = shoppinglist;
	}
	
	
	
	
	
}
