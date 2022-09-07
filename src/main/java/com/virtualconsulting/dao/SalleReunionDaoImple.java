package com.virtualconsulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.virtualconsulting.metier.SalleReunion;

public class SalleReunionDaoImple implements ISalleReunionDao {

	SalleReunion salle;
	PreparedStatement pStmt;
	Connection conn = SingletonConnection.getConnection();
	
	@Override
	public SalleReunion save(SalleReunion salleReunion) {
		try {
	
			salle = find(salleReunion.getSalleId());
			if (salle == null) {
				
				String sql = "insert into salle_reunion (salle_id, nom_de_salle, localisation, capacite, tarif, image_salle) values (?, ?, ?, ?, ?, ?)";
	
				pStmt = conn.prepareStatement(sql);
	
				pStmt.setString(1, salleReunion.getSalleId());
				pStmt.setString(2, salleReunion.getSalleNom());
				pStmt.setString(3, salleReunion.getLocalisation());
				pStmt.setInt(4, salleReunion.getCapacite());
				pStmt.setDouble(5, salleReunion.getTarif());
				pStmt.setString(6, salleReunion.getSalleImage());
				pStmt.executeUpdate();
				System.out.println("Inserted a new record Successfully....");
				pStmt.close();
				return salleReunion;
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public SalleReunion update(SalleReunion salleReunion) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update salle_reunion set nom_de_salle = ?, localisation = ?, capacite = ?, tarif = ?, image_salle = ? where salle_id = ?");
			
			pStmt.setString(6, salleReunion.getSalleId());
			pStmt.setString(1, salleReunion.getSalleNom());
			pStmt.setString(2, salleReunion.getLocalisation());
			pStmt.setInt(3, salleReunion.getCapacite());
			pStmt.setDouble(4, salleReunion.getTarif());
			pStmt.setString(5, salleReunion.getSalleImage());			
			
			pStmt.executeUpdate();
			System.out.println("Updated Successfully....");
			pStmt.close();
			return this.find(salleReunion.getSalleId());
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(SalleReunion salleReunion) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from salle_reunion where salle_id = ?");
			
			pStmt.setString(1, salleReunion.getSalleId());			
			res = pStmt.executeUpdate();			
			pStmt.close();
			
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public ArrayList<SalleReunion> getAll() {
		ArrayList<SalleReunion> salleReunions = new ArrayList<>();
	
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from salle_reunion");			
			ResultSet rSet = pStmt.executeQuery();
			while (rSet.next()) {
				salle = new SalleReunion();
				salle.setSalleId(rSet.getString("salle_id"));
				salle.setSalleNom(rSet.getString("nom_de_salle"));
				salle.setLocalisation(rSet.getString("localisation"));
				salle.setCapacite(rSet.getInt("capacite"));
				salle.setTarif(rSet.getInt("tarif"));
				salle.setSalleImage(rSet.getString("image_salle"));	
				
				salleReunions.add(salle);				
			}
		}
		
		catch (Exception e) {
			System.err.println(e);
		}
		
		return salleReunions;
	}

	@Override
	public SalleReunion find(String salleId) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from salle_reunion where salle_id = ?");
			
			pStmt.setString(1, salleId);
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				salle = new SalleReunion();
				salle.setSalleId(rSet.getString("salle_id"));
				salle.setSalleNom(rSet.getString("nom_de_salle"));
				salle.setLocalisation(rSet.getString("localisation"));
				salle.setCapacite(rSet.getInt("capacite"));
				salle.setTarif(rSet.getInt("tarif"));
				salle.setSalleImage(rSet.getString("image_salle"));	
				
				pStmt.close();
				return salle;				
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public SalleReunion search(String nom) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from salle_reunion where nom_de_salle = ?");
			
			pStmt.setString(1, nom);
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				salle = new SalleReunion();
				salle.setSalleId(rSet.getString("salle_id"));
				salle.setSalleNom(rSet.getString("nom_de_salle"));
				salle.setLocalisation(rSet.getString("localisation"));
				salle.setCapacite(rSet.getInt("capacite"));
				salle.setTarif(rSet.getInt("tarif"));
				salle.setSalleImage(rSet.getString("image_salle"));	
				
				pStmt.close();
				return salle;				
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int countSalle() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Salle_Total from salle_reunion");
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt("Salle_Total");
			}
			pStmt.close();
			return count;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
		
	}	

}
