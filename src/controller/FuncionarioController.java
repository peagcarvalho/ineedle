package controller;

import dto.FuncionarioDTO;
import model.Funcionario;

public class FuncionarioController {
	
	private Funcionario funcionario;
	
	public FuncionarioController() {
		funcionario = new Funcionario();
	}
	
	public void cadastrar(FuncionarioDTO novoFunc) { // Faz o cadastro de um funcionário
		funcionario.cadastrar(novoFunc);
	}
	
	public FuncionarioDTO buscar(FuncionarioDTO funcID) { // Realiza a busca de um funcionário pelo ID
		return funcionario.buscar(funcID);
	}
	
	public void atualizar(FuncionarioDTO funcAtual) { // Atualiza as informações de um funcionário editado
		funcionario.atualizar(funcAtual);
	}
	
	public void excluir(FuncionarioDTO funcID) { // Exclui um funcionário do sistema
		funcionario.excluir(funcID);
	}
	
	public FuncionarioDTO recuperarLista() { // Recupera todos os funcionários cadastrados (usado nas tabelas gerais)
		return funcionario.recuperarLista();
	}

}
