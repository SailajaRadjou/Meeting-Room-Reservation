package com.virtualconsulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.virtualconsulting.metier.Client;

public class ClientDaoImple implements IClientDao{

	Client client;
	
	Connection conn = SingletonConnection.getConnection();
	
	@Override
	public Client save(Client c) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into client (nom, prenom, nom_entreprise, mail, phone, civilite, nom_identifiant, mot_de_passe) values (?, ?, ?, ?, ?, ?, ?, md5(?))");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setString(1, c.getNom());
			pStmt.setString(2, c.getPrenom());
			pStmt.setString(3, c.getNomEntreprise());
			pStmt.setString(4, c.getMail());
			pStmt.setString(5, c.getPhone());
			pStmt.setString(6, c.getCivilite());
			pStmt.setString(7, c.getUsername());
			pStmt.setString(8, c.getPassword());
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Inserted a new record Successfully....");
			pStmt.close();
			
			// for getting the id of the row last inserted
			pStmt = conn.prepareStatement("select max(client_id) as Last_Record from client");
			
			//execute the above select query & retrieve the value in the variable rset
			ResultSet rSet = pStmt.executeQuery();
			
			//for setting id & it returns the object of the lastly entered data
			if(rSet.next()) {
				c.setClientId(rSet.getInt("Last_Record"));
				pStmt.close();
				return c;
			}			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Client update(Client c) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update client set nom = ?, prenom = ?, nom_entreprise = ?, mail = ?, phone = ?, civilite = ?, nom_identifiant = ?, mot_de_passe = md5(?) where client_id = ? ");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setInt(9, c.getClientId());
			pStmt.setString(1, c.getNom());
			pStmt.setString(2, c.getPrenom());
			pStmt.setString(3, c.getNomEntreprise());
			pStmt.setString(4, c.getMail());
			pStmt.setString(5, c.getPhone());
			pStmt.setString(6, c.getCivilite());
			pStmt.setString(7, c.getUsername());
			pStmt.setString(8, c.getPassword());
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Updated record Successfully....");
			pStmt.close();
			
			//return the updated object
			return this.find(c.getClientId());
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(Client c) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from client where client_id = ?");
			
			pStmt.setInt(1, c.getClientId());
			
			res = pStmt.executeUpdate();
			
			pStmt.close();
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public ArrayList<Client> getAll() {
		
		ArrayList<Client> clients = new ArrayList<Client>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client");
			
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				client = new Client();
				client.setClientId(rSet.getInt("client_id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setNomEntreprise(rSet.getString("nom_entreprise"));
				client.setMail(rSet.getString("mail"));				
				client.setPhone(rSet.getString("phone"));
				client.setCivilite(rSet.getString("civilite"));
				client.setUsername(rSet.getString("nom_identifiant"));
				client.setPassword(rSet.getString("mot_de_passe"));
				
				clients.add(client);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return clients;
	}

	@Override
	public Client find(int id) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where client_id = ?");
			
			pStmt.setInt(1, id);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				client = new Client();
				client.setClientId(rSet.getInt("client_id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setNomEntreprise(rSet.getString("nom_entreprise"));
				client.setMail(rSet.getString("mail"));
				client.setPhone(rSet.getString("phone"));
				client.setCivilite(rSet.getString("civilite"));
				client.setUsername(rSet.getString("nom_identifiant"));
				client.setPassword(rSet.getString("mot_de_passe"));
				pStmt.close();
				return client;
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Client search(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client find(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int find(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countClient() {
		// TODO Auto-generated method stub
		return 0;
	}

}
