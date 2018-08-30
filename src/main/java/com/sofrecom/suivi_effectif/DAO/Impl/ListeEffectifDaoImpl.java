package com.sofrecom.suivi_effectif.DAO.Impl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Calendar;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.hibernate.*;
import org.hibernate.SessionFactory.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import com.sofrecom.suivi_effectif.DAO.ListeEffectifDAO;
import com.sofrecom.suivi_effectif.model.ListeEffectif;


public class ListeEffectifDaoImpl implements ListeEffectifDAO {
	 Calendar now = Calendar.getInstance();
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ListeEffectif> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("FROM ListeEffectif").list();
	}

	public ListeEffectif findById(long arg0) {
		return (ListeEffectif) getSessionFactory().getCurrentSession().get(ListeEffectif.class, arg0);
	}

	public List<ListeEffectif> findByDate(String type, String pram) {
		if (type.equals("entrée"))
		{
			List<ListeEffectif> liste_effectifs= new ArrayList<ListeEffectif>();

			liste_effectifs = getSessionFactory().getCurrentSession().createQuery("from ListeEffectif where Date_dentrée=?").setParameter(0, pram).list();

			if (liste_effectifs.size() > 0) {
				return liste_effectifs;
			} else {
				return null;
			}
		}
		else if(type.equals("sortie")) {
			List<ListeEffectif> liste_effectifs= new ArrayList<ListeEffectif>();

			liste_effectifs = getSessionFactory().getCurrentSession().createQuery("from ListeEffectif where Date_de_sortie=?")
					.setParameter(0, pram).list();

			if (liste_effectifs.size() > 0) {
				return liste_effectifs;
			} else {
				return null;
			}
		}
		else if(type.equals("Démission")) {
			List<ListeEffectif> liste_effectifs= new ArrayList<ListeEffectif>();

			liste_effectifs = getSessionFactory().getCurrentSession().createQuery("from ListeEffectif where Date_dépôt_Démission=?")
					.setParameter(0, pram).list();

			if (liste_effectifs.size() > 0) {
				return liste_effectifs;
			} else {
				return null;
			}
		}
		return null;
	}
	

	public void save(ListeEffectif arg0) {
	getSessionFactory().getCurrentSession().save(arg0);
		
	}

	public void delete(ListeEffectif arg0) {
		getSessionFactory().getCurrentSession().delete(arg0);		
		
	}
	
	@Override
	public long NbreEffectifParSexe(String Pole, String sexe) {
		List<Long> intList = new ArrayList<Long>();
		Calendar now = Calendar.getInstance();
		   String m,a,d;
		  	if(now.get(Calendar.MONTH) + 1<10) {
		    m="0"+String.valueOf(now.get(Calendar.MONTH) + 1);}
		  	else m=String.valueOf(now.get(Calendar.MONTH) + 1);
		  	a=String.valueOf(now.get(Calendar.YEAR));
		  	d=a+'-'+m;
		  	String[] parts = d.split("-");
			int i= Integer.parseInt(parts[1]);
			i+=1;
			String ch=String.valueOf(i);
			if(i<10) {ch="0"+ch;}
			String mois1=d+"-01";
			String mois2=parts[0]+"-"+ch+"-01";
			System.out.println("mois1"+mois1);
			System.out.println("mois2"+mois2);	
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE(Date_de_sortie <? AND Date_dentrée<?) AND (HF=? ) AND (Pôle=?))")
				.setParameter(0, mois1).setParameter(1, mois2).setParameter(2, sexe).setParameter(3, Pole).list();

		return (long) intList.get(0);


	}

	@Override
	public long NbreEffectifParDeprt(String Pole, String deprt) {
		Calendar now = Calendar.getInstance();
		   String m,a,d;
		  	if(now.get(Calendar.MONTH) + 1<10) {
		    m="0"+String.valueOf(now.get(Calendar.MONTH) + 1);}
		  	else m=String.valueOf(now.get(Calendar.MONTH) + 1);
		  	a=String.valueOf(now.get(Calendar.YEAR));
		  	d=a+'-'+m;
		  	String[] parts = d.split("-");
			int i= Integer.parseInt(parts[1]);
			i+=1;
			String ch=String.valueOf(i);
			if(i<10) {ch="0"+ch;}
			String mois1=d+"-01";
			String mois2=parts[0]+"-"+ch+"-01";

		List<Long> intList = new ArrayList<Long>();
		intList = getSessionFactory().getCurrentSession().createQuery(
				"SELECT COUNT(*) FROM ListeEffectif WHERE (Date_de_sortie <? AND Date_dentrée<?) AND(Département=? ) AND (Pôle=?))")
				.setParameter(0, mois1).setParameter(1, mois2).setParameter(2, deprt).setParameter(3, Pole).list();

		return (long) intList.get(0);

	}

	@Override
	public List<ListeEffectif> findByPeriode(String periode) {
		List<ListeEffectif> liste_effectifs= new ArrayList<ListeEffectif>();
		String[] parts = periode.split("-");
		int i= Integer.parseInt(parts[1]);
		i+=1;
		String ch=String.valueOf(i);
		if(i<10) {ch="0"+ch;}
		String mois1=periode+"-01";
		String mois2=parts[0]+"-"+ch+"-01";
		System.out.println("mois1"+mois1);
		System.out.println("mois2"+mois2);
		liste_effectifs = getSessionFactory().getCurrentSession().createQuery("from ListeEffectif where (Date_de_sortie >=? AND Date_de_sortie<?)AND (Pôle='OLS')")
				.setParameter(0, mois1).setParameter(1, mois2).list();

	
			return liste_effectifs;
		
	}
	@Override
	public List<ListeEffectif> findEntryByPeriode(String periode) {
		List<ListeEffectif> liste_effectifs= new ArrayList<ListeEffectif>();
		String[] parts = periode.split("-");
		int i= Integer.parseInt(parts[1]);
		i+=1;
		String ch=String.valueOf(i);
		if(i<10) {ch="0"+ch;}
		String mois1=periode+"-01";
		String mois2=parts[0]+"-"+ch+"-01";
		liste_effectifs = getSessionFactory().getCurrentSession().createQuery("from ListeEffectif where (Date_dentrée >=? AND Date_dentrée<?) AND (Pôle='OLS'))")
				.setParameter(0, mois1).setParameter(1, mois2).list();

	
			return liste_effectifs;
		
	}

	@Override
	public void update(ListeEffectif e) {
		getSessionFactory().getCurrentSession().merge(e);
		
	}

}
