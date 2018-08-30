package com.sofrecom.suivi_effectif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "depart")
public class Depart {
	
	private long ID ;
	                   
	private String  Nom     ;                   
	private String  Prénom ;                    
	
	private String  Poste_Administratif  ;      
	private String motif;  
	
	@Column(name = "motif")
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	private String   Département    ;            
	private String   Periode;   
	
	
	@Column(name = "Nom")
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	@Column(name = "Prénom")
	public String getPrénom() {
		return Prénom;
	}
	public void setPrénom(String prénom) {
		Prénom = prénom;
	}
	@Column(name = "Poste_Administratif")
	public String getPoste_Administratif() {
		return Poste_Administratif;
	}
	public void setPoste_Administratif(String poste_Administratif) {
		Poste_Administratif = poste_Administratif;
	}
	@Column(name = "Département")
	public String getDépartement() {
		return Département;
	}
	public void setDépartement(String département) {
		Département = département;
	}
	@Column(name = "Periode")
	public String getPeriode() {
		return Periode;
	}
	public void setPeriode(String periode) {
		Periode = periode;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
}
