package com.virtualconsulting.dao;

import java.util.ArrayList;

import com.virtualconsulting.metier.SalleReunion;



public interface ISalleReunionDao {

	SalleReunion save(SalleReunion sr);
	SalleReunion update(SalleReunion sr);
	int delete(SalleReunion sr);
	
	ArrayList<SalleReunion> getAll();
	
	SalleReunion find(String sid);	
	
	SalleReunion search(String nom);
	
	int countSalle();
	
}
