package com.sofrecom.suivi_effectif.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofrecom.suivi_effectif.Service.DepartService;
import com.sofrecom.suivi_effectif.Service.EntryService;
import com.sofrecom.suivi_effectif.Service.ListeEffectifService;
import com.sofrecom.suivi_effectif.Service.TurnOverService;

@Controller
public class ListeEffectifController {
	@Autowired
	ListeEffectifService listeEffectifService;
	@Autowired
	TurnOverService turnOverService;
	@Autowired
	DepartService departService;
	@Autowired
	EntryService entryService;
	
	@RequestMapping(value= { "/", "/home" }, method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
//		long aa=turnOverService.NbreDepartParMois("OLS", "Avril", "2018");
		//long a=turnOverService.NbreMobilitéParMois("OLS", "Février", "2018");
		//long b=turnOverService.NbreDémissionParMois("OLS", "Février", "2018");
		//long c=turnOverService.NbreCongéSansSoldeParMois("OLS", "Février", "2018");
		//long d=turnOverService.NbreTalentSharingParMois("OLS", "Février", "2018");
		//System.out.println(a);
		//System.out.println(b);System.out.println(c);System.out.println(d);
		//List<ListeEffectif> liste= listeEffectifService.getAllData();
		//turnOverService.SaveDonnee("OLS");
		//System.out.println(turnOverService.CalculTurnOverParMois("OLS", "Février", "2018"));
		//turnOverService.saveTurnEntree("OLS", "2018");
		//System.out.println(turnOverService.NbreEntreeParMois("OLS", "Mars", "2017"));
		//System.out.println(listeEffectifService.getDataDepartByPeriode("2018-02").toString());
		//departService.EnregisterLesDepart("OLS");
		//entryService.EnregisterLesEntry("OLS");
		//listeEffectifService.getDataDepartByPeriode("2017-02");
		  
		return "index2";

	}

}
