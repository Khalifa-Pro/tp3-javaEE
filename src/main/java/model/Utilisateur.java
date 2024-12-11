package model;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private String identifiant;
	private String mot_de_passe;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
	
	
	

}
