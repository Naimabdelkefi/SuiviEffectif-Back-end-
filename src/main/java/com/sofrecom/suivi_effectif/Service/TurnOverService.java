package com.sofrecom.suivi_effectif.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.model.TurnOver;

public interface TurnOverService {
	List<TurnOver>getAllTurnData();
	void saveTurn(TurnOver arg0);

	void deleteDataRaw(TurnOver arg0);
	public TurnOver getTurnById(Long arg0); 
	public TurnOver getTurnByMonthAndYear(String Mois,String Ann�e);
	public List<TurnOver> getTurnByYear(String Ann�e);
	public long NbreDepartParMois(String Pole,String Mois,String Ann�e);
	public long NbreEntreeParMois(String Pole,String Mois,String Ann�e);
	public long NbreEffectifParMois(String Pole, String Mois,String Ann�e);
	public long NbreMobilit�ParMois(String Pole,String Mois,String Ann�e);
	public long NbreD�missionParMois(String Pole,String Mois,String Ann�e);
	public long NbreCong�SansSoldeParMois(String Pole,String Mois,String Ann�e);
	public long NbreTalentSharingParMois(String Pole,String Mois,String Ann�e);
	public void SaveDonneeparMois(String Pole,String Mois,String Ann�e);
	public void SaveDonnee(String Pole);
	public float CalculTurnOverParMois(String Pole,String Mois,String Year);
	public void SaveTurnOver(String Pole);
	public String CalculTurnOverDate(String Mois,String Ann�e);
	public void saveTurnDate(String Pole);
	public void saveTurnEntree(String Pole);
	
	

}
