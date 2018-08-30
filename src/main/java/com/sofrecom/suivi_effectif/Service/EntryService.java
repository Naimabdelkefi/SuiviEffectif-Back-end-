package com.sofrecom.suivi_effectif.Service;

import java.util.List;

import com.sofrecom.suivi_effectif.model.Entry;

public interface EntryService {
	List<Entry>getAllEntryData();
	void saveEntry(Entry arg0);

	void deleteDataRaw(Entry arg0);
	public Entry getEntryById(Long arg0); 
	public  List<Entry>  EntryByPeriode(String date);
	public void EnregisterLesEntry(String Pole);
}
