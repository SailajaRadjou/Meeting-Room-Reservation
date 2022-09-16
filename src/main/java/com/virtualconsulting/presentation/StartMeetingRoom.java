package com.virtualconsulting.presentation;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

import com.virtualconsulting.dao.ClientDaoImple;
import com.virtualconsulting.dao.ReservationDaoImpl;
import com.virtualconsulting.dao.SalleReunionDaoImple;
import com.virtualconsulting.dao.UserDaoImple;
import com.virtualconsulting.metier.Client;
import com.virtualconsulting.metier.Reservation;
import com.virtualconsulting.metier.SalleReunion;
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
		/*User u1;
		User u = new User("Ram", "Vishnu", "ram@ezmeet.com", "ram", "ram", "Mr.", 0);
		UserDaoImple udi = new UserDaoImple();
		u1 = udi.save(u);
		if(u1 != null) {
			System.out.println(u1);
		}*/
		
		Client cl;
		ClientDaoImple cdi = new ClientDaoImple();
		
		SalleReunion sr;
		SalleReunionDaoImple salleDao = new SalleReunionDaoImple();
		
		Reservation reservation;
		ReservationDaoImpl reservationDaoImpl = new ReservationDaoImpl();
		
		cl = cdi.find(1);
		sr = salleDao.find("SR102");
		
		int hour, mins;

		double montant;
		String time1 = "12:30:00";
		String time2 = "16:30:00";
		
        long diffs = Duration.between(LocalTime.parse(time1), LocalTime.parse(time2)).toMinutes();
        
        hour = (int) (diffs/60);
        mins = (int) (diffs%60);
        System.out.println(hour+" : "+mins);
      
        if(mins >= 15)
        	hour++;	        
     
        montant = hour*sr.getTarif();
        System.out.println("calculating...");
        System.out.println(hour);
        
        		
		reservation = new Reservation(Date.valueOf("2022-10-20"), Time.valueOf(time1), Time.valueOf(time2), "Buisness Meeting", montant, cl, sr);
		reservation = reservationDaoImpl.save(reservation);
		
		if (reservation != null) {
			System.out.println(reservation);
		} else {
			System.out.println("failed");
		}
		
		/*String time1 = "09:30:00";
        String time2 = "10:45:00";
        
        int hour, mins;

        long diffs = Duration.between(LocalTime.parse(time1), LocalTime.parse(time2)).toMinutes();
        
        hour = (int) (diffs/60);
        mins = (int) (diffs%60);
        System.out.println(hour+" : "+mins);
      
        if(mins >= 15)
        	hour++;
        System.out.println("calculating...");
        System.out.println(hour);*/
	}

}
