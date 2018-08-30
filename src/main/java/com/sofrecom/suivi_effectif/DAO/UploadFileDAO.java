package com.sofrecom.suivi_effectif.DAO;

import java.util.List;

import com.sofrecom.suivi_effectif.model.UploadFile;

public interface UploadFileDAO {
	UploadFile findByFilename(String filename);
	 void save(UploadFile uploadFile);
	 void delete(UploadFile uploadFile);
}
