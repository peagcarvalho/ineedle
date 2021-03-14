package model;

import dao.ProdutoDAOInterface;
import dao.postgresql.ProdutoDAOPostgres;
import dto.ProdutoDTO;

public class Produto {
	
	private ProdutoDAOInterface dao;
	
	public Produto() {
		dao = new ProdutoDAOPostgres();
	}
	
	public void cadastrar(ProdutoDTO novoProduto) { // Faz o cadastro de um produto
		dao.cadastrar(novoProduto);
	}
	
	public ProdutoDTO buscar(ProdutoDTO produtoCod) { // Realiza a busca de um produto pelo c�digo
		return dao.buscar(produtoCod);
	}
	
	public void atualizar(ProdutoDTO produtoAtual) { // Atualiza as informa��es de um produto editado
		dao.atualizar(produtoAtual);
	}
	
	public void excluir(ProdutoDTO produtoCod) { // Exclui um produto do sistema
		dao.excluir(produtoCod);
	}
	
	public ProdutoDTO recuperarLista() { // Recupera todos os clientes cadastrados (usado nas tabelas gerais)
		return dao.recuperarLista();
	}

}
