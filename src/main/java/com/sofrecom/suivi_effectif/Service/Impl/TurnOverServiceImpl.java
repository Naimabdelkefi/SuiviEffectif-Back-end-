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

	public TurnOver getTurnByMonthAndYear(String Mois, String Ann�e) {

		return getTurnOverDAO().findByMonthAndYear(Mois, Ann�e).get(0);
	}

	public long NbreDepartParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
			break;
		}

		}
		return getTurnOverDAO().NbreDepart(Pole, mois1, mois2);

	}

	@Override
	public long NbreEffectifParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
			break;
		}

		}
		return getTurnOverDAO().NbreEffectif(Pole, mois2, mois2);

	}

	@Override
	public void SaveDonneeparMois(String Pole, String Mois, String Ann�e) {
		TurnOver turnOver = new TurnOver();
		turnOver.setAnn�e(Ann�e);
		turnOver.setMois(Mois);
		turnOver.setDepart(NbreDepartParMois(Pole, Mois, Ann�e));
		turnOver.setEffectif(NbreEffectifParMois(Pole, Mois, Ann�e));
		turnOver.setCong�SansSolde(NbreCong�SansSoldeParMois(Pole, Mois, Ann�e));
		turnOver.setD�mission(NbreD�missionParMois(Pole, Mois, Ann�e));
		turnOver.setTalentSharing(NbreTalentSharingParMois(Pole, Mois, Ann�e));
		turnOver.setMobilit�(NbreMobilit�ParMois(Pole, Mois, Ann�e));

		saveTurn(turnOver);
	}

	public void SaveDonnee(String Pole) {
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao�t",
				"Septembre", "Octobre", "Novembre", "D�cembre"));
		Calendar now = Calendar.getInstance();
		int an�e = now.get(Calendar.YEAR);
		int an = 2017;
		for (int j = 0; an < an�e; j++) {
			an = 2017 + j;
			String Ann�e = Integer.toString(an);
			for (int i = 0; i < months.size(); i++) {
				SaveDonneeparMois(Pole, months.get(i), Ann�e);
			}
		}
	}

	@Override
	public long NbreMobilit�ParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
			break;

		}
		}
		return getTurnOverDAO().NbreMobilit�(Pole, mois1, mois2);
	}

	@Override
	public long NbreD�missionParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
			break;
		}
		}
		return getTurnOverDAO().NbreDem(Pole, mois1, mois2);
	}

	@Override
	public long NbreCong�SansSoldeParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
			break;
		}
		}
		return getTurnOverDAO().NbreCong�SansSolde(Pole, mois1, mois2);
	}

	public long NbreTalentSharingParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
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
		months.addAll(Arrays.asList("Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao�t",
				"Septembre", "Octobre", "Novembre", "D�cembre"));
		Calendar now = Calendar.getInstance();
		int an�e=now.get(Calendar.YEAR);
		int an = 2018;
		for (int j = 0; (an = 2018 + j)<=an�e; j++) {
			
			String Ann�e = Integer.toString(an);
		TurnOver t = new TurnOver();
		for (int i = 0; i < months.size(); i++) {
			t = getTurnByMonthAndYear(months.get(i), Ann�e);
			if(t!=null) {
			t.setValeur(CalculTurnOverParMois(Pole, months.get(i), Ann�e));
			getTurnOverDAO().update(t);}

		}}

	}

	@Override
	public List<TurnOver> getTurnByYear(String Ann�e) {
		return getTurnOverDAO().findByYear(Ann�e);
	}

	@Override
	public String CalculTurnOverDate(String Mois, String Ann�e) {
		String date = "";
		switch (Mois) {
		case "Janvier": {
			date = Ann�e + "-01";
			break;
		}
		case "F�vrier": {
			date = Ann�e + "-02";
			break;
		}
		case "Mars": {
			date = Ann�e + "-03";
			break;
		}
		case "Avril": {
			date = Ann�e + "-04";
			break;
		}
		case "Mai": {
			date = Ann�e + "-05";
			break;
		}
		case "Juin": {
			date = Ann�e + "-06";
			break;
		}
		case "Juillet": {
			date = Ann�e + "-07";
			break;
		}
		case "Ao�t": {
			date = Ann�e + "-08";
			break;
		}
		case "Septembre": {
			date = Ann�e + "-09";
			break;
		}
		case "Octobre": {
			date = Ann�e + "-10";
			break;
		}
		case "Novembre": {
			date = Ann�e + "-11";
			break;
		}
		case "D�cembre": {
			date = Ann�e + "-12";
			break;
		}
		}
		return date;
	}

	@Override
	public void saveTurnDate(String Pole) {
		
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao�t",
				"Septembre", "Octobre", "Novembre", "D�cembre"));
		TurnOver t = new TurnOver();
		Calendar now = Calendar.getInstance();
		int an�e=now.get(Calendar.YEAR);
		int an = 2017;
		for (int j = 0; an <an�e; j++) {
			an = 2017 + j;
			String Ann�e = Integer.toString(an);
			for (int i = 0; i < months.size(); i++) {
				t = getTurnByMonthAndYear(months.get(i), Ann�e);
				t.setDate(CalculTurnOverDate(months.get(i), Ann�e));
				getTurnOverDAO().update(t);
			
	}}
	}

	@Override
	public long NbreEntreeParMois(String Pole, String Mois, String Ann�e) {
		String mois1 = "", mois2 = "";
		switch (Mois) {
		case "Janvier": {
			mois1 = Ann�e + "-01" + "-01";
			mois2 = Ann�e + "-02" + "-01";
			break;
		}
		case "F�vrier": {
			mois1 = Ann�e + "-02" + "-01";
			mois2 = Ann�e + "-03" + "-01";
			break;
		}
		case "Mars": {
			mois1 = Ann�e + "-03" + "-01";
			mois2 = Ann�e + "-04" + "-01";
			break;
		}
		case "Avril": {
			mois1 = Ann�e + "-04" + "-01";
			mois2 = Ann�e + "-05" + "-01";
			break;
		}
		case "Mai": {
			mois1 = Ann�e + "-05" + "-01";
			mois2 = Ann�e + "-06" + "-01";
			break;
		}
		case "Juin": {
			mois1 = Ann�e + "-06" + "-01";
			mois2 = Ann�e + "-07" + "-01";
			break;
		}
		case "Juillet": {
			mois1 = Ann�e + "-07" + "-01";
			mois2 = Ann�e + "-08" + "-01";
			break;
		}
		case "Ao�t": {
			mois1 = Ann�e + "-08" + "-01";
			mois2 = Ann�e + "-09" + "-01";
			break;
		}
		case "Septembre": {
			mois1 = Ann�e + "-09" + "-01";
			mois2 = Ann�e + "-10" + "-01";
			break;
		}
		case "Octobre": {
			mois1 = Ann�e + "-10" + "-01";
			mois2 = Ann�e + "-11" + "-01";
			break;
		}
		case "Novembre": {
			mois1 = Ann�e + "-11" + "-01";
			mois2 = Ann�e + "-12" + "-01";
			break;
		}
		case "D�cembre": {
			mois1 = Ann�e + "-12" + "-01";
			mois2 = Ann�e + "-12" + "-31";
			break;
		}

		}
		return getTurnOverDAO().NbreEntree(Pole, mois1, mois2);
	}

	@Override
	public void saveTurnEntree(String Pole) {
		List<String> months = new ArrayList<String>();
		months.addAll(Arrays.asList("Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao�t",
				"Septembre", "Octobre", "Novembre", "D�cembre"));
		TurnOver t;
		Calendar now = Calendar.getInstance();
		int an�e=now.get(Calendar.YEAR);
		int an = 2017;
		for (int j = 0; an <an�e; j++) {
			an = 2017 + j;
			String Ann�e = Integer.toString(an);
		for (int i = 0; i < months.size(); i++) {
			t = new TurnOver();

			t = getTurnByMonthAndYear(months.get(i), Ann�e);
			System.out.println(NbreEntreeParMois(Pole, months.get(i), Ann�e));
			t.setEntree(NbreEntreeParMois(Pole, months.get(i), Ann�e));
			getTurnOverDAO().update(t);

		}}

	}

}
