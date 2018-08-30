package com.sofrecom.suivi_effectif.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.functions.Functions;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.stereotype.Component;

import com.sofrecom.suivi_effectif.DAO.TrunOverDAO;
import com.sofrecom.suivi_effectif.model.ListeEffectif;
import com.sofrecom.suivi_effectif.model.TurnOver;

public class TurnOverDaoImpl implements TrunOverDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<TurnOver> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("From TurnOver").list();
	}

	public TurnOver findById(long arg0) {
		return (TurnOver) getSessionFactory().getCurrentSession().get(TurnOver.class, arg0);
	}

	public List<TurnOver>findByMonthAndYear(String mois,String date) {
		List<TurnOver> turnOver = new ArrayList<TurnOver>();
		turnOver = getSessionFactory().getCurrentSession().createQuery("From TurnOver Where mois=? AND année=?")
				.setParameter(0, mois).setParameter(1, date).list();
		if (turnOver.size() > 0) {
			return turnOver;
		} else {
			return null;
		}
	}

	public void save(TurnOver arg0) {
		getSessionFactory().getCurrentSession().save(arg0);

	}

	public void delete(TurnOver arg0) {
		getSessionFactory().getCurrentSession().delete(arg0);

	}

	public long NbreDepart(String Pole, String Mois1, String Mois2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE((Date_de_sortie >=? AND Date_de_sortie<?)AND (Motif_de_sortie IN ('mobilité','Démission')) AND (Pôle=?))")
				.setParameter(0, Mois1).setParameter(1, Mois2).setParameter(2, Pole).list();

		return (long) intList.get(0);
	}


	public long NbreEffectif(String Pole, String date1, String date2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM ListeEffectif WHERE((Date_dentrée<? )AND (Pôle=?))")
				.setParameter(0, date1).setParameter(1, Pole).list();
		intList.addAll(getSessionFactory().getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM ListeEffectif WHERE((Date_de_sortie<? )AND (Pôle=?))")
				.setParameter(0, date2).setParameter(1, Pole).list());
		long a = intList.get(0) - intList.get(1);
		return a;

	}

	public long NbreMobilité(String Pole, String Mois1, String Mois2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE((Date_de_sortie >=? AND Date_de_sortie<? )AND (Motif_de_sortie ='mobilité') AND (Pôle=?))")
				.setParameter(0, Mois1).setParameter(1, Mois2).setParameter(2, Pole).list();

		return (long) intList.get(0);
	}

	public long NbreDem(String Pole, String Mois1, String Mois2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE((Date_de_sortie >=? AND Date_de_sortie<? )AND (Motif_de_sortie ='Démission') AND (Pôle=?))")
				.setParameter(0, Mois1).setParameter(1, Mois2).setParameter(2, Pole).list();

		return (long) intList.get(0);
	}

	public long NbreCongéSansSolde(String Pole, String Mois1, String Mois2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE((Date_de_sortie >=? AND Date_de_sortie<? )AND (Motif_de_sortie ='Congé sans solde') AND (Pôle=?))")
				.setParameter(0, Mois1).setParameter(1, Mois2).setParameter(2, Pole).list();

		return (long) intList.get(0);
	}

	public long NbrTalentSharing(String Pole, String Mois1, String Mois2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE((Date_de_sortie >=? AND Date_de_sortie<?)AND (Motif_de_sortie ='Talent Sharing') AND (Pôle=?))")
				.setParameter(0, Mois1).setParameter(1, Mois2).setParameter(2, Pole).list();

		return (long) intList.get(0);
	}

	@Override
	public void update(TurnOver t) {
		getSessionFactory().getCurrentSession().update(t);
		
	}

	@Override
	public List<TurnOver> findByYear(String date) {
		List<TurnOver> turnOver = new ArrayList<TurnOver>();
		turnOver = getSessionFactory().getCurrentSession().createQuery("From TurnOver Where année=?")
				.setParameter(0, date).list();
		if (turnOver.size() > 0) {
			return turnOver;
		} else {
			return null;
		}
	}

	@Override
	public long NbreEntree(String Pole, String Mois1, String Mois2) {
		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE((Date_dentrée >=? AND Date_dentrée<?) AND (Pôle=?))")
				.setParameter(0, Mois1).setParameter(1, Mois2).setParameter(2, Pole).list();
		return (long) intList.get(0);
	}
	
}
