package dao;

import dto.ProdutoDTO;

public interface ProdutoDAOInterface {
	
	public void cadastrar(ProdutoDTO novoProduto);
	
	public ProdutoDTO buscar(ProdutoDTO produtoCod);
	
	public void atualizar(ProdutoDTO produtoAtual);
	
	public void excluir(ProdutoDTO produtoCod);
	
	public ProdutoDTO recuperarLista();

}
