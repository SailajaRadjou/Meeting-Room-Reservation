package com.virtualconsulting.metier;

public class Client {

	private int clientId;
	private String nom;
	private String prenom;
	private String nomEntreprise;
	private String mail;
	private String phone;
	private String civilite;
	private String username;
	private String password;
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String nomEntreprise, String mail, String phone, String civilite,
			String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomEntreprise = nomEntreprise;
		this.mail = mail;
		this.phone = phone;
		this.civilite = civilite;
		this.username = username;
		this.password = password;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
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

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", nom=" + nom + ", prenom=" + prenom + ", nomEntreprise="
				+ nomEntreprise + ", mail=" + mail + ", phone=" + phone + ", civilite=" + civilite + ", username="
				+ username + ", password=" + password + "]";
	}	
	
	
}
