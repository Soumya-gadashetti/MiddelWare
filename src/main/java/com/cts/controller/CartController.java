package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entities.Cart;
import com.cts.service.CartService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService service;
	
//	@Autowired
//	private ItemService iService;
//	
//	@Autowired
//	private List<Item> items;
//
////	@RequestMapping(value = "/{itemId}" )
////	Item addItemToCart(Long itemId) {
////		return 
////	}
//	
//	
//
//	@RequestMapping(method = RequestMethod.POST, value = "/add")
//	void addInCart(@RequestBody Cart cart) {
//		cart.set
//	}
	
	@RequestMapping("/{cartId}")
	Optional<Cart> getCartById(@PathVariable Long cartId) {
		return service.getCartById(cartId);
	}

	@RequestMapping("/all")
	List<Cart> getAll(){
		return service.getAll();
	}
	
}
