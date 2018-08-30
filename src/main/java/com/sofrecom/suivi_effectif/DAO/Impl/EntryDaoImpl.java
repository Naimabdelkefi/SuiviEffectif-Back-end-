package com.sofrecom.suivi_effectif.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.sofrecom.suivi_effectif.DAO.EntryDAO;
import com.sofrecom.suivi_effectif.model.Entry;

public class EntryDaoImpl implements EntryDAO {
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Entry> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("From Entry").list();
	}

	@Override
	public Entry findById(long arg0) {
		return (Entry) getSessionFactory().getCurrentSession().get(Entry.class, arg0);
	}

	@Override
	public List<Entry> findByPeriode(String date) {
		List<Entry> departs = new ArrayList<Entry>();
		departs = getSessionFactory().getCurrentSession().createQuery("From Entry Where Periode=?")
				.setParameter(0, date).list();
		if (departs.size() > 0) {
			return departs;
		} else {
			return null;
		}
	}

	@Override
	public void update(Entry t) {
		getSessionFactory().getCurrentSession().update(t);

	}

	@Override
	public void save(Entry arg0) {
		getSessionFactory().getCurrentSession().save(arg0);

	}

	@Override
	public void delete(Entry arg0) {	getSessionFactory().getCurrentSession().delete(arg0);
	}
}
