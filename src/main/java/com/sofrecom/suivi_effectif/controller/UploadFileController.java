package com.sofrecom.suivi_effectif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sofrecom.suivi_effectif.Service.UploadFileService;
import com.sofrecom.suivi_effectif.model.UploadFile;

@Controller
public class UploadFileController {
	@Autowired
	private UploadFileService uploadFileService;

	@RequestMapping(value = "/UploadFile", method = RequestMethod.GET)
	public String showUploadForm(HttpServletRequest request) {
		return "Upload";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request,
			@RequestParam(value = "fileupload") CommonsMultipartFile[] fileUpload) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				UploadFile uploadFile = new UploadFile();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setData(aFile.getBytes());
				uploadFileService.saveFile(uploadFile);
			}
		}

		return "index2";
	}

}
