package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datlich", catalog = "quametmoi")
public class DatLich {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DatlichID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "hoten", length = 50, nullable = false)
	private String hoten;
	
	@Column(name = "Phone", length = 50, nullable = false, unique = true)
	private String phone;
	
	@Column(name = "`description`", length = 200)
	private String description;
	
	@Column(name = "`require`", length = 200)
	private String require;
	
	@Column(name = "settime", length = 200)
	private String settime;
	
	@Column(name = "datefix", length = 50, nullable=false)
	private String datefix;
	
	@Column(name = "chinhanh", length = 100, nullable=false)
	private String chinhanh;
	
	public DatLich() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public String getSettime() {
		return settime;
	}

	public void setSettime(String settime) {
		this.settime = settime;
	}

	public String getDatefix() {
		return datefix;
	}

	public void setDatefix(String datefix) {
		this.datefix = datefix;
	}

	public String getChinhanh() {
		return chinhanh;
	}

	public void setChinhanh(String chinhanh) {
		this.chinhanh = chinhanh;
	}

	@Override
	public String toString() {
		return "DatLich [id=" + id + ", hoten=" + hoten + ", phone=" + phone + ", description=" + description
				+ ", require=" + require + ", settime=" + settime + ", datefix=" + datefix + ", chinhanh=" + chinhanh
				+ "]";
	}

	
	
	
	
}
