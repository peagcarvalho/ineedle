package model;

import dao.ClienteDAOInterface;
import dao.postgresql.ClienteDAOPostgres;
import dto.ClienteDTO;

public class Cliente {
	
	private ClienteDAOInterface dao;
	
	public Cliente() {
		dao = new ClienteDAOPostgres();
	}
	
	public void cadastrar(ClienteDTO novoCliente) { // Faz o cadastro de um cliente
		dao.cadastrar(novoCliente);
	}
	
	public ClienteDTO buscar(ClienteDTO clienteCPF) { // Realiza a busca de um cliente pelo CPF
		return dao.buscar(clienteCPF);
	}
	
	public void atualizar(ClienteDTO clienteAtual) { // Atualiza as informações de um cliente editado
		dao.atualizar(clienteAtual);
	}
	
	public void excluir(ClienteDTO clienteCPF) { // Exclui um cliente do sistema
		dao.excluir(clienteCPF);
	}
	
	public ClienteDTO recuperarLista() { // Recupera todos os clientes cadastrados (usado nas tabelas gerais)
		return dao.recuperarLista();
	}

}
