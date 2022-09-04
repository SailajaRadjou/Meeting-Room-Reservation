package com.virtualconsulting.metier;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String username;
	private String password;
	private String civilite;
	private int statut;
	
	public User() {
		super();
	}

	public User(String nom, String prenom, String mail, String username, String password, String civilite,
			int statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.civilite = civilite;
		this.statut = statut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", username=" + username
				+ ", password=" + password + ", civilite=" + civilite + ", statut=" + statut + "]";
	}	
	
}
