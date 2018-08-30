package com.sofrecom.suivi_effectif.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.model.TurnOver;

public interface TurnOverService {
	List<TurnOver>getAllTurnData();
	void saveTurn(TurnOver arg0);

	void deleteDataRaw(TurnOver arg0);
	public TurnOver getTurnById(Long arg0); 
	public TurnOver getTurnByMonthAndYear(String Mois,String Année);
	public List<TurnOver> getTurnByYear(String Année);
	public long NbreDepartParMois(String Pole,String Mois,String Année);
	public long NbreEntreeParMois(String Pole,String Mois,String Année);
	public long NbreEffectifParMois(String Pole, String Mois,String Année);
	public long NbreMobilitéParMois(String Pole,String Mois,String Année);
	public long NbreDémissionParMois(String Pole,String Mois,String Année);
	public long NbreCongéSansSoldeParMois(String Pole,String Mois,String Année);
	public long NbreTalentSharingParMois(String Pole,String Mois,String Année);
	public void SaveDonneeparMois(String Pole,String Mois,String Année);
	public void SaveDonnee(String Pole);
	public float CalculTurnOverParMois(String Pole,String Mois,String Year);
	public void SaveTurnOver(String Pole);
	public String CalculTurnOverDate(String Mois,String Année);
	public void saveTurnDate(String Pole);
	public void saveTurnEntree(String Pole);
	
	

}
