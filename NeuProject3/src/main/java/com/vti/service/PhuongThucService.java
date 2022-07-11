package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.PhuongThuc;

import com.vti.repository.IPhuongThucRepository;


@Service
public class PhuongThucService implements IPhuongThucService{
	@Autowired
	private IPhuongThucRepository repository;

	public List<PhuongThuc> getAllPhuongThucs() {
		return repository.findAll();
	}

	public PhuongThuc getPhuongThucByID(int id) {
		return repository.findById(id).get();
	}


	public void createPhuongThuc(PhuongThuc phuongthuc) {
		repository.save(phuongthuc);
	}

	public void updatePhuongThuc(PhuongThuc phuongthuc) {
		repository.save(phuongthuc);
	}

	public void deletePhuongThuc(int id) {
		repository.deleteById(id);
	}
	


}
