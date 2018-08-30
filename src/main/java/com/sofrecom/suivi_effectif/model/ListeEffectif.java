package com.sofrecom.suivi_effectif.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "listeeffectif")
public class ListeEffectif {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	@Column(name = "Pôle", nullable = false)
	public String getPôle() {
		return Pôle;
	}
	public void setPôle(String pôle) {
		Pôle = pôle;
	}
	@Column(name = "Nom", nullable = false)
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	@Column(name = "Prénom", nullable = false)
	public String getPrénom() {
		return Prénom;
	}
	public void setPrénom(String prénom) {
		Prénom = prénom;
	}
	@Column(name = "CUID")
	public String getCUID() {
		return CUID;
	}
	public void setCUID(String cUID) {
		CUID = cUID;
	}
	@Column(name = "Poste_Administratif")
	public String getPoste_Administratif() {
		return Poste_Administratif;
	}
	public void setPoste_Administratif(String poste_Administratif) {
		Poste_Administratif = poste_Administratif;
	}
	@Column(name = "Job_list")
	public String getJob_list() {
		return Job_list;
	}
	public void setJob_list(String job_list) {
		Job_list = job_list;
	}
	
	@Column(name = "Nom_de_responsable_associé", nullable = false)
	public String getNom_de_responsable_associé() {
		return Nom_de_responsable_associé;
	}
	public void setNom_de_responsable_associé(String nom_de_responsable_associé) {
		Nom_de_responsable_associé = nom_de_responsable_associé;
	}
	@Column(name = "Département")
	public String getDépartement() {
		return Département;
	}
	public void setDépartement(String département) {
		Département = département;
	}
	@Column(name = "Projet", nullable = false)
	public String getProjet() {
		return Projet;
	}
	public void setProjet(String projet) {
		Projet = projet;
	}
	@Column(name = "Etat_Recrutement")
	public String getEtat_Recrutement() {
		return Etat_Recrutement;
	}
	public void setEtat_Recrutement(String etat_Recrutement) {
		Etat_Recrutement = etat_Recrutement;
	}

	@Column(name = "Date_dentrée")
	public String getDate_dentrée() {
		return Date_dentrée;
	}
	public void setDate_dentrée(String date_dentrée) {
		Date_dentrée = date_dentrée;
	}
	@Column(name = "Motif_dentrée")
	public String getMotif_dentrée() {
		return Motif_dentrée;
	}
	public void setMotif_dentrée(String motif_dentrée) {
		Motif_dentrée = motif_dentrée;
	}
	
	@Column(name = "Date_de_sortie")
	public String getDate_de_sortie() {
		return Date_de_sortie;
	}
	public void setDate_de_sortie(String date_de_sortie) {
		Date_de_sortie = date_de_sortie;
	}
	@Column(name = "Motif_de_sortie")
	public String getMotif_de_sortie() {
		return Motif_de_sortie;
	}
	public void setMotif_de_sortie(String motif_de_sortie) {
		Motif_de_sortie = motif_de_sortie;
	}

	@Column(name = "Date_dépôt_Démission", nullable = false)
	public String getDate_dépôt_Démission() {
		return Date_dépôt_Démission;
	}
	public void setDate_dépôt_Démission(String date_dépôt_Démission) {
		Date_dépôt_Démission = date_dépôt_Démission;
	}
	@Column(name = "Description")
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Column(name = "HF")
	public String getHF() {
		return HF;
	}
	public void setHF(String hF) {
		HF = hF;
	}
	@Column(name = "commentaires")
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	private long ID ;
	private String Pôle  ;                    
	private String  Nom     ;                   
	private String  Prénom ;                    
	private String  CUID       ;                
	private String  Poste_Administratif  ;      
	private String   Job_list         ;          
	private String   Nom_de_responsable_associé ;
	private String   Département    ;            
	private String   Projet         ;            
	private String   Etat_Recrutement  ;         
	private String   Date_dentrée ;              
	private String   Motif_dentrée;             
	private String   Date_de_sortie;            
	private String   Motif_de_sortie ;           
	private String   Date_dépôt_Démission  ;    
	private String   Description ;             
	private String   HF     ;                 
	private String   commentaires;          
}
