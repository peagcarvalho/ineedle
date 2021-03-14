package model;

import dao.FuncionarioDAOInterface;
import dao.postgresql.FuncionarioDAOPostgres;
import dto.FuncionarioDTO;

public class Funcionario {
	
	private FuncionarioDAOInterface dao;
	
	public Funcionario() {
		dao = new FuncionarioDAOPostgres();
	}
	
	public void cadastrar(FuncionarioDTO novoFunc) { // Faz o cadastro de um funcion�rio
		dao.cadastrar(novoFunc);
	}
	
	public FuncionarioDTO buscar(FuncionarioDTO funcID) { // Realiza a busca de um funcion�rio pelo ID
		return dao.buscar(funcID);
	}
	
	public void atualizar(FuncionarioDTO funcAtual) { // Atualiza as informa��es de um funcion�rio editado
		dao.atualizar(funcAtual);
	}
	
	public void excluir(FuncionarioDTO funcID) { // Exclui um funcion�rio do sistema
		dao.excluir(funcID);
	}
	
	public FuncionarioDTO recuperarLista() { // Recupera todos os funcion�rios cadastrados (usado nas tabelas gerais)
		return dao.recuperarLista();
	}

}
