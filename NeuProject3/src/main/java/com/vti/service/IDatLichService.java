package com.vti.service;

import java.util.List;

import com.vti.entity.DatLich;


public interface IDatLichService {
	
	public List<DatLich> getAllDatLichs();

	public DatLich getDatLichByID(int id);

	public void createDatLich(DatLich datlich);

	public void updateDatLich(DatLich datlich);

	public void deleteDatLich(int id);
	
}
