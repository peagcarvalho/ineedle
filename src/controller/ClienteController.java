package controller;

import dto.ClienteDTO;
import model.Cliente;

public class ClienteController {
	
	private Cliente cliente;
	
	public ClienteController() {
		cliente = new Cliente();
	}
	
	public void cadastrar(ClienteDTO novoCliente) { // Faz o cadastro de um cliente
		cliente.cadastrar(novoCliente);
	}
	
	public ClienteDTO buscar(ClienteDTO clienteCPF) { // Realiza a busca de um cliente pelo CPF
		return cliente.buscar(clienteCPF);
	}
	
	public void atualizar(ClienteDTO clienteAtual) { // Atualiza as informações de um cliente editado
		cliente.atualizar(clienteAtual);
	}
	
	public void excluir(ClienteDTO clienteCPF) { // Exclui um cliente do sistema
		cliente.excluir(clienteCPF);
	}
	
	public ClienteDTO recuperarLista() { // Recupera todos os clientes cadastrados (usado nas tabelas gerais)
		return cliente.recuperarLista();
	}

}
