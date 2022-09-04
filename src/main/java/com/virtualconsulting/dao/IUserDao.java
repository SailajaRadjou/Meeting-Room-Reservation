package com.virtualconsulting.dao;

import java.util.ArrayList;

import com.virtualconsulting.metier.User;

public interface IUserDao {

	User save(User user);
	User update(User user);
	int delete(User user);
	
	ArrayList<User> getAll();
	
	User search(String nom, String prenom);
	
	User find(String username, String password);
	int find(String username);
	
	User find(int id);
	int countUser();
}
