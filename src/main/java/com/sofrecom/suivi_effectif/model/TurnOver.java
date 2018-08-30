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
	private String ann�e;
	private long depart;
	private long effectif;
	private long mobilit�;
	private long D�mission;
	private long Cong�SansSolde;
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
	@Column(name = "mobilit�")
	public long getMobilit�() {
		return mobilit�;
	}
	public void setMobilit�(long mobilit�) {
		this.mobilit� = mobilit�;
	}
	@Column(name = "D�mission")
	public long getD�mission() {
		return D�mission;
	}
	public void setD�mission(long d�mission) {
		D�mission = d�mission;
	}
	@Column(name = "Cong�SansSolde")
	public long getCong�SansSolde() {
		return Cong�SansSolde;
	}
	public void setCong�SansSolde(long cong�SansSolde) {
		Cong�SansSolde = cong�SansSolde;
	}
	@Column(name = "TalentSharing")
	public long getTalentSharing() {
		return TalentSharing;
	}
	public void setTalentSharing(long talentSharing) {
		TalentSharing = talentSharing;
	}
	@Column(name = "ann�e", nullable = false)
	public String getAnn�e() {
		return ann�e;
	}
	public void setAnn�e(String ann�e) {
		this.ann�e = ann�e;
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
