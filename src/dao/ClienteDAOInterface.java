package dao;

import dto.ClienteDTO;

public interface ClienteDAOInterface {
	
	public void cadastrar(ClienteDTO novoCliente);
	
	public ClienteDTO buscar(ClienteDTO clienteCPF);
	
	public void atualizar(ClienteDTO clienteAtual);
	
	public void excluir(ClienteDTO clienteCPF);
	
	public ClienteDTO recuperarLista();

}
