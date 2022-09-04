package com.virtualconsulting.metier;

public class SalleReunion {

	private String salleId;
	private String salleNom;
	private String localisation;
	private int capacite;
	private double tarif;
	
	public SalleReunion() {
		super();
	}

	public SalleReunion(String salleId, String salleNom, String localisation, int capacite, double tarif) {
		super();
		this.salleId = salleId;
		this.salleNom = salleNom;
		this.localisation = localisation;
		this.capacite = capacite;
		this.tarif = tarif;
	}

	public String getSalleId() {
		return salleId;
	}

	public void setSalleId(String salleId) {
		this.salleId = salleId;
	}

	public String getSalleNom() {
		return salleNom;
	}

	public void setSalleNom(String salleNom) {
		this.salleNom = salleNom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	@Override
	public String toString() {
		return "SalleReunion [salleId=" + salleId + ", salleNom=" + salleNom + ", localisation=" + localisation
				+ ", capacite=" + capacite + ", tarif=" + tarif + "]";
	}	
	
}
