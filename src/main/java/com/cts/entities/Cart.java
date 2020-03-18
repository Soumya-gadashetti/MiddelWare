package com.cts.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cartId;
	private double amount;
	@OneToMany
	private List<Item> items;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Cart(double amount, List<Item> items) {
		super();
		this.amount = amount;
		this.items = items;
	}

	public Cart(Long cartId) {
		super();
		this.cartId = cartId;
	}

	public Cart() {
		super();
	}

}
