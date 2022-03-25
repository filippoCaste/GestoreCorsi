package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
	public List<Corso> getCorsiByPeriodo(int periodo) {
		String sql = "SELECT * "
				+ "FROM corso "
				+ "WHERE pd = ?";
		List<Corso> result = new ArrayList <> ();
		
		// comincia il codice che è collegato al database
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result.add(new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd")));
			}
			
			st.close();
			rs.close();
			conn.close();
			return result;
			
		} catch(SQLException se) {
			System.err.println("Errore nel DAO!");
			se.printStackTrace();
			return null;
		}
	}
}
