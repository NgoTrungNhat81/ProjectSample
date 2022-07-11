//
package com.vti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.dto.CategoryDTO;

@Entity
@Table(name = "products", catalog = "quametmoi")
public class Product {
	

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ProductID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "CategoryID", nullable = false)
	private Category category;
	
	@Column(name = "ProductName", length = 255, nullable = false, unique = true)
	private String productname;
	
	@Column(name = "`Description`", length = 255)
	private String description;
	
	@Column(name = "Image", length = 255)
	private String image;
	
	
	@Column(name = "SellPrice", nullable = false)
	private int sellprice;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	

	public Product(){
		
	}
	
	
	public Product(int id,Category category,String productname,String description,String image, int sellprice){
			this.id 		 = id;
			this.category	 = category;
			this.productname = productname;
			this.description = description;
			this.image		 = image;
			this.sellprice	 = sellprice;
	}
	
	/**
	 * @return the id
	 */
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	
	}


	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	
	}
	
	

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	/**
	 * @return the sellprice
	 */
	public int getSellprice() {
		return sellprice;
	}

	/**
	 * @param sellprice the sellprice to set
	 */
	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	
	}




	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", description="
				+ description + ", sellprice=" + sellprice +  ", createDate=" + createDate + "]";
	}
	
	
	
	
	
	
	

}
