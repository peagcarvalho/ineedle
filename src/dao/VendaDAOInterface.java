package dao;

import dto.VendaDTO;

public interface VendaDAOInterface {
	
	public void cadastrar(VendaDTO novaVenda);
	
	public VendaDTO buscar(VendaDTO vendaID);
	
	public void atualizar(VendaDTO vendaAtual);
	
	public void excluir(VendaDTO vendaID);
	
	public VendaDTO recuperarLista();

}
