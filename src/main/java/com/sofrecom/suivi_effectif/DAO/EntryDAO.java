package com.sofrecom.suivi_effectif.DAO;

import java.util.List;

import com.sofrecom.suivi_effectif.model.Entry;

public interface EntryDAO {
	List<Entry> findAll();
	Entry findById(long arg0);
	List<Entry> findByPeriode(String date);
	void update(Entry t);
	void save(Entry arg0);
	void delete(Entry arg0);
}
