package com.virtualconsulting.presentation;

import com.virtualconsulting.dao.ClientDaoImple;
import com.virtualconsulting.metier.Client;

public class StartMeetingRoom {

	public static void main(String[] args) {
		Client cl;
		//Client client = new Client("Alain", "Fradet", "Seasons Corp.", "alain@seasons.fr", "06.54.98.65.78", "Mr", "alain", "alain");
		ClientDaoImple cdi = new ClientDaoImple();
		//cl = cdi.save(client);
		cl = cdi.find(1);
		if (cl != null ) {
			cl.setNom("Fradet");
			cl.setPrenom("Alain");
			cl=cdi.update(cl);
			System.out.println(cl);
		}
	}

}
