package com.vti.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.User;

public interface IUserService extends UserDetailsService{
	public List<User> getAllUsers();

	public User getUserByID(int id);

	public void createUser(User user);
//
	public void updateUser(User user);
//
	public void deleteUser(int id);
	
	User findUserByEmail(String email);

	void activeUser(String token);

	void sendConfirmUserRegistrationViaEmail(String email);

	User findUserByName(String userName);

	
}
