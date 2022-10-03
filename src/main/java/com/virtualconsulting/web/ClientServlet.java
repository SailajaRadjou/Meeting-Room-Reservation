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
			
		case "/contact":
			contact(request, response);
			break;
			
		case "/table":
			request.getRequestDispatcher("table.jsp").forward(request, response);
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
			
			break;
		
		case "/salle-reservation":
			salleReservation(request, response);
			break;
		
		case "/save-reservation":
			saveReservation(request, response);
			break;
			
		case "/home-page":
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
		statut = clientDaoImple.find(username);	
				
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
		String username = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		client = new Client(nom, prenom, nomEntreprise, mail, phone, civilite, username, password);
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
		statut = clientDaoImple.find(username);	
					
		request.setAttribute("statut", statut);
		request.getRequestDispatcher("client-confirme.jsp").forward(request, response);
	}
	
	private void modifyClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		client = clientDaoImple.find(id);
		System.out.println(client.getClientId()+ " Client ID");
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = clientDaoImple.find(username);	
					
		request.setAttribute("statut", statut);
		request.setAttribute("client", client);
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
		String username = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		
		client = clientDaoImple.find(id);		
		
		client = new Client(nom, prenom, nomEntreprise, mail, phone, civilite, username, password);
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
		statut = clientDaoImple.find(username);	
					
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
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			//to get status of the particular user who logged in		
			statut = clientDaoImple.find(username);	
		} else {
			statut = userDaoImple.find(username);
		}					
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
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			//to get status of the particular user who logged in		
			statut = clientDaoImple.find(username);	
		} else {
			statut = userDaoImple.find(username);
		}					
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
		
		client = clientDaoImple.findClient(username);
		if (client != null ) {
		//to get status of the particular user who logged in		
		statut = clientDaoImple.find(username);	
		} else {
		statut = userDaoImple.find(username);
		}	
		
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
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			//to get status of the particular user who logged in		
			statut = clientDaoImple.find(username);	
		} else {
			statut = userDaoImple.find(username);
		}					
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
		client = clientDaoImple.findClient(username);
		if (client != null ) {
			//to get status of the particular user who logged in		
			statut = clientDaoImple.find(username);	
		} else {
			statut = userDaoImple.find(username);
		}					
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
	
	private void listReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		} else {
			statut = userDaoImple.find(username);
		}					
		request.setAttribute("statut", statut);
		
		reservations = reservationDaoImpl.getAll();
		request.setAttribute("reservations", reservations);
		request.getRequestDispatcher("reservation-agenda.jsp").forward(request, response);
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
			statut = userDaoImple.find(username);								
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
		String username = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		int statut = Integer.parseInt(request.getParameter("statut"));
		user = new User(nom, prenom, mail, username, password, civilite, statut);
		
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
		  statut = userDaoImple.find(username);								
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
		statut = userDaoImple.find(username);								
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
		statut = userDaoImple.find(username);								
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
		String username = request.getParameter("nom_identifiant");
		String password = request.getParameter("mot_de_passe");
		int statut = Integer.parseInt(request.getParameter("statut"));
		
		user = userDaoImple.find(id);
		user = new User(nom, prenom, mail, username, password, civilite, statut);
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
		statut = userDaoImple.find(username);								
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
		
		request.setAttribute("no_of_clients", countClients);
		request.setAttribute("no_of_personnels", countUsers);
		request.setAttribute("no_of_salles", countSalles);
		
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = clientDaoImple.find(username);	
					
		request.setAttribute("statut", statut);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
	private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving cookies 
		Cookie cookies[] = request.getCookies();
		//calling functions for getting particular cookies
		getCookie(cookies);
						
		//setting username received from getCookie()
		request.setAttribute("username", username);
		//to get status of the particular user who logged in
		statut = clientDaoImple.find(username);	
					
		request.setAttribute("statut", statut);
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

}
