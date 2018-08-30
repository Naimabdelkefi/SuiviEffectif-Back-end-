package com.sofrecom.suivi_effectif.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.sofrecom.suivi_effectif.DAO.DepartDAO;
import com.sofrecom.suivi_effectif.model.Depart;


public class DepartDaoImpl implements DepartDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Depart> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("From Depart").list();
	}

	@Override
	public Depart findById(long arg0) {
		return (Depart) getSessionFactory().getCurrentSession().get(Depart.class, arg0);
	}

	@Override
	public List<Depart> findByPeriode(String date) {
		List<Depart> departs = new ArrayList<Depart>();
		departs = getSessionFactory().getCurrentSession().createQuery("From Depart Where Periode=?")
				.setParameter(0, date).list();
		if (departs.size() > 0) {
			return departs;
		} else {
			return null;
		}
	}

	@Override
	public void update(Depart t) {
		getSessionFactory().getCurrentSession().update(t);

	}

	@Override
	public void save(Depart arg0) {
		getSessionFactory().getCurrentSession().save(arg0);

	}

	@Override
	public void delete(Depart arg0) {	getSessionFactory().getCurrentSession().delete(arg0);
	}

}
