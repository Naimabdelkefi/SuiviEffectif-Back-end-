package com.sofrecom.suivi_effectif.Service.Impl;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.DAO.TrunOverDAO;
import com.sofrecom.suivi_effectif.Service.TurnOverService;
import com.sofrecom.suivi_effectif.model.TurnOver;

public class TurnOverServiceImpl implements TurnOverService {

	private TrunOverDAO turnOverDAO;

	public List<TurnOver> getAllTurnData() {
		return getTurnOverDAO().findAll();
	}

	public TrunOverDAO getTurnOverDAO() {
		return turnOverDAO;
	}

	public void setTurnOverDAO(TrunOverDAO turnOverDao) {
		this.turnOverDAO = turnOverDao;
	}

	public void saveTurn(TurnOver arg0) {
		getTurnOverDAO().save(arg0);
	}

	public void deleteDataRaw(TurnOver arg0) {
		getTurnOverDAO().delete(arg0);
	}

	public TurnOver getTurnById(Long arg0) {
		return getTurnOverDAO().findById(arg0);
	}

	public TurnOver getTurnByMonthAndYear(String Mois, String Année) {

		return getTurnOverDAO().findByMonthAndYear(Mois, Année).get(0);
	}

	public long NbreDepartParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;
		}

		}
		return getTurnOverDAO().NbreDepart(Pole, mois1, mois2);

	}

	@Override
	public long NbreEffectifParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;
		}

		}
		return getTurnOverDAO().NbreEffectif(Pole, mois2, mois2);

	}

	@Override
	public void SaveDonneeparMois(String Pole, String Mois, String Année) {
		TurnOver turnOver = new TurnOver();
		turnOver.setAnnée(Année);
		turnOver.setMois(Mois);
		turnOver.setDepart(NbreDepartParMois(Pole, Mois, Année));
		turnOver.setEffectif(NbreEffectifParMois(Pole, Mois, Année));
		turnOver.setCongéSansSolde(NbreCongéSansSoldeParMois(Pole, Mois, Année));
		turnOver.setDémission(NbreDémissionParMois(Pole, Mois, Année));
		turnOver.setTalentSharing(NbreTalentSharingParMois(Pole, Mois, Année));
		turnOver.setMobilité(NbreMobilitéParMois(Pole, Mois, Année));

		saveTurn(turnOver);
	}

	public void SaveDonnee(String Pole) {
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
				"Septembre", "Octobre", "Novembre", "Décembre"));
		Calendar now = Calendar.getInstance();
		int anée = now.get(Calendar.YEAR);
		int an = 2017;
		for (int j = 0; an < anée; j++) {
			an = 2017 + j;
			String Année = Integer.toString(an);
			for (int i = 0; i < months.size(); i++) {
				SaveDonneeparMois(Pole, months.get(i), Année);
			}
		}
	}

	@Override
	public long NbreMobilitéParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;

		}
		}
		return getTurnOverDAO().NbreMobilité(Pole, mois1, mois2);
	}

	@Override
	public long NbreDémissionParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;
		}
		}
		return getTurnOverDAO().NbreDem(Pole, mois1, mois2);
	}

	@Override
	public long NbreCongéSansSoldeParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;
		}
		}
		return getTurnOverDAO().NbreCongéSansSolde(Pole, mois1, mois2);
	}

	public long NbreTalentSharingParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;
		}
		}
		return getTurnOverDAO().NbrTalentSharing(Pole, mois1, mois2);
	}

	public float CalculTurnOverParMois(String Pole, String Mois, String Year) {
		TurnOver turnOver = getTurnOverDAO().findByMonthAndYear(Mois, Year).get(0);
		long id = turnOver.getID();
		long s1 = 0, s2 = 0;
		TurnOver effectif = new TurnOver();
		for (int i = (int) (id - 11); i <= id; i++) {
			System.out.println("index=" + i);
			effectif = getTurnOverDAO().findById(i);
			s2 = s2 + effectif.getDepart();
			s1 = s1 + effectif.getEffectif();
		}
		float avg = s1 / 12;
		return (s2 / avg) * 100;
	}

	@Override
	public void SaveTurnOver(String Pole) {
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
				"Septembre", "Octobre", "Novembre", "Décembre"));
		Calendar now = Calendar.getInstance();
		int anée=now.get(Calendar.YEAR);
		int an = 2018;
		for (int j = 0; (an = 2018 + j)<=anée; j++) {
			
			String Année = Integer.toString(an);
		TurnOver t = new TurnOver();
		for (int i = 0; i < months.size(); i++) {
			t = getTurnByMonthAndYear(months.get(i), Année);
			if(t!=null) {
			t.setValeur(CalculTurnOverParMois(Pole, months.get(i), Année));
			getTurnOverDAO().update(t);}

		}}

	}

	@Override
	public List<TurnOver> getTurnByYear(String Année) {
		return getTurnOverDAO().findByYear(Année);
	}

	@Override
	public String CalculTurnOverDate(String Mois, String Année) {
		String date = "";
		switch (Mois) {
		case "Janvier": {
			date = Année + "-01";
			break;
		}
		case "Février": {
			date = Année + "-02";
			break;
		}
		case "Mars": {
			date = Année + "-03";
			break;
		}
		case "Avril": {
			date = Année + "-04";
			break;
		}
		case "Mai": {
			date = Année + "-05";
			break;
		}
		case "Juin": {
			date = Année + "-06";
			break;
		}
		case "Juillet": {
			date = Année + "-07";
			break;
		}
		case "Août": {
			date = Année + "-08";
			break;
		}
		case "Septembre": {
			date = Année + "-09";
			break;
		}
		case "Octobre": {
			date = Année + "-10";
			break;
		}
		case "Novembre": {
			date = Année + "-11";
			break;
		}
		case "Décembre": {
			date = Année + "-12";
			break;
		}
		}
		return date;
	}

	@Override
	public void saveTurnDate(String Pole) {
		
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
				"Septembre", "Octobre", "Novembre", "Décembre"));
		TurnOver t = new TurnOver();
		Calendar now = Calendar.getInstance();
		int anée=now.get(Calendar.YEAR);
		int an = 2017;
		for (int j = 0; an <anée; j++) {
			an = 2017 + j;
			String Année = Integer.toString(an);
			for (int i = 0; i < months.size(); i++) {
				t = getTurnByMonthAndYear(months.get(i), Année);
				t.setDate(CalculTurnOverDate(months.get(i), Année));
				getTurnOverDAO().update(t);
			
	}}
	}

	@Override
	public long NbreEntreeParMois(String Pole, String Mois, String Année) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Année + "-01" + "-01";
			mois2 = Année + "-02" + "-01";
			break;
		}
		case "Février": {
			mois1 = Année + "-02" + "-01";
			mois2 = Année + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Année + "-03" + "-01";
			mois2 = Année + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Année + "-04" + "-01";
			mois2 = Année + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Année + "-05" + "-01";
			mois2 = Année + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Année + "-06" + "-01";
			mois2 = Année + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Année + "-07" + "-01";
			mois2 = Année + "-08" + "-01";
			break;
		}
		case "Août": {
			mois1 = Année + "-08" + "-01";
			mois2 = Année + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Année + "-09" + "-01";
			mois2 = Année + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Année + "-10" + "-01";
			mois2 = Année + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Année + "-11" + "-01";
			mois2 = Année + "-12" + "-01";
			break;
		}
		case "Décembre": {
			mois1 = Année + "-12" + "-01";
			mois2 = Année + "-12" + "-31";
			break;
		}

		}
		return getTurnOverDAO().NbreEntree(Pole, mois1, mois2);
	}

	@Override
	public void saveTurnEntree(String Pole) {
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
				"Septembre", "Octobre", "Novembre", "Décembre"));
		TurnOver t;
		Calendar now = Calendar.getInstance();
		int anée=now.get(Calendar.YEAR);
		int an = 2017;
		for (int j = 0; an <anée; j++) {
			an = 2017 + j;
			String Année = Integer.toString(an);
		for (int i = 0; i < months.size(); i++) {
			t = new TurnOver();

			t = getTurnByMonthAndYear(months.get(i), Année);
			System.out.println(NbreEntreeParMois(Pole, months.get(i), Année));
			t.setEntree(NbreEntreeParMois(Pole, months.get(i), Année));
			getTurnOverDAO().update(t);

		}}

	}

}
