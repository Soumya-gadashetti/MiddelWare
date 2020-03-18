package com.cts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entities.Cart;
import com.cts.entities.Item;
import com.cts.repository.CartRepository;
import com.cts.service.ItemService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService service;
	
	private Cart cart;
	
	
	@Autowired
	private CartRepository cRepo;

	@RequestMapping("/all")
	List<Item> getAll() {
		return service.getItems();
	}

	@RequestMapping("/{itemId}")
	Item getItemDetailsById(@PathVariable Long itemId) {
		return service.getItemById(itemId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cart/{itemId}" )
	void addItemToCart(@PathVariable Long itemId) {
		cart=new Cart(30.0,new ArrayList<Item>());
		cart.getItems().add(service.getItemById(itemId));
		cRepo.save(cart);
		
	}
	
//	@RequestMapping(value = "/cart/{itemId}" )
//	List<Item> addItemToCart(@PathVariable Long itemId) {
//		cart.setItem(service.getItemById(itemId));
//		cController.addInCart(cart);
//	}
	
/*	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/{subCategoryId}/{discountId}")
	void addItem(@RequestBody Item item, @PathVariable Long userId, @PathVariable Long subCategoryId,
			@PathVariable Long discountId) {
		item.setSeller(new Seller(userId));
		item.setSubCategory(new SubCategory(subCategoryId));
		item.setDiscount(new Discount(discountId));
//		if (LocalDate.now().isAfter(item.getDiscount().getStartDate())
//				&& LocalDate.now().isBefore(item.getDiscount().getEndDate())) {
//			double sPrice = item.getMarkedPrice() - (item.getDiscount().getPercent() / 100) * item.getMarkedPrice();
//			item.setSellingPrice(sPrice);
//		} else
//			item.setSellingPrice(item.getMarkedPrice());
		double sPrice = item.getMarkedPrice() - ((item.getDiscount().getPercent() / 100) * item.getMarkedPrice());
		item.setSellingPrice(sPrice);
		service.addItem(item);
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	void addItem(@RequestBody Item item) {
		service.addItem(item);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{itemId}")
	void deleteItemById(@PathVariable Long itemId) {
		service.deleteItem(itemId);
	}

	@RequestMapping(method = RequestMethod.PUT)
	void updateItem(@RequestBody Item item) {
		service.updateItem(item);
	}
}
