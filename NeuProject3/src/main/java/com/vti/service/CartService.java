package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Cart;

import com.vti.repository.ICartRepository;


@Service
public class CartService implements ICartService{
	@Autowired
	private ICartRepository repository;

	public List<Cart> getAllCarts() {
		return repository.findAll();
	}

	public Cart getCartByID(int id) {
		return repository.findById(id).get();
	}


	public void createCart(Cart cart) {
		repository.save(cart);
	}

	public void updateCart(Cart cart) {
		repository.save(cart);
	}

	public void deleteCart(int id) {
		repository.deleteById(id);
	}

}
