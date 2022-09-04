package com.virtualconsulting.dao;

import java.util.ArrayList;

import com.virtualconsulting.metier.Client;

public interface IClientDao {

	Client save(Client c);
	Client update(Client c);
	int delete(Client c);
	
	ArrayList<Client> getAll();
	
	Client find(int id);	
	Client search(String nom, String prenom);
	
	Client find(String username, String password);
	int find(String username);
	int countClient();
}
