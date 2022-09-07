package com.virtualconsulting.dao;

import java.util.ArrayList;

import com.virtualconsulting.metier.SalleReunion;



public interface ISalleReunionDao {

	SalleReunion save(SalleReunion salleReunion);
	SalleReunion update(SalleReunion salleReunion);
	int delete(SalleReunion salleReunion);
	
	ArrayList<SalleReunion> getAll();
	
	SalleReunion find(String salleId);	
	
	SalleReunion search(String nom);
	
	int countSalle();
	
}
