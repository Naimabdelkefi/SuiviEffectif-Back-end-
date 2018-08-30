package com.sofrecom.suivi_effectif.DAO;

import java.util.List;

import com.sofrecom.suivi_effectif.model.ListeEffectif;

public interface ListeEffectifDAO {
	List<ListeEffectif> findAll();
	ListeEffectif findById(long arg0);
	List<ListeEffectif> findByDate(String type,String pram);
	List<ListeEffectif> findByPeriode(String periode);
	List<ListeEffectif> findEntryByPeriode(String periode);
	long NbreEffectifParSexe (String Pole,String sexe);
	long NbreEffectifParDeprt(String Pole,String deprt);
	
	void save(ListeEffectif arg0);
	void update(ListeEffectif e);
	void delete(ListeEffectif arg0);
}
