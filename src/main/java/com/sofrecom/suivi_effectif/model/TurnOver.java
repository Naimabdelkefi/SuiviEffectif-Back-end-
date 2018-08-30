package com.sofrecom.suivi_effectif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turnover")
public class TurnOver {
	private long ID ;
	private String mois;
	private String année;
	private long depart;
	private long effectif;
	private long mobilité;
	private long Démission;
	private long CongéSansSolde;
	private long TalentSharing;
	private String date;
	private Long entree;
	
	@Column(name = "entree")
	public Long getEntree() {
		return entree;
	}
	public void setEntree(Long entree) {
		this.entree = entree;
	}
	@Column(name = "date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name = "mobilité")
	public long getMobilité() {
		return mobilité;
	}
	public void setMobilité(long mobilité) {
		this.mobilité = mobilité;
	}
	@Column(name = "Démission")
	public long getDémission() {
		return Démission;
	}
	public void setDémission(long démission) {
		Démission = démission;
	}
	@Column(name = "CongéSansSolde")
	public long getCongéSansSolde() {
		return CongéSansSolde;
	}
	public void setCongéSansSolde(long congéSansSolde) {
		CongéSansSolde = congéSansSolde;
	}
	@Column(name = "TalentSharing")
	public long getTalentSharing() {
		return TalentSharing;
	}
	public void setTalentSharing(long talentSharing) {
		TalentSharing = talentSharing;
	}
	@Column(name = "année", nullable = false)
	public String getAnnée() {
		return année;
	}
	public void setAnnée(String année) {
		this.année = année;
	}
	@Column(name = "depart")
	public long getDepart() {
		return depart;
	}
	public void setDepart(long depart) {
		this.depart = depart;
	}
	@Column(name = "effectif")
	public long getEffectif() {
		return effectif;
	}
	public void setEffectif(long effectif) {
		this.effectif = effectif;
	}
	private float valeur;
	private float prevsion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	@Column(name = "mois", nullable = false)
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	@Column(name = "valeur")
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	@Column(name = "prevsion")
	public float getPrevsion() {
		return prevsion;
	}
	public void setPrevsion(float prevsion) {
		this.prevsion = prevsion;
	}
	

}
