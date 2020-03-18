package com.cts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
public class OrderT extends Transaction{ //giving the class name as "Order" it results in create table sql exception

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	private double amount;
	
	@OneToOne
	private Cart cart;



	public OrderT() {
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public OrderT(Cart cart) {
		this.cart = cart;
	}

}
