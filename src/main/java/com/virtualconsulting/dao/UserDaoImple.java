package com.virtualconsulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.virtualconsulting.metier.User;

public class UserDaoImple implements IUserDao {

	User user;
	Connection conn = SingletonConnection.getConnection();
	
	@Override
	public User save(User user) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into user (nom, prenom, mail, nom_identifiant, mot_de_passe, civilite, statut) values (?, ?, ?, ?, md5(?), ?, ?)");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setString(1, user.getNom());
			pStmt.setString(2, user.getPrenom());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getUsername());
			pStmt.setString(5, user.getPassword());
			pStmt.setString(6, user.getCivilite());
			pStmt.setInt(7, user.getStatut());
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Inserted a new record Successfully....");
			pStmt.close();
			
			// for getting the id of the row last inserted
			pStmt = conn.prepareStatement("select max(user_id) as Last_Record from user");
			
			//execute the above select query & retrieve the value in the variable rset
			ResultSet rSet = pStmt.executeQuery();
			
			//for setting id & it returns the object of the lastly entered data
			if(rSet.next()) {
				user.setId(rSet.getInt("Last_Record"));
				pStmt.close();
				return user;
			}			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public User update(User user) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update user set nom = ?, prenom = ?, mail = ?, nom_identifiant = ?, mot_de_passe = md5(?), civilite = ?, statut = ? where user_id = ?");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setInt(8, user.getId());
			pStmt.setString(1, user.getNom());
			pStmt.setString(2, user.getPrenom());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getUsername());
			pStmt.setString(5, user.getPassword());
			pStmt.setString(6, user.getCivilite());
			pStmt.setInt(7, user.getStatut());
			
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Updated Successfully....");
			pStmt.close();
			
			//return the updated object
			return this.find(user.getId());
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(User user) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from user where user_id = ?");
			
			pStmt.setInt(1, user.getId());
			
			res = pStmt.executeUpdate();
			
			pStmt.close();
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
		
	}

	@Override
	public ArrayList<User> getAll() {
		
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from user");
			
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				
				user = new User(); 
				user.setId(rSet.getInt("user_id"));
				user.setNom(rSet.getString("nom"));
				user.setPrenom(rSet.getString("prenom"));
				user.setMail(rSet.getString("mail"));
				user.setUsername(rSet.getString("nom_identifiant"));
				user.setPassword(rSet.getString("mot_de_passe"));
				user.setCivilite(rSet.getString("civilite"));
				user.setStatut(rSet.getInt("statut"));
				users.add(user);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return users;
	}

	@Override
	public User search(String nom, String prenom) {
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from user where nom = ? and prenom = ?");
			
			pStmt.setString(1, nom);
			pStmt.setString(2, prenom);
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				user = new User(); 
				user.setId(rSet.getInt("user_id"));
				user.setNom(rSet.getString("nom"));
				user.setPrenom(rSet.getString("prenom"));
				user.setMail(rSet.getString("mail"));
				user.setUsername(rSet.getString("nom_identifiant"));
				user.setPassword(rSet.getString("mot_de_passe"));
				user.setCivilite(rSet.getString("civilite"));
				user.setStatut(rSet.getInt("statut"));			
				
				System.out.println(user);
				return user;
			}
			pStmt.close();
		} catch (Exception e) {
			System.err.println(e);
		}	
		return null;
	}

	//For authentification
	@Override
	public User find(String username, String password) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from user where nom_identifiant = ? and mot_de_passe = md5(?)");
			
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				user = new User(); 
				user.setId(rSet.getInt("user_id"));
				user.setNom(rSet.getString("nom"));
				user.setPrenom(rSet.getString("prenom"));
				user.setMail(rSet.getString("mail"));
				user.setUsername(rSet.getString("nom_identifiant"));
				user.setPassword(rSet.getString("mot_de_passe"));
				user.setCivilite(rSet.getString("civilite"));
				user.setStatut(rSet.getInt("statut"));			
				
				System.out.println(user);
				return user;
			}
			pStmt.close();
		} catch (Exception e) {
			System.err.println(e);
		}	
		return null;
	}
//to get the statut of the user
	@Override
	public int find(String username) {
		int statut;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select statut from user where nom_identifiant = ?");
			
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

	@Override
	public User find(int id) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from user where user_id = ?");
			
			pStmt.setInt(1, id);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				user = new User(); 
				user.setId(rSet.getInt("user_id"));
				user.setNom(rSet.getString("nom"));
				user.setPrenom(rSet.getString("prenom"));
				user.setMail(rSet.getString("mail"));
				user.setUsername(rSet.getString("nom_identifiant"));
				user.setPassword(rSet.getString("mot_de_passe"));
				user.setCivilite(rSet.getString("civilite"));
				user.setStatut(rSet.getInt("statut"));			
				
				System.out.println(user);
				pStmt.close();
				return user;
			}	
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}


	@Override
	public int countUser() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Total_Users from user");
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt("Total_Users");
			}
			pStmt.close();
			return count;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	
	}

}
