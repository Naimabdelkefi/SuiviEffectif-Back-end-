package com.sofrecom.suivi_effectif.DAO;

import java.util.List;

import com.sofrecom.suivi_effectif.model.TurnOver;

public interface TrunOverDAO {
	List<TurnOver> findAll();
	TurnOver findById(long arg0);
	List<TurnOver> findByMonthAndYear(String mois,String date);
	List<TurnOver> findByYear(String date);
	void update(TurnOver t);
	void save(TurnOver arg0);
	void delete(TurnOver arg0);
	public long NbreMobilité(String Pole,String Mois1,String Mois2);
	public long NbreDem(String Pole,String Mois1,String Mois2);
	public long NbreCongéSansSolde(String Pole,String Mois1,String Mois2);
	public long NbrTalentSharing(String Pole,String Mois1,String Mois2);
	public long NbreDepart(String Pole,String Mois1,String Mois2);
	public long NbreEntree(String Pole,String Mois1,String Mois2);
	public long NbreEffectif(String Pole,String date1,String date2);

}

