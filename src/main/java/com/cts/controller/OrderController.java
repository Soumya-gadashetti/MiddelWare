package com.cts.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entities.Cart;
import com.cts.entities.OrderT;
import com.cts.entities.User;
import com.cts.service.OrderService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
//	@Autowired
//	private CartService cService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/{cartId}/{userId}")
	void addOrder(@RequestBody OrderT order, @PathVariable Long cartId, @PathVariable Long userId) {
		order.setCart(new Cart(cartId));
		order.setAmount(1200);
		order.setDateTime(new Date().toString());
		order.setType("DEBIT");
		order.setUser(new User(userId));
		service.addOrder(order);
	}

	@RequestMapping("/all")
	List<OrderT> allOrders(){
		return service.getAllOrders();
	}
}
