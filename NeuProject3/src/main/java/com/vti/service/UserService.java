package com.vti.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.entity.RegistrationUserToken;
import com.vti.entity.User;
import com.vti.entity.UserStatus;
import com.vti.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.repository.IUserRepository;
import com.vti.repository.RegistrationUserTokenRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository repository;

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User getUserByID(int id) {
		return repository.findById(id).get();
	}




	public void updateUser(User user) {
		repository.save(user);
	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Check user exists by username
		User user = repository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole()));
	}
	
	
	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createUser(User user) {

		// encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// create user
		repository.save(user);

		// create new user registration token
		createNewRegistrationUserToken(user);

		// send email to confirm
		sendConfirmUserRegistrationViaEmail(user.getEmail());
	}

	private void createNewRegistrationUserToken(User user) {

	    final long EXPIRATION_TIME = 864000000; // 10 days
	    final String SECRET = "123456";
	    final String PREFIX_TOKEN = "Bearer";
	    final String AUTHORIZATION = "Authorization";
		// create new token for confirm Registration
		 String JWT = Jwts.builder()
	                .setSubject(user.getUserName())
	                .claim(user.getUserName(), user.getRole())
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SECRET)
	                .compact();
//		final String newToken = UUID.randomUUID().toString();
		RegistrationUserToken token = new RegistrationUserToken(JWT, user);

		registrationUserTokenRepository.save(token);
	}

	public void sendConfirmUserRegistrationViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
	}

	@Override
	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	/*
	 * @see com.vti.service.IUserService#activeUser(java.lang.String)
	 */
	@Override
	public void activeUser(String token) {
		RegistrationUserToken registrationUserToken = registrationUserTokenRepository.findByToken(token);

		User user = registrationUserToken.getUser();
		user.setStatus(UserStatus.ACTIVE);

		repository.save(user);

		// remove Registration User Token
		registrationUserTokenRepository.deleteById(registrationUserToken.getId());
	}
	
	
	

	public User findUserByName(String name) {
		return repository.findByUserName(name);
	}



}
