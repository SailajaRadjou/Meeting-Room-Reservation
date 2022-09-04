package com.virtualconsulting.metier;

import java.sql.Date;
import java.sql.Time;

public class Reservation {

	private int reserveId;
	private Date dateReserve;
	private Time heureDebut;
	private Time heureFin;
	private String motif;
	private double montant;
	private Client client;
	private SalleReunion salle;
	
	public Reservation() {
		super();
	}

	public Reservation(Date dateReserve, Time heureDebut, Time heureFin, String motif, double montant, Client client,
			SalleReunion salle) {
		super();
		this.dateReserve = dateReserve;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.motif = motif;
		this.montant = montant;
		this.client = client;
		this.salle = salle;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public Date getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(Date dateReserve) {
		this.dateReserve = dateReserve;
	}

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public SalleReunion getSalle() {
		return salle;
	}

	public void setSalle(SalleReunion salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Reservation [reserveId=" + reserveId + ", dateReserve=" + dateReserve + ", heureDebut=" + heureDebut
				+ ", heureFin=" + heureFin + ", motif=" + motif + ", montant=" + montant + ", client=" + client
				+ ", salle=" + salle + "]";
	}	
	
}
