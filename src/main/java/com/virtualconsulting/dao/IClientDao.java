package com.virtualconsulting.dao;

import java.util.ArrayList;

import com.virtualconsulting.metier.Client;

public interface IClientDao {

	Client save(Client client);
	Client update(Client client);
	int delete(Client client);
	
	ArrayList<Client> getAll();
	
	Client find(int id);	
	Client search(String nom, String prenom);
	
	Client find(String username, String password);
	
	int countClient();
	int find(String username);
}
