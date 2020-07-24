package dao;

import dto.FuncionarioDTO;

public interface FuncLogDAOInterface {
	
	public void logar(FuncionarioDTO funcLog);
	
	public void deslogar();
	
	public FuncionarioDTO recuperar();

}
