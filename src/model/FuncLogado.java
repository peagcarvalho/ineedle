package model;

import dao.FuncLogDAOInterface;
import dao.xml.FuncLogDAOXML;
import dto.FuncionarioDTO;

public class FuncLogado {
	
	private FuncLogDAOInterface dao;
	
	public FuncLogado() {
		dao = new FuncLogDAOXML();
	}
	
	public void logar(FuncionarioDTO funcLog) {
		dao.logar(funcLog);
	}

	public void deslogar() {
		dao.deslogar();
	}
	
	public FuncionarioDTO recuperar() {
		return dao.recuperar();
	}

}
