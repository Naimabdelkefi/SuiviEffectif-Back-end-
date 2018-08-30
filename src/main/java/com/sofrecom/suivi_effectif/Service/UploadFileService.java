package com.sofrecom.suivi_effectif.Service;

import java.util.List;

import com.sofrecom.suivi_effectif.model.UploadFile;

public interface UploadFileService {
	void saveFile(UploadFile u);
	public UploadFile getFileByName(String name);
	void deleteFile(UploadFile u);
}
