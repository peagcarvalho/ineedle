package controller;

import dto.FuncionarioDTO;
import model.Funcionario;

public class FuncionarioController {
	
	private Funcionario funcionario;
	
	public FuncionarioController() {
		funcionario = new Funcionario();
	}
	
	public void cadastrar(FuncionarioDTO novoFunc) { // Faz o cadastro de um funcion�rio
		funcionario.cadastrar(novoFunc);
	}
	
	public FuncionarioDTO buscar(FuncionarioDTO funcID) { // Realiza a busca de um funcion�rio pelo ID
		return funcionario.buscar(funcID);
	}
	
	public void atualizar(FuncionarioDTO funcAtual) { // Atualiza as informa��es de um funcion�rio editado
		funcionario.atualizar(funcAtual);
	}
	
	public void excluir(FuncionarioDTO funcID) { // Exclui um funcion�rio do sistema
		funcionario.excluir(funcID);
	}
	
	public FuncionarioDTO recuperarLista() { // Recupera todos os funcion�rios cadastrados (usado nas tabelas gerais)
		return funcionario.recuperarLista();
	}

}
