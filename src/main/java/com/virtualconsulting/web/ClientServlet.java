package com.virtualconsulting.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		//System.out.println(path);
		
		switch (path) {
		case "/list-client": 
			listUser(request, response);
			break;
		default:
			//countClient(request, response);
			listUser(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//clients = cDaoImple.getAll();
		//request.setAttribute("clients", clients);
		request.setAttribute("no_of_clients", "23");
		request.setAttribute("no_of_comptes", "12");
		request.setAttribute("comptes_courants", "6");
		request.setAttribute("comptes_epargne", "6");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
