package com.sofrecom.suivi_effectif.DAO;

import java.util.List;

import com.sofrecom.suivi_effectif.model.Depart;


public interface DepartDAO {
	List<Depart> findAll();
	Depart findById(long arg0);
	List<Depart> findByPeriode(String date);
	void update(Depart t);
	void save(Depart arg0);
	void delete(Depart arg0);

}
