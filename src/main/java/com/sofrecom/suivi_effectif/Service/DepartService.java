package com.sofrecom.suivi_effectif.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.model.Depart;


public interface DepartService {
	List<Depart>getAllDepartData();
	void saveDepart(Depart arg0);

	void deleteDataRaw(Depart arg0);
	public Depart getDepartById(Long arg0); 
	public  List<Depart>  DepartByPeriode(String date);
	public void EnregisterLesDepart(String Pole);

	
}
