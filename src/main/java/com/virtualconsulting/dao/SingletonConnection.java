package com.virtualconsulting.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SingletonConnection {	
	//Create a singleton connection
	private static Connection connection;		
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meeting_room_reservation","root","Mel22-Ang27");
			System.out.println("Connection Established.....\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Chaque appelle ne puis obtenir sa propre instance.
	public static Connection getConnection() {
		return connection;
	}
}
