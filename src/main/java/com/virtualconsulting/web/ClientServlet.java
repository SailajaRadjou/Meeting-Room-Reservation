package com.virtualconsulting.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualconsulting.dao.ClientDaoImple;
import com.virtualconsulting.dao.SalleReunionDaoImple;
import com.virtualconsulting.dao.UserDaoImple;
import com.virtualconsulting.metier.Client;
import com.virtualconsulting.metier.SalleReunion;
import com.virtualconsulting.metier.User;


public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Client client;
    ClientDaoImple clientDaoImple = new ClientDaoImple();
    ArrayList<Client> clients;
    
    User user;
    UserDaoImple userDaoImple = new UserDaoImple();
    ArrayList<User> users;
    
    SalleReunion salleReunion;
    SalleReunionDaoImple salleReunionDaoImple = new SalleReunionDaoImple();
    ArrayList<SalleReunion> salleReunions;    
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
		case "/loginClient":
			request.getRequestDispatcher("login-client.jsp").forward(request, response);
			break;
			
		case "/loginValid":
			loginClient(request, response);
			break;
			
		case "/loginUser":
			loginClient(request, response);
			break;
		
		case "/save-client":
			saveClient(request, response);
			break;
			
		case "/modify-client":
			//modifyClient(request, response);
			break;
			
		case "/update-client":
			//updateClient(request, response);
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
	
	private void loginClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		client = clientDaoImple.find(username, password);
		//System.out.println(client.getNom());
		if (client == null) {
			String msg = "Enter correct username & password";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("login-client.jsp").forward(request, response);
		} else {
			request.setAttribute("username", username);
			clients = clientDaoImple.getAll();
			if (clients != null) {
				for (Client client : clients) {
					System.out.println(client);
				}
			} else {
				System.out.println("cannot recupere");
			}
			
			request.setAttribute("clients", clients);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
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
		
		request.setAttribute("client", client);
		request.getRequestDispatcher("client-confirme.jsp").forward(request, response);
	}
	
	private void dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
	private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

}
