package model;

import dao.VendaDAOInterface;
import dao.postgresql.VendaDAOPostgres;
import dto.VendaDTO;

public class Venda {
	
	private VendaDAOInterface dao;
	
	public Venda() {
		dao = new VendaDAOPostgres();
	}
	
	public void cadastrar(VendaDTO novaVenda) { // Faz o cadastro de uma venda
		dao.cadastrar(novaVenda);
	}
	
	public VendaDTO buscar(VendaDTO vendaID) { // Realiza a busca de uma venda pelo ID
		return dao.buscar(vendaID);
	}
	
	public void atualizar(VendaDTO vendaAtual) { // Atualiza as informações de uma venda editada
		dao.atualizar(vendaAtual);
	}
	
	public void excluir(VendaDTO vendaID) { // Exclui uma venda do sistema
		dao.excluir(vendaID);
	}
	
	public VendaDTO recuperarLista() { // Recupera todos as vendas cadastradas (usado nas tabelas gerais)
		return dao.recuperarLista();
	}

}
