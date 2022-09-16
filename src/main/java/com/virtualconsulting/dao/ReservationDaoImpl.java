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
	
	ClientDaoImple clientDaoImple = new ClientDaoImple();
	SalleReunionDaoImple salleDaoImple = new SalleReunionDaoImple();
	
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
		try {
			
			PreparedStatement pStmt = conn.prepareStatement("update reservation set date = ?, heure_debut = ?, heure_fin = ?, motif_reservation = ?, montant = ?, salle_id = ? where reserve_id = ? and client_id = ?");
			
			double calcMontant = calculeMontant(reservation.getHeureDebut(), reservation.getHeureFin(), reservation.getSalle().getTarif());
		    
			pStmt.setDate(1, reservation.getDateReserve());
			pStmt.setTime(2, reservation.getHeureDebut());
			pStmt.setTime(3, reservation.getHeureFin());
			pStmt.setString(4, reservation.getMotif());
			pStmt.setDouble(5, reservation.getMontant());			
			pStmt.setString(6, reservation.getSalle().getSalleId());
			pStmt.setInt(7, reservation.getReserveId());
			pStmt.setInt(8, reservation.getClient().getClientId());
			if (calcMontant == reservation.getMontant()) {
				//execute query in the prepared statement
				pStmt.executeUpdate();
				System.out.println("Updated record Successfully....");
				pStmt.close();
				return this.find(reservation.getReserveId());
				
			}	
			else {
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
	public int delete(Reservation reservation) {
		int result;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from reservation where reserve_id = ?");
			
			pStmt.setInt(1, reservation.getReserveId());
			
			result = pStmt.executeUpdate();
			System.out.println("Deleted Successfully....");
			
			pStmt.close();
			return result;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public ArrayList<Reservation> getAll() {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			
			PreparedStatement pStmt = conn.prepareStatement("select * from reservation");
			
			ResultSet rSet = pStmt.executeQuery(); 
			
			while (rSet.next()) {
				client = clientDaoImple.find(rSet.getInt("client_id"));
				salle = salleDaoImple.find(rSet.getString("salle_id"));
				reservation.setReserveId(rSet.getInt("reserve_id"));
				reservation.setDateReserve(rSet.getDate("date"));
				reservation.setHeureDebut(rSet.getTime("heure_debut"));
				reservation.setHeureFin(rSet.getTime("heure_fin"));
				reservation.setMotif(rSet.getString("motif_reservation"));
				reservation.setMontant(rSet.getDouble("montant"));
				reservation.setClient(client);
				reservation.setSalle(salle);
				
				reservations.add(reservation);				
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return reservations;
	}

	@Override
	public Reservation search(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Reservation> getAll(int clientId) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			
			PreparedStatement pStmt = conn.prepareStatement("select * from reservation where client_id = ?");
			pStmt.setInt(1, clientId);
			
			ResultSet rSet = pStmt.executeQuery(); 
			
			while (rSet.next()) {
				client = clientDaoImple.find(rSet.getInt("client_id"));
				salle = salleDaoImple.find(rSet.getString("salle_id"));
				reservation.setReserveId(rSet.getInt("reserve_id"));
				reservation.setDateReserve(rSet.getDate("date"));
				reservation.setHeureDebut(rSet.getTime("heure_debut"));
				reservation.setHeureFin(rSet.getTime("heure_fin"));
				reservation.setMotif(rSet.getString("motif_reservation"));
				reservation.setMontant(rSet.getDouble("montant"));
				reservation.setClient(client);
				reservation.setSalle(salle);
				
				reservations.add(reservation);				
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return reservations;
	}

	@Override
	public ArrayList<Reservation> getAll(String salleId) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			
			PreparedStatement pStmt = conn.prepareStatement("select * from reservation where salle_id = ?");
			pStmt.setString(1, salleId);
			
			ResultSet rSet = pStmt.executeQuery(); 
			
			while (rSet.next()) {
				client = clientDaoImple.find(rSet.getInt("client_id"));
				salle = salleDaoImple.find(rSet.getString("salle_id"));
				reservation.setReserveId(rSet.getInt("reserve_id"));
				reservation.setDateReserve(rSet.getDate("date"));
				reservation.setHeureDebut(rSet.getTime("heure_debut"));
				reservation.setHeureFin(rSet.getTime("heure_fin"));
				reservation.setMotif(rSet.getString("motif_reservation"));
				reservation.setMontant(rSet.getDouble("montant"));
				reservation.setClient(client);
				reservation.setSalle(salle);
				
				reservations.add(reservation);				
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return reservations;
	}

	@Override
	public Reservation find(int reserveId) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from reservation where reserve_id = ?");
			
			pStmt.setInt(1, reserveId);
			
			ResultSet rSet = pStmt.executeQuery();  
			
			if(rSet.next()) {
				client = clientDaoImple.find(rSet.getInt("client_id"));
				salle = salleDaoImple.find(rSet.getString("salle_id"));
				reservation = new Reservation();
				reservation.setReserveId(rSet.getInt("reserve_id"));
				reservation.setDateReserve(rSet.getDate("date"));
				reservation.setHeureDebut(rSet.getTime("heure_debut"));
				reservation.setHeureFin(rSet.getTime("heure_fin"));
				reservation.setMotif(rSet.getString("motif_reservation"));
				reservation.setMontant(rSet.getDouble("montant"));
				reservation.setClient(client);
				reservation.setSalle(salle);
				
				pStmt.close();
				return reservation;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int countReservation() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Total_Reservations from reservation");
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt("Total_Reservations");
			}
			pStmt.close();
			return count;
			
		} catch (Exception e) {
			System.err.println(e);
		}
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

