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
	@Column(name = "P�le", nullable = false)
	public String getP�le() {
		return P�le;
	}
	public void setP�le(String p�le) {
		P�le = p�le;
	}
	@Column(name = "Nom", nullable = false)
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	@Column(name = "Pr�nom", nullable = false)
	public String getPr�nom() {
		return Pr�nom;
	}
	public void setPr�nom(String pr�nom) {
		Pr�nom = pr�nom;
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
	
	@Column(name = "Nom_de_responsable_associ�", nullable = false)
	public String getNom_de_responsable_associ�() {
		return Nom_de_responsable_associ�;
	}
	public void setNom_de_responsable_associ�(String nom_de_responsable_associ�) {
		Nom_de_responsable_associ� = nom_de_responsable_associ�;
	}
	@Column(name = "D�partement")
	public String getD�partement() {
		return D�partement;
	}
	public void setD�partement(String d�partement) {
		D�partement = d�partement;
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

	@Column(name = "Date_dentr�e")
	public String getDate_dentr�e() {
		return Date_dentr�e;
	}
	public void setDate_dentr�e(String date_dentr�e) {
		Date_dentr�e = date_dentr�e;
	}
	@Column(name = "Motif_dentr�e")
	public String getMotif_dentr�e() {
		return Motif_dentr�e;
	}
	public void setMotif_dentr�e(String motif_dentr�e) {
		Motif_dentr�e = motif_dentr�e;
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

	@Column(name = "Date_d�p�t_D�mission", nullable = false)
	public String getDate_d�p�t_D�mission() {
		return Date_d�p�t_D�mission;
	}
	public void setDate_d�p�t_D�mission(String date_d�p�t_D�mission) {
		Date_d�p�t_D�mission = date_d�p�t_D�mission;
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
	private String P�le  ;                    
	private String  Nom     ;                   
	private String  Pr�nom ;                    
	private String  CUID       ;                
	private String  Poste_Administratif  ;      
	private String   Job_list         ;          
	private String   Nom_de_responsable_associ� ;
	private String   D�partement    ;            
	private String   Projet         ;            
	private String   Etat_Recrutement  ;         
	private String   Date_dentr�e ;              
	private String   Motif_dentr�e;             
	private String   Date_de_sortie;            
	private String   Motif_de_sortie ;           
	private String   Date_d�p�t_D�mission  ;    
	private String   Description ;             
	private String   HF     ;                 
	private String   commentaires;          
}
