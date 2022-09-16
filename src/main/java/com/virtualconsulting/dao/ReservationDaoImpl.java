package com.virtualconsulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import com.virtualconsulting.metier.Client;
import com.virtualconsulting.metier.Reservation;
import com.virtualconsulting.metier.SalleReunion;

public class ReservationDaoImpl implements IReservation {

	Client client;
	SalleReunion salle;
	Reservation reservation;
	double montant;
	
	PreparedStatement pStmt;
	Connection conn = SingletonConnection.getConnection();
	
	@Override
	public Reservation save(Reservation reservation) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into reservation (date, heure_debut, heure_fin, motif_reservation, montant, client_id, salle_id) values (?, ?, ?, ?, ?, ?, ?)");
			
		    double calcMontant = calculeMontant(reservation.getHeureDebut(), reservation.getHeureFin(), reservation.getSalle().getTarif());
		    
			pStmt.setDate(1, reservation.getDateReserve());
			pStmt.setTime(2, reservation.getHeureDebut());
			pStmt.setTime(3, reservation.getHeureFin());
			pStmt.setString(4, reservation.getMotif());
			pStmt.setDouble(5, reservation.getMontant());
			pStmt.setInt(6, reservation.getClient().getClientId());
			pStmt.setString(7, reservation.getSalle().getSalleId());
			
			if (calcMontant == reservation.getMontant()) {
				//execute query in the prepared statement
				pStmt.executeUpdate();
				System.out.println("Inserted a new record Successfully....");
				pStmt.close();
				
				// for getting the id of the row last inserted
				pStmt = conn.prepareStatement("select max(reserve_id) as Last_Record from reservation");
				
				//execute the above select query & retrieve the value in the variable rset
				ResultSet rSet = pStmt.executeQuery();
				
				//for setting id & it returns the object of the lastly entered data
				if(rSet.next()) {
					reservation.setReserveId(rSet.getInt("Last_Record"));
					pStmt.close();
					return reservation;
				}			
				
			} else {
				System.out.println("Mishandling Error");
				reservation.setMontant(-1);
				return reservation;
			}		
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Reservation update(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Reservation reservation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Reservation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation search(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(int reserveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countReservation() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double calculeMontant(Time time1, Time time2, double tarif) {
		double montant=0;
		int hour, mins;
		String timeString1 = time1.toString();
		String timeString2 = time2.toString();
		long diffs = Duration.between(LocalTime.parse(timeString1), LocalTime.parse(timeString2)).toMinutes();
			        
		hour = (int) (diffs/60);
		mins = (int) (diffs%60);
		System.out.println(hour+" : "+mins);
			      
		if(mins >= 15)
		   	hour++;	        
			     
		montant = hour*tarif;		        
		
		return montant;
	}
	
}

