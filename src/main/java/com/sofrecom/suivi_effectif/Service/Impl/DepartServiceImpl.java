package com.sofrecom.suivi_effectif.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.suivi_effectif.DAO.DepartDAO;
import com.sofrecom.suivi_effectif.Service.DepartService;
import com.sofrecom.suivi_effectif.Service.ListeEffectifService;
import com.sofrecom.suivi_effectif.Service.TurnOverService;
import com.sofrecom.suivi_effectif.model.Depart;
import com.sofrecom.suivi_effectif.model.ListeEffectif;
import com.sofrecom.suivi_effectif.model.TurnOver;


public class DepartServiceImpl implements DepartService {

	TurnOverService turnOverService;
	
	public TurnOverService getTurnOverService() {
		return turnOverService;
	}

	public void setTurnOverService(TurnOverService turnOverService) {
		this.turnOverService = turnOverService;
	}

	public ListeEffectifService getListeEffectifService() {
		return listeEffectifService;
	}

	public void setListeEffectifService(ListeEffectifService listeEffectifService) {
		this.listeEffectifService = listeEffectifService;
	}
	ListeEffectifService listeEffectifService;
	
	private DepartDAO departDAO;

	public DepartDAO getDepartDAO() {
		return departDAO;
	}

	public void setDepartDAO(DepartDAO departDAO) {
		this.departDAO = departDAO;
	}

	@Override
	public List<Depart> getAllDepartData() {

		return getDepartDAO().findAll();
	}

	@Override
	public void saveDepart(Depart arg0) {
		getDepartDAO().save(arg0);
	}

	@Override
	public void deleteDataRaw(Depart arg0) {
		getDepartDAO().delete(arg0);
	}

	@Override
	public Depart getDepartById(Long arg0) {
		return getDepartDAO().findById(arg0);
	}

	@Override
	public List<Depart> DepartByPeriode(String date) {
		return getDepartDAO().findByPeriode(date);
	}

	@Override
	public void EnregisterLesDepart(String Pole) {
		List<TurnOver> turnOvers = new ArrayList<TurnOver>();
		List<ListeEffectif> listeEffectifs = new ArrayList<ListeEffectif>();
		turnOvers = getTurnOverService().getAllTurnData();
		Depart depart;
		for (TurnOver turnOver : turnOvers) {
			System.out.println(turnOver.getDate());
			listeEffectifs = getListeEffectifService().getDataDepartByPeriode(turnOver.getDate());
			for (ListeEffectif listeEffectif : listeEffectifs) {
				depart = new Depart();
				depart.setPeriode(turnOver.getDate());
				depart.setNom(listeEffectif.getNom());
				depart.setPrénom(listeEffectif.getPrénom());
				depart.setDépartement(listeEffectif.getDépartement());
				depart.setPoste_Administratif(listeEffectif.getPoste_Administratif());
				depart.setMotif(listeEffectif.getMotif_de_sortie());
				saveDepart(depart);
			}
		}
	}
}
