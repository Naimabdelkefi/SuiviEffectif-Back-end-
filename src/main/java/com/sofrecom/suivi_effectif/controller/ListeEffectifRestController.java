package com.sofrecom.suivi_effectif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.suivi_effectif.Service.ListeEffectifService;
import com.sofrecom.suivi_effectif.Service.Impl.ListeEffectifServiceImpl.Departement;
import com.sofrecom.suivi_effectif.Service.Impl.ListeEffectifServiceImpl.Pourcetage;
import com.sofrecom.suivi_effectif.model.ListeEffectif;

@RestController
public class ListeEffectifRestController {

	@Autowired
	ListeEffectifService listeEffectifService;

	@RequestMapping(value = "/Effectif", method = RequestMethod.GET)
	@ResponseBody
	public List<ListeEffectif> getEffectif() {
		return listeEffectifService.getAllData();
	}

	@RequestMapping(value = "/Effectif/Pourcentage", method = RequestMethod.GET)
	@ResponseBody
	public List<Pourcetage> getEffectifPourcetnage(@RequestParam("pole") String pole) {
		return listeEffectifService.PourcentageSexe(pole);
	}

	@RequestMapping(value = "/Effectif/Depratement", method = RequestMethod.GET)
	@ResponseBody
	public List<Departement> getEffectifDepratemnt(@RequestParam("pole") String Pole) {
		return listeEffectifService.NbreDepratemnt(Pole);
	}

	@RequestMapping(value = "/Effectif/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ListeEffectif getEffectifById(@PathVariable long id) {
		return listeEffectifService.getDataById(id);
	}

	@RequestMapping(value = "/Effectif", method = RequestMethod.POST)
	@ResponseBody
	public void saveEffecitf(@RequestBody ListeEffectif e) {
		listeEffectifService.saveData(e);

	}

	@RequestMapping(value = "/Effectif/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Boolean DeleteEffectifById(@PathVariable long id) {
		ListeEffectif e = listeEffectifService.getDataById(id);
		listeEffectifService.deleteDataRaw(e);
		return true;
	}

	@RequestMapping(value = "/Effectif/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Boolean UpdateEffectifById(@PathVariable long id, @RequestBody ListeEffectif a) {
		ListeEffectif e = listeEffectifService.getDataById(id);
		e.setCommentaires(a.getCommentaires());
		e.setCUID(a.getCUID());
		e.setDate_de_sortie(a.getDate_de_sortie());
		e.setDate_dentr�e(a.getDate_dentr�e());
		e.setDate_d�p�t_D�mission(a.getDate_d�p�t_D�mission());
		e.setDescription(a.getDescription());
		e.setP�le(a.getP�le());
		e.setPr�nom(a.getPr�nom());
		e.setD�partement(a.getD�partement());
		e.setEtat_Recrutement(a.getEtat_Recrutement());
		e.setProjet(a.getProjet());
		e.setHF(a.getHF());
		e.setPoste_Administratif(a.getPoste_Administratif());
		e.setNom_de_responsable_associ�(a.getNom_de_responsable_associ�());
		e.setJob_list(a.getJob_list());
		e.setNom(a.getNom());
		e.setMotif_dentr�e(a.getMotif_dentr�e());
		e.setMotif_de_sortie(a.getMotif_de_sortie());
		listeEffectifService.update(e);
		return true;
	}
}
