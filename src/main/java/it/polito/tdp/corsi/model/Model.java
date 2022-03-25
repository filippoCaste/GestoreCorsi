package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model() {
		this.corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(int periodo) {
		return this.corsoDao.getCorsiByPeriodo(periodo);
	}
}
