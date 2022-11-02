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
	public Client save(Client client) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into client (nom, prenom, nom_entreprise, mail, phone, civilite, nom_identifiant, mot_de_passe) values (?, ?, ?, ?, ?, ?, ?, md5(?))");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setString(1, client.getNom());
			pStmt.setString(2, client.getPrenom());
			pStmt.setString(3, client.getNomEntreprise());
			pStmt.setString(4, client.getMail());
			pStmt.setString(5, client.getPhone());
			pStmt.setString(6, client.getCivilite());
			pStmt.setString(7, client.getUsername());
			pStmt.setString(8, client.getPassword());
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
				client.setClientId(rSet.getInt("Last_Record"));
				pStmt.close();
				return client;
			}			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Client update(Client client) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update client set nom = ?, prenom = ?, nom_entreprise = ?, mail = ?, phone = ?, civilite = ?, nom_identifiant = ?, mot_de_passe = md5(?) where client_id = ? ");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setInt(9, client.getClientId());
			pStmt.setString(1, client.getNom());
			pStmt.setString(2, client.getPrenom());
			pStmt.setString(3, client.getNomEntreprise());
			pStmt.setString(4, client.getMail());
			pStmt.setString(5, client.getPhone());
			pStmt.setString(6, client.getCivilite());
			pStmt.setString(7, client.getUsername());
			pStmt.setString(8, client.getPassword());
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Updated record Successfully....");
			pStmt.close();
			
			//return the updated object
			return this.find(client.getClientId());
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(Client client) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from client where client_id = ?");
			
			pStmt.setInt(1, client.getClientId());
			
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
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where nom = ? and prenom = ?");			
			pStmt.setString(1, nom);
			pStmt.setString(2, prenom);			
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
								
				return client;
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	//For authentification
	@Override
	public Client find(String username, String password) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where nom_identifiant = ? and mot_de_passe = md5(?)");			
			pStmt.setString(1, username);
			pStmt.setString(2, password);			
			ResultSet rSet = pStmt.executeQuery();
			System.out.println("Authentification executed");			
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
				System.out.println("Authentification succeed");
				System.out.println(client.getNom());				
				return client;
			}			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int countClient() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Total_Clients from client");
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt("Total_Clients");
			}
			pStmt.close();
			return count;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}
	
	//to get the status
		@Override
		public int find(String username) {
			int statut;
			try {
				PreparedStatement pStmt = conn.prepareStatement("select statut from client where nom_identifiant = ?");
				
				pStmt.setString(1, username);
				
				
				ResultSet rSet = pStmt.executeQuery();
				System.out.println("executed");
				
				if(rSet.next()) {
					
					statut = rSet.getInt("statut");
					return statut;
				}
				
				pStmt.close();
				
			} catch (Exception e) {
				System.err.println(e);
			}
			
			return 0;
		}
		
		//to get the client details by username
		@Override
		public Client findClient(String username) {
					
		try {
				PreparedStatement pStmt = conn.prepareStatement("select * from client where nom_identifiant = ?");
						
				pStmt.setString(1, username);					
						
				ResultSet rSet = pStmt.executeQuery();
				System.out.println("executed");
						
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
					System.out.println("Authentification succeed");
					System.out.println(client.getNom());				
					return client;
				}
				pStmt.close();
						
			} catch (Exception e) {
				System.err.println(e);
			}
					
			return null;
		}
		//to get the Client Id
		@Override
		public int findClientId(String username) {
			int clientId;
			try {
					PreparedStatement pStmt = conn.prepareStatement("select client_id from client where nom_identifiant = ?");
						
					pStmt.setString(1, username);
						
					ResultSet rSet = pStmt.executeQuery();
					System.out.println("executed");
						
					if(rSet.next()) {
							
						clientId = rSet.getInt("client_id");
						return clientId;
					}
						
					pStmt.close();
						
				} catch (Exception e) {
					System.err.println(e);
				}
					
				return 0;
		}
		@Override
		public ArrayList<Client> getAll(String nom) {
			ArrayList<Client> clients = new ArrayList<Client>();
			
			try {
				PreparedStatement pStmt = conn.prepareStatement("select * from client where nom like ?");
				
				pStmt.setString(1,'%'+nom+'%');				
				
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
				pStmt.close();
				
			} catch (Exception e) {
				System.err.println(e);
			}
			return clients;
		}

}
