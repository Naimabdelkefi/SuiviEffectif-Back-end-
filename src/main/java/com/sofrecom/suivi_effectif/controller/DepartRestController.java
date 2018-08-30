package com.sofrecom.suivi_effectif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.suivi_effectif.Service.DepartService;
import com.sofrecom.suivi_effectif.Service.EntryService;
import com.sofrecom.suivi_effectif.model.Depart;
import com.sofrecom.suivi_effectif.model.Entry;

@RestController
public class DepartRestController {
	@Autowired
	DepartService departService;
	@Autowired
	EntryService entryService;

	@RequestMapping(value = "/Entry", method = RequestMethod.GET)
	@ResponseBody
	public List<Entry> getEntry() {
		return entryService.getAllEntryData();
	}

	@RequestMapping(value = "/Depart", method = RequestMethod.GET)
	@ResponseBody
	public List<Depart> getDepart() {
		return departService.getAllDepartData();
	}

	@RequestMapping(value = "/Depart/{periode}", method = RequestMethod.GET)
	@ResponseBody
	public List<Depart> getDepartByPeriod(@PathVariable String periode) {
		return departService.DepartByPeriode(periode);
	}

}
