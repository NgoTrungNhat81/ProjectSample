package com.vti.service;

import java.util.List;

import com.vti.entity.Cart;


public interface ICartService {

	public List<Cart> getAllCarts();

	public Cart getCartByID(int id);

	public void createCart(Cart cart);

	public void updateCart(Cart cart);

	public void deleteCart(int id);

	
}
