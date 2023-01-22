package com.pelatro.Myecom.model;

import java.util.*;

import org.postgresql.util.PGTimestamp;

public class Order {
	private long orderId;
	
	private double price;
	
	private long userId;
	
	private List<Long> productId;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", userId=" + userId + ", productId=" + productId
				+ ", address=" + address + ", placedAt=" + placedAt + ", deliveryDate=" + deliveryDate + ", state="
				+ state + ", pinCode=" + pinCode + ", quantity=" + quantity + "]";
	}




	private String address;

	private Date placedAt;
	
	private Date deliveryDate;
	
	private String state;
	
	private int pinCode;
	
	private long quantity;
	
	
	public Order(){}
	


	public Order(long orderId, double price, long userId, List<Long> productId, String address, Date placed_at,
			String state, int pinCode, long quantity, Date delivery) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.userId = userId;
		this.productId = productId;
		this.address = address;
		this.placedAt = placed_at;
		this.state = state;
		this.pinCode = pinCode;
		this.quantity = quantity;
		this.deliveryDate=delivery;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public List<Long> getProductId() {
		return productId;
	}


	public void setProductId(List<Long> productId) {
		this.productId = productId;
	}




	public Date getPlacedAt() {
		return placedAt;
	}




	public void setPlacedAt(Date placedAt) {
		this.placedAt = placedAt;
	}

	
	
}
