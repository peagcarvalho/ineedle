package controller;

import dto.FuncionarioDTO;
import model.FuncLogado;

public class FuncLogadoController {
	
	private FuncLogado funcLog;
	
	public FuncLogadoController() {
		funcLog = new FuncLogado();
	}
	
	public void logar(FuncionarioDTO funcDTO) {
		funcLog.logar(funcDTO);
	}

	public void deslogar() {
		funcLog.deslogar();
	}
	
	public FuncionarioDTO recuperar() {
		return funcLog.recuperar();
	}

}
