package com.sofrecom.suivi_effectif.Service.Impl;

import java.util.List;

import com.sofrecom.suivi_effectif.DAO.UploadFileDAO;
import com.sofrecom.suivi_effectif.Service.UploadFileService;
import com.sofrecom.suivi_effectif.model.UploadFile;

public class UploadFileServiceImpl implements UploadFileService {
	private UploadFileDAO uploadFileDAO;
	public UploadFileDAO getUploadFileDAO() {
		return uploadFileDAO;
	}

	public void setUploadFileDAO(UploadFileDAO uploadFileDAO) {
		this.uploadFileDAO = uploadFileDAO;
	}

	@Override
	public void saveFile(UploadFile u) {
		getUploadFileDAO().save(u);
	}

	@Override
	public UploadFile getFileByName(String name) {
	return getUploadFileDAO().findByFilename(name);
	}

	@Override
	public void deleteFile(UploadFile u) {
		getUploadFileDAO().delete(u);	
	}

}
