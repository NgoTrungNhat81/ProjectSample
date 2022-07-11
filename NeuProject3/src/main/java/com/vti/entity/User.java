//
package com.vti.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "`User`", catalog = "quametmoi")

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "UserID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "`username`", length = 50, nullable = false, unique = true)
	private String userName;
	
	@Column(name = "`email`", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "`password`", length = 200)
	private String password;
	
	@Column(name = "`firstName`", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "`lastName`", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "avatar", length = 800,nullable = false)
	private String avatar;
	
	@Column(name = "diachi", length = 200,nullable = false)
	private String diachi;
	
	@Column(name = "sdt", length = 20,nullable = false)
	private String sdt;
	
	@Column(name = "`role`", length=50,nullable = false)
	private String role;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`status`", nullable = false)
	private UserStatus status = UserStatus.NOT_ACTIVE;
	
	

	
//	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//	private List<Cart> carts;
	
	public User() {
	}
	
	public User(int id,String userName, String email, String password,String firstName,String lastName,String avatar,String diachi,String sdt, String role) {
		this.id		    = id;
		this.userName   = userName;
		this.email 		= email;
		this.password   = password;
		this.firstName  = firstName;
		this.lastName 	= lastName;
		this.avatar 	= avatar;
		this.diachi	    = diachi;
		this.sdt 	    = sdt;
		this.role       = role;
				
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
	 * @return the username
	 */
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	
	}
	
	

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", avatar=" + avatar + ", diachi=" + diachi
				+ ", sdt=" + sdt + ", role=" + role + ", status=" + status + "]";
	}

	
	
	

	
	


}
