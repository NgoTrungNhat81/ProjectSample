package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vti.entity.Cart;

import com.vti.service.ICartService;


@RestController
@RequestMapping(value = "api/v1/carts")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	@Autowired
	private ICartService service;

	@GetMapping()
	public ResponseEntity<?> getAllCarts() {
		//get data
		List<Cart> entities = service.getAllCarts();	
				
 		return new ResponseEntity<List<Cart>>(entities, HttpStatus.OK);
 }
	

	@GetMapping(value = "/{id}")
	public Cart getCartByID(@PathVariable(name = "id") int id) {
		Cart cart = service.getCartByID(id);	
		return cart;
	}
	
	@PostMapping()
	public ResponseEntity<?> createCart(@RequestBody Cart cart) {
		service.createCart(cart);			
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCart(@PathVariable(name = "id") int id, @RequestBody Cart cart) {		
		
		cart.setId(id);
		service.updateCart(cart);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable(name = "id") int id) {
		service.deleteCart(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	
	
}
