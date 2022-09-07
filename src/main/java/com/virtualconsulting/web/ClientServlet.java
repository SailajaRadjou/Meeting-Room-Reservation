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
		case "/dashboard": 
			dashboard(request, response);
			break;
			
		case "/contact":
			contact(request, response);
			break;
			
		case "/table":
			request.getRequestDispatcher("table.jsp").forward(request, response);
			break;
		case "/login":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;	
		default:
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

}
