package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.UserDTO;

import com.vti.entity.User;
import com.vti.service.IUserService;


@RequestMapping(value = "/api/v1/users")
@Validated
@RestController
@PreAuthorize("hasAnyAuthority('Admin','Manager','Member')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	@Autowired
	private IUserService service;

	@GetMapping()
	public ResponseEntity<?> getAllUsers() {
		//get data
		List<User> entities = service.getAllUsers();
	
		
		
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		
		
		//convert entity to dto
		for (User entity : entities) {
			UserDTO dto = new UserDTO();
			dto.setId(entity.getId());
			dto.setUserName(entity.getUserName());
			dto.setEmail(entity.getEmail());;
			dto.setPassword(entity.getPassword());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setAvatar(entity.getAvatar());
			dto.setRole(entity.getRole());
			dto.setDiachi(entity.getDiachi());
			dto.setSdt(entity.getSdt());
			dtos.add(dto);		
		}
	
	
		return new ResponseEntity<List<UserDTO>>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/findname")
	@ResponseBody
	public UserDTO getUserByName(@RequestParam("name") String name) {
		//get data
		User entity = service.findUserByName(name);
		
		//convert entity to dto
		
			UserDTO dto = new UserDTO();
			dto.setId(entity.getId());
			dto.setUserName(entity.getUserName());
			dto.setEmail(entity.getEmail());;
			dto.setPassword(entity.getPassword());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setAvatar(entity.getAvatar());
			dto.setRole(entity.getRole());
			dto.setDiachi(entity.getDiachi());
			dto.setSdt(entity.getSdt());
					
		return dto;
	}

	@GetMapping(value = "/{id}")
	public UserDTO getUserByID(@PathVariable(name = "id") int id) {
		User entity = service.getUserByID(id);
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.setEmail(entity.getEmail());;
		dto.setPassword(entity.getPassword());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setAvatar(entity.getAvatar());
		dto.setDiachi(entity.getDiachi());
		dto.setSdt(entity.getSdt());
		dto.setRole(entity.getRole());
		return dto;
	}
//
	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody UserDTO dto) {
		service.createUser(dto.toEntity());			
		return new ResponseEntity<String>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
	}
//
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "id") int id, @RequestBody UserDTO dto) {		
		User user  = dto.toEntity();
		user.setId(id);
		service.updateUser(user);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "id") int id) {
		service.deleteUser(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	

}
