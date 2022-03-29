package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/iscritticorsi?user=root&password=filippo";
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Errore di connessione!");
			e.printStackTrace();
			return null;
		}
		
	}

}
