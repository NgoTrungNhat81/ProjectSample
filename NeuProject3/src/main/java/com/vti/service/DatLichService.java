package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.DatLich;

import com.vti.repository.IDatLichRepository;



@Service
public class DatLichService implements IDatLichService{
	
	@Autowired
	private IDatLichRepository repository;

	public List<DatLich> getAllDatLichs() {
		return repository.findAll();
	}

	public DatLich getDatLichByID(int id) {
		return repository.findById(id).get();
	}


	public void createDatLich(DatLich datlich) {
		repository.save(datlich);
	}

	public void updateDatLich(DatLich datlich) {
		repository.save(datlich);
	}

	public void deleteDatLich(int id) {
		repository.deleteById(id);
	}
	
	
	
}
