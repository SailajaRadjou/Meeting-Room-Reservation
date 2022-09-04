package com.virtualconsulting.presentation;

import com.virtualconsulting.dao.ClientDaoImple;
import com.virtualconsulting.dao.UserDaoImple;
import com.virtualconsulting.metier.Client;
import com.virtualconsulting.metier.User;

public class StartMeetingRoom {

	public static void main(String[] args) {
		/*Client cl;
		//Client client = new Client("Alain", "Fradet", "Seasons Corp.", "alain@seasons.fr", "06.54.98.65.78", "Mr", "alain", "alain");
		ClientDaoImple cdi = new ClientDaoImple();
		//cl = cdi.save(client);
		cl = cdi.find(1);
		if (cl != null ) {
			cl.setNom("Fradet");
			cl.setPrenom("Alain");
			cl=cdi.update(cl);
			System.out.println(cl);
		}*/
		User u1;
		User u = new User("Ram", "Vishnu", "ram@ezmeet.com", "ram", "ram", "Mr.", 0);
		UserDaoImple udi = new UserDaoImple();
		u1 = udi.save(u);
		if(u1 != null) {
			System.out.println(u1);
		}
	}

}
