package com.sofrecom.suivi_effectif.Service.Impl;

import java.util.ArrayList;
import java.util.List;


import com.sofrecom.suivi_effectif.DAO.EntryDAO;
import com.sofrecom.suivi_effectif.Service.EntryService;
import com.sofrecom.suivi_effectif.Service.ListeEffectifService;
import com.sofrecom.suivi_effectif.Service.TurnOverService;
import com.sofrecom.suivi_effectif.model.Entry;
import com.sofrecom.suivi_effectif.model.ListeEffectif;
import com.sofrecom.suivi_effectif.model.TurnOver;

public class EntryServiceImpl implements EntryService {

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
	
	private EntryDAO entryDAO;

	public EntryDAO getEntryDAO() {
		return entryDAO;
	}

	public void setEntryDAO(EntryDAO entryDAO) {
		this.entryDAO = entryDAO;
	}

	@Override
	public List<Entry> getAllEntryData() {

		return getEntryDAO().findAll();
	}

	@Override
	public void saveEntry(Entry arg0) {
		getEntryDAO().save(arg0);
	}

	@Override
	public void deleteDataRaw(Entry arg0) {
		getEntryDAO().delete(arg0);
	}

	@Override
	public Entry getEntryById(Long arg0) {
		return getEntryDAO().findById(arg0);
	}

	@Override
	public List<Entry> EntryByPeriode(String date) {
		return getEntryDAO().findByPeriode(date);
	}

	@Override
	public void EnregisterLesEntry(String Pole) {
		List<TurnOver> turnOvers = new ArrayList<TurnOver>();
		List<ListeEffectif> listeEffectifs = new ArrayList<ListeEffectif>();
		turnOvers = getTurnOverService().getAllTurnData();
		Entry entry;
		for (TurnOver turnOver : turnOvers) {
			System.out.println(turnOver.getDate());
			listeEffectifs = getListeEffectifService().getDataEntryByPeriode(turnOver.getDate());
			for (ListeEffectif listeEffectif : listeEffectifs) {
				entry = new Entry();
				entry.setPeriode(turnOver.getDate());
				entry.setNom(listeEffectif.getNom());
				entry.setPrénom(listeEffectif.getPrénom());
				entry.setDépartement(listeEffectif.getDépartement());
				entry.setPoste_Administratif(listeEffectif.getPoste_Administratif());
				saveEntry(entry);
			}
		}
	}
}
