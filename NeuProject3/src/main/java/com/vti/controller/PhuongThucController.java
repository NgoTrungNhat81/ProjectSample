package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vti.entity.PhuongThuc;

import com.vti.service.IPhuongThucService;


@RestController
@RequestMapping(value = "api/v1/phuongthucs")
@CrossOrigin(origins = "http://localhost:4200")
public class PhuongThucController {
	@Autowired
	private IPhuongThucService service;

	@GetMapping()
	public ResponseEntity<?> getAllPhuongThucs() {
		//get data
		List<PhuongThuc> entities = service.getAllPhuongThucs();	
				
 		return new ResponseEntity<List<PhuongThuc>>(entities, HttpStatus.OK);
 }
	

	@GetMapping(value = "/{id}")
	public PhuongThuc getPhuongThucByID(@PathVariable(name = "id") int id) {
		PhuongThuc phuongthuc = service.getPhuongThucByID(id);	
		return phuongthuc;
	}
	
	@PostMapping()
	public ResponseEntity<?> createPhuongThuc(@RequestBody PhuongThuc phuongthuc) {
		service.createPhuongThuc(phuongthuc);			
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updatePhuongThuc(@PathVariable(name = "id") int id, @RequestBody PhuongThuc phuongthuc) {		
		
		phuongthuc.setId(id);
		service.updatePhuongThuc(phuongthuc);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
//	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePhuongThuc(@PathVariable(name = "id") int id) {
		service.deletePhuongThuc(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
