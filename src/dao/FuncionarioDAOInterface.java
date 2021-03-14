package dao;

import dto.FuncionarioDTO;

public interface FuncionarioDAOInterface {
	
	public void cadastrar(FuncionarioDTO novoFunc);
	
	public FuncionarioDTO buscar(FuncionarioDTO funcID);
	
	public void atualizar(FuncionarioDTO funcAtual);
	
	public void excluir(FuncionarioDTO funcID);
	
	public FuncionarioDTO recuperarLista();

}
