package com.virtualconsulting.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.virtualconsulting.dao.ClientDaoImple;
import com.virtualconsulting.dao.ReservationDaoImpl;
import com.virtualconsulting.dao.SalleReunionDaoImple;
import com.virtualconsulting.dao.UserDaoImple;
import com.virtualconsulting.metier.Client;
import com.virtualconsulting.metier.Reservation;
import com.virtualconsulting.metier.SalleReunion;
import com.virtualconsulting.metier.User;

@MultipartConfig
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Cookie cookie;
	String username;
	int statut;
	
    Client client;
    ClientDaoImple clientDaoImple = new ClientDaoImple();
    ArrayList<Client> clients;
    
    User user;
    UserDaoImple userDaoImple = new UserDaoImple();
    ArrayList<User> users;
    
    SalleReunion salleReunion;
    SalleReunionDaoImple salleReunionDaoImple = new SalleReunionDaoImple();
    ArrayList<SalleReunion> salleReunions;  
    
    Reservation reservation;
    ReservationDaoImpl reservationDaoImpl = new ReservationDaoImpl();
    ArrayList<Reservation> reservations;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookies[] = request.getCookies();
		
		String path = request.getServletPath();
		//System.out.println(path);
		
		switch (path) {
		case "/dashboard": 
			dashboard(request, response);
			break;
			
		case "/affiche-profile":
			afficheProfile(request, response);
			break;
			
		case "/contact":
			contact(request, response);
			break;
			
		case "/search":
			findClient(request, response);
		break;
		
		case "/searchEmployee":
			findEmployee(request, response);
		break;
		
		case "/agenda-reservation":
			listReservation(request, response);			
			break;
			
		case "/employee-list":
			listEmployee(request, response);
			break;
			
		case "/add-employee":
			getCookie(cookies);
			request.setAttribute("username", username);				
			request.getRequestDispatcher("add-employee.jsp").forward(request, response);
			break;
		
		case "/save-employee":
			saveEmployee(request, response);
			break;
			
		case "/modify-employee":
			modifyEmployee(request, response);
			break;
			
		case "/update-employee":
			updateEmployee(request, response);
			break;
		
		case "/delete-employee":
			deleteEmployee(request, response);
			request.getRequestDispatcher("employee-list").forward(request, response);			
			break;
			
		case "/loginClient":
			request.getRequestDispatcher("login-client.jsp").forward(request, response);
			break;
			
		case "/loginValid":
			loginClient(request, response);
			break;
			
		case "/loginUser":
			request.getRequestDispatcher("login-employee.jsp").forward(request, response);
			break;
		
		case "/loginValidEmployee":
			loginEmployee(request, response);
			break;
			
		case "/add-client":
			getCookie(cookies);
			request.setAttribute("username", username);			
			request.getRequestDispatcher("add-client.jsp").forward(request, response);
			break;
			
		case "/save-client":
			saveClient(request, response);
			break;
			
		case "/modify-client":
			modifyClient(request, response);
			break;
			
		case "/update-client":
			updateClient(request, response);
			break;
		
		case "/client-list":
			clientList(request, response);
			break;
		
		case "/delete-client":
			deleteClient(request, response);
			request.getRequestDispatcher("client-list").forward(request, response);			
			break;
			
		case "/client-detail":
			clientDetail(request, response);						
			break;
			
		case "/add-salle":
			getCookie(cookies);
			request.setAttribute("username", username);				
			request.getRequestDispatcher("add-salle.jsp").forward(request, response);
			break;
			
		case "/save-salle":
			saveSalle(request, response);
			break;
		
		case "/salle-list":
			listSalle(request, response);
			break;
			
		case "/modify-salle":
			modifySalle(request, response);
			break;
			
		case "/update-salle":
			updateSalle(request, response);
			break;
		
		case "/delete-salle":
			deleteSalle(request, response);
			request.getRequestDispatcher("salle-list").forward(request, response);	
			break;
		
		case "/salle-reservation":
			salleReservation(request, response);
			break;
		
		case "/save-reservation":
			saveReservation(request, response);
			break;
			
		case "/modify-reservation":
			modifyReservation(request, response);
			break;
			
		case "/update-reservation":
			updateReservation(request, response);
			break;
		
		case "/delete-reservation":
			deleteReservation(request, response);
			request.getRequestDispatcher("dashboard").forward(request, response);	
			break;
			
		case "/home-page":
			//for removing old cookies
			cookie = new Cookie("username", "");
	        cookie.setMaxAge(0);
	        response.addCookie(cookie);
			request.getRequestDispatcher("home-page.jsp").forward(request, response);
			break;	
			
		default:
			request.getRequestDispatcher("home-page.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	//method for getting particular value in the cookie
	private String getCookie(Cookie[] cookies) {
		for (Cookie c : cookies) {
			if(c.getName().equals("username"))
				username = c.getValue();
				
		}
		return username;
			
	}
	private int getStatut(String username) {
		int status;
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			//to get status of the particular user who logged in		
			status = clientDaoImple.find(username);	
		} else {
			status = userDaoImple.find(username);
		}
		return status;
	}
	/********************** CLIENT **************************************************************/
	private void clientList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clients = clientDaoImple.getAll();
		if (clients != null) {
			for (Client client : clients) {
				System.out.println(client);
			}
		} else {
			System.out.println("cannot recupere");
		}		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);	
		
		//to get status of the particular user who logged in		
		statut = getStatut(username);						
		request.setAttribute("statut", statut);
		//setting username received from getCookie()
		request.setAttribute("username", username);
		
		System.out.println("username : "+username);
		request.setAttribute("clients", clients);
		request.getRequestDispatcher("list-client.jsp").forward(request, response);
	}
	
	private void loginClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		client = clientDaoImple.find(username, password);		
		//creating cookie object
		cookie = new Cookie("username", username);
		//adding cookie in the response  
		response.addCookie(cookie);		
		//System.out.println(client.getNom());
		if (client == null) {
			String msg = "Nom d'utilisateur / mot de passe invalide";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("login-client.jsp").forward(request, response);
		} else {
			//retrieving cookies 
			Cookie cookies[] = request.getCookies();
			//calling functions for getting particular cookies
			getCookie(cookies);							
			//setting username received from getCookie()
			request.setAttribute("username", username);
			//to get status of the particular user who logged in
			statut = clientDaoImple.find(username);							
			request.setAttribute("statut", statut);			
			request.getRequestDispatcher("dashboard").forward(request, response);
		}
		
	}
	
	private void saveClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String nomEntreprise = request.getParameter("nom_entreprise");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");		
		String civilite = request.getParameter("civilite");
		String username1 = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		client = new Client(nom, prenom, nomEntreprise, mail, phone, civilite, username1, password);
		client = clientDaoImple.save(client);
		
			//For hiding password
			String convertPassword = client.getPassword();
		    StringBuffer sb = new StringBuffer();
		    //Converting string to character array
		    char ch[] = convertPassword.toCharArray();
		    for(int i = 0; i < ch.length; i++) {
		       String hexString = Integer.toHexString(ch[i]);
		       sb.append(hexString);
		    }
		    convertPassword = sb.toString();
		    System.out.println(convertPassword);
			      
		request.setAttribute("client", client);
		request.setAttribute("password", convertPassword);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = getStatut(username);				
					
		request.setAttribute("statut", statut);
		request.getRequestDispatcher("client-confirme.jsp").forward(request, response);
	}
	
	private void modifyClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		client = clientDaoImple.find(id);
		System.out.println(client.getClientId()+ " Client ID");
		System.out.println(client);
		request.setAttribute("client", client);
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = getStatut(username);				
					
		request.setAttribute("statut", statut);
		//request.setAttribute("client", client);
		request.getRequestDispatcher("modify-client.jsp").forward(request, response);
	}
	
	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("clientId"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String nomEntreprise = request.getParameter("nom_entreprise");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");		
		String civilite = request.getParameter("civilite");
		String username1 = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		
		client = clientDaoImple.find(id);		
		
		client = new Client(nom, prenom, nomEntreprise, mail, phone, civilite, username1, password);
		client.setClientId(id);
		
		client = clientDaoImple.update(client);
		
		request.setAttribute("client", client);
		request.setAttribute("password", client.getPassword());
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = getStatut(username);				
					
		request.setAttribute("statut", statut);
		request.getRequestDispatcher("client-confirme.jsp").forward(request, response);
	}
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		client.setClientId(id);
		clientDaoImple.delete(client);
	}	
	
	
	/********************** SALLE DE REUNOIN ***************************************************/
	private void saveSalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);												
		//setting username received from getCookie()
		request.setAttribute("username", username);
		statut = getStatut(username);		
		request.setAttribute("statut", statut);		
		String salleId = request.getParameter("salleId");
		String salleNom = request.getParameter("salleNom");
		String localisation = request.getParameter("localisation");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		double tarif = Double.parseDouble(request.getParameter("tarif"));		
		Part filePart = request.getPart("image");		
		//get selected image file name
    	String imgName = filePart.getSubmittedFileName();
    	System.out.println("Selected image file name is "+imgName);    	
    	//upload path where we have to upload our selected image
    	String uploadPath = "C:/Users/Rettina/Documents/Concepteur Formation/Java-Progamming/MeetingRoomReservation/src/main/webapp/images/"+imgName;
    	System.out.println("upload path : "+uploadPath);    	
    	//uploading our selected image into image folder
    	try {
    		FileOutputStream fos = new FileOutputStream(uploadPath);
    		InputStream iStream = filePart.getInputStream();    		
    		byte[] data = new byte[iStream.available()];
    		iStream.read(data);
    		fos.write(data);
    		fos.close();    		
    		salleReunion = new SalleReunion(salleId, salleNom, localisation, capacite, tarif, imgName);
    		salleReunion = salleReunionDaoImple.save(salleReunion);
    		if (salleReunion != null) {
    			System.out.println("Successfully Added....");
			} else {
				System.out.println("Process Failed....");
			}
    		request.getRequestDispatcher("salle-list").forward(request, response);
    	} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void listSalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
								
		//setting username received from getCookie()
		request.setAttribute("username", username);
		statut = getStatut(username);					
		request.setAttribute("statut", statut);
		
		salleReunions = salleReunionDaoImple.getAll();
		if (salleReunions.isEmpty()) {
			String msg = "Aucun enregistrement trouvé !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		} else {
			
			request.setAttribute("salles", salleReunions);
			request.getRequestDispatcher("salle-list.jsp").forward(request, response);
		}
		
	}
	
	private void modifySalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salleId = request.getParameter("salleid");
		salleReunion = salleReunionDaoImple.find(salleId);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
										
		//setting username received from getCookie()
		request.setAttribute("username", username);
		
		statut = getStatut(username);
		
		request.setAttribute("statut", statut);		
		request.setAttribute("salle", salleReunion);
		request.getRequestDispatcher("modify-salle.jsp").forward(request, response);
	}
	
	private void updateSalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
										
		//setting username received from getCookie()
		request.setAttribute("username", username);
		statut = getStatut(username);					
		request.setAttribute("statut", statut);
		
		String salleId = request.getParameter("salleId");
		String salleNom = request.getParameter("salleNom");
		String localisation = request.getParameter("localisation");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		double tarif = Double.parseDouble(request.getParameter("tarif"));
		
		Part filePart = request.getPart("image");		
		//get selected image file name
    	String imgName = filePart.getSubmittedFileName();
    	System.out.println("Selected image file name is "+imgName);    	
    		
		salleReunion = salleReunionDaoImple.find(salleId);
		String imageDB = salleReunion.getSalleImage();
		System.out.println("Retrieved image file name from Db "+imageDB);  
		if (imageDB.equals(imgName)) {
			salleReunion = new SalleReunion(salleId, salleNom, localisation, capacite, tarif, imgName);
    		salleReunion = salleReunionDaoImple.update(salleReunion);
    		if (salleReunion != null) {
    			System.out.println("Successfully Updated....");
			} else {
				System.out.println("Updated Failed....");
			}
    		
		} else {
			String deleteImagePath = "C:/Users/Rettina/Documents/Concepteur Formation/Java-Progamming/MeetingRoomReservation/src/main/webapp/images/"+imageDB;
			File file = new File(deleteImagePath);
			if (file.delete()) {
		        System.out.println("File deleted successfully");
		    }
		    else {
		        System.out.println("Failed to delete the file");
		    }		
			//upload path where we have to upload our selected image
	    	String uploadPath = "C:/Users/Rettina/Documents/Concepteur Formation/Java-Progamming/MeetingRoomReservation/src/main/webapp/images/"+imgName;
	    	System.out.println("upload path : "+uploadPath);
			
	    	//uploading our selected image into image folder
	    	try {
	    		FileOutputStream fos = new FileOutputStream(uploadPath);
	    		InputStream iStream = filePart.getInputStream();
	    		
	    		byte[] data = new byte[iStream.available()];
	    		iStream.read(data);
	    		fos.write(data);
	    		fos.close();
	    		
	    		salleReunion = new SalleReunion(salleId, salleNom, localisation, capacite, tarif, imgName);
	    		salleReunion = salleReunionDaoImple.update(salleReunion);
	    		if (salleReunion != null) {
	    			System.out.println("Successfully Updated....");
				} else {
					System.out.println("Updated Failed....");
				}
	    		
	    	} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		request.getRequestDispatcher("salle-list").forward(request, response);
		
	}
	
	private void deleteSalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salleId = request.getParameter("salleid");
		
		salleReunion.setSalleId(salleId);
		salleReunionDaoImple.delete(salleReunion);
	}
	/******************************** RESERVATION **********************************/
	
	private void salleReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salleId = request.getParameter("salleid");
		salleReunion = salleReunionDaoImple.find(salleId);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
												
		//setting username received from getCookie()
		request.setAttribute("username", username);
		statut = getStatut(username);					
		request.setAttribute("statut", statut);
		
		request.setAttribute("salle", salleReunion);
		request.getRequestDispatcher("salle-reservation.jsp").forward(request, response);
	}

	private void saveReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salleId = request.getParameter("salleid");
		String username = request.getParameter("username");
		int clientId = clientDaoImple.findClientId(username);
		
		client = clientDaoImple.find(clientId);
		salleReunion = salleReunionDaoImple.find(salleId);
		
		String dateReserve = request.getParameter("reserveDate");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String motif = request.getParameter("motif");
		double montant = Double.parseDouble(request.getParameter("montant"));
		System.out.println("salleId "+salleId);
		System.out.println("clientId "+clientId);
		System.out.println("dateReserve "+dateReserve);
		System.out.println("startTime "+startTime);
		System.out.println("endTime "+endTime);
		System.out.println("motif "+motif);
		System.out.println("montant "+montant);
		
		reservation = reservationDaoImpl.findReservation(Date.valueOf(dateReserve), salleId, Time.valueOf(startTime));
		
		request.setAttribute("username", username);
		statut = getStatut(username);				
		request.setAttribute("statut", statut);
		
		if (reservation != null) {
			System.out.println("Can't reserve on this date");
			String msg = "Impossible de réserver à cette date. C'est Complet !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
			
		} else {
			reservation = new Reservation(Date.valueOf(dateReserve), Time.valueOf(startTime), Time.valueOf(endTime), motif, montant, client, salleReunion);
			reservation = reservationDaoImpl.save(reservation);
			request.setAttribute("reservation", reservation);
			request.setAttribute("client", client);
			request.setAttribute("salle", salleReunion);
			request.getRequestDispatcher("reservation-confirmation.jsp").forward(request, response);
		}		
		
	}
	
	private void modifyReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reserveId = Integer.parseInt(request.getParameter("idreserve"));
		reservation = reservationDaoImpl.find(reserveId);
		Client clientReserve;
		salleReunion = reservation.getSalle();
		clientReserve = reservation.getClient();  
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
										
		//setting username received from getCookie()
		request.setAttribute("username", username);
		
		statut = getStatut(username);
		
		request.setAttribute("statut", statut);		
		request.setAttribute("reservation", reservation);
		request.setAttribute("salle", salleReunion);
		request.setAttribute("client", clientReserve);	
		request.getRequestDispatcher("modify-reservation.jsp").forward(request, response);
	}
	
	private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salleId = request.getParameter("salleid");
		String username = request.getParameter("username");
		int reserveId = Integer.parseInt(request.getParameter("reserveid"));
		System.out.println("Username "+username);
		
		
		int clientId = clientDaoImple.findClientId(username);
		
		client = clientDaoImple.find(clientId);
		salleReunion = salleReunionDaoImple.find(salleId);
		
		String dateReserve = request.getParameter("reserveDate");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String motif = request.getParameter("motif");
		double montant = Double.parseDouble(request.getParameter("montant"));
		System.out.println("salleId "+salleId);
		System.out.println("clientId "+clientId);
		System.out.println("dateReserve "+dateReserve);
		System.out.println("startTime "+startTime);
		System.out.println("endTime "+endTime);
		System.out.println("motif "+motif);
		System.out.println("montant "+montant);		
		reservation = reservationDaoImpl.findReservation(Date.valueOf(dateReserve), salleId, Time.valueOf(startTime));
		
		request.setAttribute("username", username);
		statut = getStatut(username);				
		request.setAttribute("statut", statut);
		
		if (reservation != null) {
			System.out.println("Can't reserve on this date");
			String msg = "Impossible de réserver à cette date. C'est Complet !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
			
		} else {
			reservation = new Reservation(Date.valueOf(dateReserve), Time.valueOf(startTime), Time.valueOf(endTime), motif, montant, client, salleReunion);
			System.out.println("Reservation : "+reservation);
			System.out.println("Salle : "+client);
			System.out.println("Client :  "+salleReunion);
			reservation.setReserveId(reserveId);
			reservation = reservationDaoImpl.update(reservation);
			request.setAttribute("reservation", reservation);
			request.setAttribute("client", client);
			request.setAttribute("salle", salleReunion);
			request.getRequestDispatcher("reservation-confirmation.jsp").forward(request, response);
		}		
		
	}
	
	private void listReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
												
		//setting username received from getCookie()
		request.setAttribute("username", username);
		statut = getStatut(username);				
		request.setAttribute("statut", statut);
		
		reservations = reservationDaoImpl.getAll();
		request.setAttribute("reservations", reservations);
		request.getRequestDispatcher("reservation-agenda.jsp").forward(request, response);
	}
	
	private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reserveId = Integer.parseInt(request.getParameter("idreserve"));
		reservation.setReserveId(reserveId);
		
		reservationDaoImpl.delete(reservation);		
	}
	
	/********************** EMPLOYEE(USER) **************************************************************/
	
	private void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		user = userDaoImple.find(username, password);
		//System.out.println(client.getNom());
		
		//creating cookie object
		cookie = new Cookie("username", username);
		//adding cookie in the response  
		response.addCookie(cookie);
		if (user == null) {
			String msg = "Enter correct username & password";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("login-client.jsp").forward(request, response);
		} else {
			//retrieving cookies 
			Cookie cookies[] = request.getCookies();
			//calling functions for getting particular cookies
			getCookie(cookies);
									
			//setting username received from getCookie()
			request.setAttribute("username", username);
			
			//to get status of the particular user who logged in
			statut = getStatut(username);											
			request.setAttribute("statut", statut);
			request.getRequestDispatcher("dashboard").forward(request, response);			
		}
		
	}
	
	//inserting values in the database
	private void saveEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");				
		String civilite = request.getParameter("civilite");
		String username1 = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		int statut = Integer.parseInt(request.getParameter("statut"));
		user = new User(nom, prenom, mail, username1, password, civilite, statut);
		
		user = userDaoImple.save(user);
		
		//For hiding password
		String convertPassword = user.getPassword();
	      StringBuffer sb = new StringBuffer();
	      //Converting string to character array
	      char ch[] = convertPassword.toCharArray();
	      for(int i = 0; i < ch.length; i++) {
	         String hexString = Integer.toHexString(ch[i]);
	         sb.append(hexString);
	      }
	      convertPassword = sb.toString();
	      System.out.println(convertPassword);
		
	      //retrieving cookies 
	      Cookie cookies[] = request.getCookies();
		  //calling functions for getting particular cookies
		  getCookie(cookies);
									
		  //setting username received from getCookie()
		  request.setAttribute("username", username);
			
		  //to get status of the particular user who logged in
		  statut = getStatut(username);											
		  request.setAttribute("statut", statut);
	      
		request.setAttribute("user", user);
		request.setAttribute("password", convertPassword);
		request.getRequestDispatcher("user-confirme.jsp").forward(request, response);
	}
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		users = userDaoImple.getAll();
		request.setAttribute("users", users);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
										
		//setting username received from getCookie()
		request.setAttribute("username", username);
				
		//to get status of the particular user who logged in
		statut = getStatut(username);												
		request.setAttribute("statut", statut);
		request.getRequestDispatcher("list-employee.jsp").forward(request, response);
	}
	private void modifyEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idemployee"));
		user = userDaoImple.find(id);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
										
		//setting username received from getCookie()
		request.setAttribute("username", username);
				
		//to get status of the particular user who logged in
		statut = getStatut(username);												
		request.setAttribute("statut", statut);
		request.setAttribute("user", user);
		request.getRequestDispatcher("modify-employee.jsp").forward(request, response);
	}
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int id = Integer.parseInt(request.getParameter("empid"));
		String mail = request.getParameter("mail");				
		String civilite = request.getParameter("civilite");
		String username1 = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		int statut = Integer.parseInt(request.getParameter("statut"));
		
		user = userDaoImple.find(id);
		user = new User(nom, prenom, mail, username1, password, civilite, statut);
		user.setId(id);
		
		user = userDaoImple.update(user);
		request.setAttribute("user", user);
		request.setAttribute("password", user.getPassword());
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
								
		//setting username received from getCookie()
		request.setAttribute("username", username);
		
		//to get status of the particular user who logged in
		statut = getStatut(username);											
		request.setAttribute("statut", statut);
		
		request.getRequestDispatcher("user-confirme.jsp").forward(request, response);
		
	}
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idemployee"));
		user.setId(id);
		userDaoImple.delete(user);
	}
		
	/******************************** DASHBOARD **********************************/
	private void dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int countClients = clientDaoImple.countClient();
		int countUsers = userDaoImple.countUser();
		int countSalles = salleReunionDaoImple.countSalle();
		int countReservations = reservationDaoImpl.countReservation();
		
		request.setAttribute("no_of_clients", countClients);
		request.setAttribute("no_of_personnels", countUsers);
		request.setAttribute("no_of_salles", countSalles);
		request.setAttribute("no_of_reservations", countReservations);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			int clientId = client.getClientId();
			reservations = reservationDaoImpl.getAll(clientId);			
			//to get status of the particular user who logged in		
			statut = clientDaoImple.find(username);	
			System.out.println("Statut Client "+statut);
		} else {
			reservations = reservationDaoImpl.getAll();
			statut = userDaoImple.find(username);
			System.out.println("Statut User "+statut);
		}					
		request.setAttribute("statut", statut);
		request.setAttribute("reservations", reservations);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
	
	private void afficheProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
														
		//setting username received from getCookie()
		request.setAttribute("username", username);
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			//to get status of the particular user who logged in		
			statut = clientDaoImple.find(username);	
			request.setAttribute("statut", statut);
			request.setAttribute("client", client);
			request.getRequestDispatcher("profile-display-client.jsp").forward(request, response);
		} else {
			user = userDaoImple.findUser(username);
			statut = userDaoImple.find(username);
			request.setAttribute("statut", statut);
			request.setAttribute("user", user);
			request.getRequestDispatcher("modify-employee.jsp").forward(request, response);
		}	
		
	}
	
	private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = getStatut(username);					
					
		request.setAttribute("statut", statut);
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}
	//Recherche le client par le nom
	private void findClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
								
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = getStatut(username);			
		request.setAttribute("statut", statut);
		
		String nom = request.getParameter("nom");
		System.out.println("nom : "+nom);
		clients = clientDaoImple.getAll(nom);
		
		//checking whether data exist or not 
		if(clients.isEmpty()) {
			String msg = "Ce nom ne figure pas! Saisissez correctement SVP!!!";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		}		
		else{
			
			request.setAttribute("clients", clients);
			request.getRequestDispatcher("list-client.jsp").forward(request, response);
		}
		
	}
	
	//Plus d'infos sur un client
	private void clientDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
									
		//setting username received from getCookie()
		request.setAttribute("username", username);
				
		//to get status of the particular user who logged in
		statut = getStatut(username);											
		request.setAttribute("statut", statut);
		
		client = clientDaoImple.find(id);
		if (client != null ) {
			int clientId = client.getClientId();
			reservations = reservationDaoImpl.getAll(clientId);	
			request.setAttribute("client", client);
			request.setAttribute("reservations", reservations);
		}	
		request.getRequestDispatcher("client-plus-infos.jsp").forward(request, response);
	}
	
	//Recherche l'employee par le nom
	private void findEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
								
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = getStatut(username);			
		request.setAttribute("statut", statut);
		
		String nom = request.getParameter("nom");
		System.out.println("nom : "+nom);
		users = userDaoImple.getAll(nom);
		
		//checking whether data exist or not 
		if(users.isEmpty()) {
			String msg = "Ce nom ne figure pas! Saisissez correctement SVP!!!";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		}		
		else{
			
			request.setAttribute("users", users);
			request.getRequestDispatcher("list-employee.jsp").forward(request, response);
		}
		
	}

}
