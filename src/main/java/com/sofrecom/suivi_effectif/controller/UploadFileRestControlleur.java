package com.sofrecom.suivi_effectif.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sofrecom.suivi_effectif.Service.DepartService;
import com.sofrecom.suivi_effectif.Service.EntryService;
import com.sofrecom.suivi_effectif.Service.ListeEffectifService;
import com.sofrecom.suivi_effectif.Service.TurnOverService;
import com.sofrecom.suivi_effectif.Service.UploadFileService;
import com.sofrecom.suivi_effectif.model.Depart;
import com.sofrecom.suivi_effectif.model.Entry;
import com.sofrecom.suivi_effectif.model.ListeEffectif;
import com.sofrecom.suivi_effectif.model.TurnOver;
import com.sofrecom.suivi_effectif.model.UploadFile;

@RestController
public class UploadFileRestControlleur {
	@Autowired
	ListeEffectifService listeEffectifService;
	@Autowired
	TurnOverService turnOverService;
	@Autowired
	DepartService departService;
	@Autowired
	EntryService entryService;
	@Autowired
	private UploadFileService uploadFileService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Boolean handleFileUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile[] fileupload)
			throws IOException {
		UploadFile f = uploadFileService.getFileByName("effectif.csv");
		uploadFileService.deleteFile(f);
		if (fileupload != null && fileupload.length > 0) {
			for (CommonsMultipartFile aFile : fileupload) {
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				UploadFile uploadFile = new UploadFile();
				System.out.println(aFile.getOriginalFilename());
				uploadFile.setFileName(aFile.getOriginalFilename());
				System.out.println(aFile.getBytes());
				uploadFile.setData(aFile.getBytes());
				uploadFileService.saveFile(uploadFile);
			}
		}
		return true;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public boolean DownloadFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "name") String name) throws IOException {
		System.out.println(name);
		UploadFile f = uploadFileService.getFileByName(name);
		String nameFile = f.getFileName();

		byte[] file = f.getData();

		response.setContentLength(file.length);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + nameFile + "\"");

		FileCopyUtils.copy(file, response.getOutputStream());
		return true;
	}

	@RequestMapping(value = "/misajoureffectif", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ListeEffectif> listeEffectifs = new ArrayList<ListeEffectif>();
		listeEffectifs = listeEffectifService.getAllData();
		for (ListeEffectif listeEffectif : listeEffectifs) {
			listeEffectifService.deleteDataRaw(listeEffectif);
		}
		UploadFile f = uploadFileService.getFileByName("effectif.csv");
		String contextPath = request.getSession().getServletContext().getRealPath(File.separator);
		String dir = contextPath + File.separator + "scripts" + File.separator;
		byte[] file = f.getData();
		ListeEffectif effectif;
		File fi = new File(dir + "new.csv");
		FileUtils.writeByteArrayToFile(fi, file);
		Scanner scanner = new Scanner(new File(dir + "new.csv"));
		scanner.useDelimiter(",");
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		String spliter = ",";
		String line = scanner.nextLine();
		String date1, date2, date3;

		while (scanner.hasNextLine()) {
			effectif = new ListeEffectif();
			line = scanner.nextLine();
			line = line + spliter;
			String[] fields = line.split(spliter);
			for (int i = 0; i < 17; i++) {
				switch (fields[i]) {
				case "":
					fields[i] = null;
				case "-":
					fields[i] = null;
					break;
				}
			}

			try {
				date3 = myFormat.format(fromUser.parse(fields[14]));
			} catch (ParseException | NullPointerException e) {
				date3 = null;
			}
			try {
				date2 = myFormat.format(fromUser.parse(fields[12]));
			} catch (ParseException | NullPointerException e) {
				date2 = null;
			}
			try {
				date1 = myFormat.format(fromUser.parse(fields[10]));
			} catch (ParseException | NullPointerException e) {
				date1 = null;
			}
			effectif.setPôle(fields[0]);
			effectif.setNom(fields[1]);
			effectif.setPrénom(fields[2]);
			effectif.setCUID(fields[3]);
			effectif.setPoste_Administratif(fields[4]);
			effectif.setJob_list(fields[5]);
			effectif.setNom_de_responsable_associé(fields[6]);
			effectif.setDépartement(fields[7]);
			effectif.setProjet(fields[8]);
			effectif.setEtat_Recrutement(fields[9]);
			effectif.setDate_dentrée(date1);
			effectif.setMotif_dentrée(fields[11]);
			effectif.setDate_de_sortie(date2);
			effectif.setMotif_de_sortie(fields[13]);
			effectif.setDate_dépôt_Démission(date3);
			effectif.setDescription(fields[15]);
			effectif.setHF(fields[16]);
			listeEffectifService.saveData(effectif);

		}
		scanner.close();

		/*
		 * try ( Reader reader = Files.newBufferedReader(Paths.get(dir+"new.csv"));
		 * CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT); ) { for
		 * (CSVRecord csvRecord : csvParser) { // Accessing Values by Column Index
		 * String name = csvRecord.get(0); System.out.println("Record No - " +
		 * csvRecord.getRecordNumber()); System.out.println("---------------");
		 * System.out.println("Name : " + name);
		 * System.out.println("---------------\n\n"); } }
		 */
//		 Reader reader = Files.newBufferedReader(new File(dir+"new.csv"));

//		 CSVReader csvReader = new CSVReader(reader);
//		 System.out.println(csvReader.getLinesRead());

//		 String[] nextRecord= csvReader.readNext();

	}

	public boolean ExcuterPython(HttpServletRequest request) throws IOException {
		Runtime r = Runtime.getRuntime();
		String contextPath = request.getSession().getServletContext().getRealPath(File.separator);
		String dir = contextPath + File.separator + "scripts" + File.separator;
		// Process p = r.exec("cmd /c
		// C:\\Users\\m.abdelkefi\\eclipse-workspace\\suivi_effectif\\src\\main\\webapp\\scripts"+
		System.out.println(dir);
		// File.separator +"b.bat");
		System.out.println("cmd /c python " + dir + "sql.py");
		Process p = r.exec("cmd /c python " + dir + "sql.py");

		BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = is.readLine();

		System.out.println(line);

		return false;

	}

	@RequestMapping(value = "/misajourturnover", method = RequestMethod.GET)
	public boolean MAJBD(HttpServletRequest request) {
		List<TurnOver> turnOvers = new ArrayList<TurnOver>();
		turnOvers = turnOverService.getAllTurnData();
		for (TurnOver turnOver : turnOvers) {
			turnOverService.deleteDataRaw(turnOver);
		}
		turnOverService.SaveDonnee("OLS");
		turnOverService.saveTurnDate("OLS");
		turnOverService.saveTurnEntree("OLS");
		turnOverService.SaveTurnOver("OLS");
		List<Depart> departs = new ArrayList<Depart>();
		departs = departService.getAllDepartData();
		for (Depart depart : departs) {
			departService.deleteDataRaw(depart);
		}
		departService.EnregisterLesDepart("OLS");
		List<Entry> entrys = new ArrayList<Entry>();
		entrys = entryService.getAllEntryData();
		for (Entry entry : entrys) {
			entryService.deleteDataRaw(entry);
		}
		entryService.EnregisterLesEntry("OLS");

		return true;
	}
}
