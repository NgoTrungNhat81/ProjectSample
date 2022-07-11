package com.vti.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Cart;


public interface ICartRepository extends JpaRepository<Cart, Integer>  {
	

}
