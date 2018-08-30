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
	private String  Pr�nom ;                    
	
	private String  Poste_Administratif  ;      
	private String motif;  
	
	@Column(name = "motif")
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	private String   D�partement    ;            
	private String   Periode;   
	
	
	@Column(name = "Nom")
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	@Column(name = "Pr�nom")
	public String getPr�nom() {
		return Pr�nom;
	}
	public void setPr�nom(String pr�nom) {
		Pr�nom = pr�nom;
	}
	@Column(name = "Poste_Administratif")
	public String getPoste_Administratif() {
		return Poste_Administratif;
	}
	public void setPoste_Administratif(String poste_Administratif) {
		Poste_Administratif = poste_Administratif;
	}
	@Column(name = "D�partement")
	public String getD�partement() {
		return D�partement;
	}
	public void setD�partement(String d�partement) {
		D�partement = d�partement;
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
