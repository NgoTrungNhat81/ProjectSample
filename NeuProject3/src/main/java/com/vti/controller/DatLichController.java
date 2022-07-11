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


import com.vti.entity.DatLich;

import com.vti.service.IDatLichService;


@RestController
@RequestMapping(value = "api/v1/datlichs")
@CrossOrigin(origins = "http://localhost:4200")
public class DatLichController {
	@Autowired
	private IDatLichService service;

	@GetMapping()
	public ResponseEntity<?> getAllDatLichs() {
		//get data
		List<DatLich> entities = service.getAllDatLichs();	
				
 		return new ResponseEntity<List<DatLich>>(entities, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public DatLich getDatLichByID(@PathVariable(name = "id") int id) {
		DatLich datlich = service.getDatLichByID(id);	
		return datlich;
	}
	
	@PostMapping()
	public ResponseEntity<?> createDatLich(@RequestBody DatLich datlich) {
		service.createDatLich(datlich);			
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDatLich(@PathVariable(name = "id") int id, @RequestBody DatLich datlich) {		
		
		datlich.setId(id);
		service.updateDatLich(datlich);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDatLich(@PathVariable(name = "id") int id) {
		service.deleteDatLich(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	

}
