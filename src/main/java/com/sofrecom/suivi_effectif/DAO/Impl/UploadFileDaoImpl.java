package com.sofrecom.suivi_effectif.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sofrecom.suivi_effectif.DAO.UploadFileDAO;
import com.sofrecom.suivi_effectif.model.UploadFile;

public class UploadFileDaoImpl implements UploadFileDAO {
	 @Autowired
	 private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public void save(UploadFile uploadFile) {
		  sessionFactory.getCurrentSession().save(uploadFile);

	}
	@Override
	public UploadFile findByFilename(String filename) {
		List<UploadFile> files=new ArrayList<UploadFile>();
		files=getSessionFactory().getCurrentSession().createQuery("From UploadFile where fileName=?").setParameter(0,filename).list();
		if (files.size() > 0) {
			return files.get(0);
		} else {
			return null;
		}
	}
	@Override
	public void delete(UploadFile uploadFile) {
		getSessionFactory().getCurrentSession().delete(uploadFile);
		
	}


}
