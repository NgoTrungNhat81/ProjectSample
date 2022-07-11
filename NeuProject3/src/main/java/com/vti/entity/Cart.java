//
package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts", catalog = "quametmoi")
public class Cart {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CartID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ProductID", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idTT", nullable = false)
	private PhuongThuc phuongthuc;
	

	@Column(name = "quantity", nullable = false)
	private short quantity;
	
	@Column(name = "tongtien", nullable = false)
	private int tongtien;
	
	
	
	
	
	
	
	public Cart() {
	}
	
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
		
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
		
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
		
	}

	/**
	 * @return the quantity
	 */
	public short getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	
	


	
	public PhuongThuc getPhuongthuc() {
		return phuongthuc;
	}

	public void setPhuongthuc(PhuongThuc phuongthuc) {
		this.phuongthuc = phuongthuc;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	/* 
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", user=" + user + ", quantity=" + quantity + "]";
	}
	

}
