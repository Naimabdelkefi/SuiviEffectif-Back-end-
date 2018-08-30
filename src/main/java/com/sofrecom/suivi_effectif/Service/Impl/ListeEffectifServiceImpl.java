package com.sofrecom.suivi_effectif.Service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.DAO.ListeEffectifDAO;
import com.sofrecom.suivi_effectif.Service.ListeEffectifService;
import com.sofrecom.suivi_effectif.model.ListeEffectif;
import com.sofrecom.suivi_effectif.model.TurnOver;

public class ListeEffectifServiceImpl implements ListeEffectifService {
	private ListeEffectifDAO listeEffectifDAO;
	public List<ListeEffectif> getAllData() {
		
		return getlisteEffectifDAO().findAll();
	}

	public ListeEffectifDAO getlisteEffectifDAO() {
		return listeEffectifDAO;
	}

	public void setlisteEffectifDAO(ListeEffectifDAO effectifDAO) {
		this.listeEffectifDAO = effectifDAO;
	}

	public void saveData(ListeEffectif arg0) {
		getlisteEffectifDAO().save(arg0);
		
	}

	public void deleteDataRaw(ListeEffectif arg0) {
		getlisteEffectifDAO().delete(arg0);
		
	}

	public ListeEffectif getDataById(Long arg0) {
		
		return getlisteEffectifDAO().findById(arg0);
	}

	public List<ListeEffectif> getDataByDateEntrée(String date) {
	
		return getlisteEffectifDAO().findByDate("entrée", date);
	}
	public class	Pourcetage{
		String Sexe;
		float valeur;
		public String getSexe() {
			return Sexe;
		}
		public void setSexe(String sexe) {
			Sexe = sexe;
		}
		public float getValeur() {
			return valeur;
		}
		public void setValeur(float valeur) {
			this.valeur = valeur;
		}
	}
	public class Departement{
		String deprt;
		long Nbre;
		public String getDeprt() {
			return deprt;
		}
		public void setDeprt(String deprt) {
			this.deprt = deprt;
		}
		public long getNbre() {
			return Nbre;
		}
		public void setNbre(long nbre) {
			Nbre = nbre;
		}
		
	}
	@Override
	public List<Pourcetage> PourcentageSexe(String Pole) {
		
		long h=getlisteEffectifDAO().NbreEffectifParSexe(Pole, "H");
		long f=getlisteEffectifDAO().NbreEffectifParSexe(Pole, "F");
		long t=getlisteEffectifDAO().NbreEffectifParSexe(Pole, "F")+getlisteEffectifDAO().NbreEffectifParSexe(Pole, "H");
		float ph=((float)h/(float)t);
		float pf=((float)f/(float)t);
		List<Pourcetage> listPourecntage = new ArrayList<Pourcetage>();
		Pourcetage p=new Pourcetage();
		p.setSexe("Homme");
		p.setValeur(ph*100);
		listPourecntage.add(p);
		p=new Pourcetage();
		p.setSexe("Femme");
		p.setValeur(pf*100);
		listPourecntage.add(p);
		return listPourecntage;
	}

	@Override
	public List<Departement> NbreDepratemnt(String Pole) {
		List<String> deprt = new ArrayList<String>();
		deprt.addAll(Arrays.asList("Developpement", "Architecture", "Direction", "Enablers", "Recharging", "PMO", "Innovation", "B2B Service & Contact Solutions","Integration","Expertise"));
		List<Departement> listDepartement = new ArrayList<Departement>();
		Departement d;
		for (int i = 0; i < deprt.size(); i++) {
			d=new Departement();
			d.setDeprt(deprt.get(i));
			d.setNbre(getlisteEffectifDAO().NbreEffectifParDeprt(Pole, deprt.get(i)));
			listDepartement.add(d);
		}
		return listDepartement;


	}

	@Override
	public List<ListeEffectif> getDataDepartByPeriode(String date) {
		return getlisteEffectifDAO().findByPeriode(date);
	}

	@Override
	public List<ListeEffectif> getDataEntryByPeriode(String date) {
		return getlisteEffectifDAO().findEntryByPeriode(date);
	}

	@Override
	public void update(ListeEffectif e) {
		getlisteEffectifDAO().update(e);
		
	}

	

}
