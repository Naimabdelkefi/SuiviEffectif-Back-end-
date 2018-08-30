package com.sofrecom.suivi_effectif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.suivi_effectif.Service.TurnOverService;
import com.sofrecom.suivi_effectif.model.TurnOver;

@RestController
public class TurnOverRestController {
	@Autowired
	TurnOverService turnOverService;

	@RequestMapping(value = "/Turnover", method = RequestMethod.GET)
	@ResponseBody
	public List<TurnOver> getTurnover() {
		return turnOverService.getAllTurnData();
	}

	@RequestMapping(value = "/Turnover/{id}", method = RequestMethod.GET)
	@ResponseBody
	public TurnOver getTurnoverById(@PathVariable long id) {
		return turnOverService.getTurnById(id);
	}

	@RequestMapping(value = "/Turnover", method = RequestMethod.POST)
	@ResponseBody
	public void SaveTurnover(@RequestBody TurnOver t) {
		turnOverService.saveTurn(t);
	}

	@RequestMapping(value = "/Turnover/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Boolean DeleteTurnoverById(@PathVariable long id) {
		TurnOver e = turnOverService.getTurnById(id);
		turnOverService.deleteDataRaw(e);
		return true;
	}

	@RequestMapping(value = "/Turnovers/{année}", method = RequestMethod.GET)

	public List<TurnOver> getTurnoverByAnnée(@PathVariable String année) {
		return turnOverService.getTurnByYear(année);
	}

	@RequestMapping(value = "/Turnover/{année}/{mois}", method = RequestMethod.GET)
	@ResponseBody
	public TurnOver getTurnoverByMois(@PathVariable String année, @PathVariable String mois) {
		return turnOverService.getTurnByMonthAndYear(mois, année);
	}
}
