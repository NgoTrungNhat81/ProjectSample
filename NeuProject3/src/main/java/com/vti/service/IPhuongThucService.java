package com.vti.service;

import java.util.List;

import com.vti.entity.PhuongThuc;


public interface IPhuongThucService {

	public List<PhuongThuc> getAllPhuongThucs();

	public PhuongThuc getPhuongThucByID(int id);

	public void createPhuongThuc(PhuongThuc phuongthuc);

	public void updatePhuongThuc(PhuongThuc phuongthuc);

	public void deletePhuongThuc(int id);

}
