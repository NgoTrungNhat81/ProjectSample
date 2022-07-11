//
package com.vti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories", catalog = "quametmoi")
public class Category {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CategoryName", length = 255, nullable = false, unique = true)
	private String categoryname;
	
	@Column(name = "`Description`", length = 255)
	private String description;
	
//	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
//	private List<Product> products;
	
	
	public Category() {
		
	}
	public Category(int id, String categoryname, String description){
		this.id = id;
		this.categoryname = categoryname;
		this.description = description;
		
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
	 * @return the categoryname
	 */
	public String getCategoryname() {
		return categoryname;
	}

	/**
	 * @param categoryname the categoryname to set
	 */
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryname=" + categoryname + ", description=" + description
				 + "]";
	}


	
	
	
}
