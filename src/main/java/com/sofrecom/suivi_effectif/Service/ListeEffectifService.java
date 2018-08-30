package com.sofrecom.suivi_effectif.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.Service.Impl.ListeEffectifServiceImpl.Pourcetage;
import com.sofrecom.suivi_effectif.Service.Impl.ListeEffectifServiceImpl.Departement;
import com.sofrecom.suivi_effectif.model.ListeEffectif;

public interface ListeEffectifService {
	List<ListeEffectif> getAllData();
	void update(ListeEffectif e);
	void saveData(ListeEffectif arg0);

	void deleteDataRaw(ListeEffectif arg0);
	public ListeEffectif getDataById(Long arg0);
	public List<ListeEffectif>  getDataByDateEntrée(String date);
	public List<Pourcetage> PourcentageSexe(String Pole);
	public List<Departement> NbreDepratemnt(String Pole);
	public List<ListeEffectif>  getDataDepartByPeriode(String date);
	public List<ListeEffectif>  getDataEntryByPeriode(String date);
}
