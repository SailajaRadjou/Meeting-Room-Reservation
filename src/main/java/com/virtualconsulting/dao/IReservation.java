package com.virtualconsulting.dao;

import java.util.ArrayList;

import com.virtualconsulting.metier.Reservation;

public interface IReservation {

	Reservation save(Reservation reservation);
	Reservation update(Reservation reservation);
	int delete(Reservation reservation);
	
	ArrayList<Reservation> getAll();
	ArrayList<Reservation> getAll(int clientId);
	ArrayList<Reservation> getAll(String salleId);
	
	Reservation search(String nom, String prenom);
	
	Reservation find(int reserveId);
	int countReservation();
	
}
