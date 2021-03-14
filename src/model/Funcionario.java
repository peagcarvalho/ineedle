package model;

import dao.FuncionarioDAOInterface;
import dao.postgresql.FuncionarioDAOPostgres;
import dto.FuncionarioDTO;

public class Funcionario {
	
	private FuncionarioDAOInterface dao;
	
	public Funcionario() {
		dao = new FuncionarioDAOPostgres();
	}
	
	public void cadastrar(FuncionarioDTO novoFunc) { // Faz o cadastro de um funcionário
		dao.cadastrar(novoFunc);
	}
	
	public FuncionarioDTO buscar(FuncionarioDTO funcID) { // Realiza a busca de um funcionário pelo ID
		return dao.buscar(funcID);
	}
	
	public void atualizar(FuncionarioDTO funcAtual) { // Atualiza as informações de um funcionário editado
		dao.atualizar(funcAtual);
	}
	
	public void excluir(FuncionarioDTO funcID) { // Exclui um funcionário do sistema
		dao.excluir(funcID);
	}
	
	public FuncionarioDTO recuperarLista() { // Recupera todos os funcionários cadastrados (usado nas tabelas gerais)
		return dao.recuperarLista();
	}

}
