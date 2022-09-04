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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User search(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int find(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countUser() {
		// TODO Auto-generated method stub
		return 0;
	}

}
