package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phuongthuctt", catalog = "quametmoi")
public class PhuongThuc {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idTT")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tentt", length = 200, nullable = false, unique = true)
	private String phuongthucname;
	
	

	public PhuongThuc() {
		
	}
	public PhuongThuc(int id, String phuongthucname){
		this.id = id;
		this.phuongthucname = phuongthucname;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhuongthucname() {
		return phuongthucname;
	}
	public void setPhuongthucname(String phuongthucname) {
		this.phuongthucname = phuongthucname;
	}
	@Override
	public String toString() {
		return "PhuongThuc [id=" + id + ", phuongthucname=" + phuongthucname + "]";
	}
	
	
	
	

}
