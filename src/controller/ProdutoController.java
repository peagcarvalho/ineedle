package controller;

import java.util.ArrayList;
import dto.ProdutoDTO;
import dto.iterator.Iterator;
import dto.iterator.ProdutoIterator;
import model.Produto;

public class ProdutoController {
	
	private Produto produto;
	
	public ProdutoController() {
		produto = new Produto();
	}
	
	public void cadastrar(ProdutoDTO novoProduto) { // Faz o cadastro de um produto
		produto.cadastrar(novoProduto);
	}
	
	public ProdutoDTO buscar(ProdutoDTO produtoCod) { // Realiza a busca de um produto pelo código
		return produto.buscar(produtoCod);
	}
	
	public void atualizar(ProdutoDTO produtoAtual) { // Atualiza as informações de um produto editado
		produto.atualizar(produtoAtual);
	}
	
	public void excluir(ProdutoDTO produtoCod) { // Exclui um produto do sistema
		produto.excluir(produtoCod);
	}
	
	public ProdutoDTO recuperarLista() { // Recupera todos os produtos cadastrados (usado nas tabelas gerais)
		return produto.recuperarLista();
	}

	public ProdutoDTO listaEstoqueValido() { // Recupera todos os produtos com estoque maior do que 0
		ProdutoDTO dto = produto.recuperarLista();
		ArrayList<ProdutoDTO> produtos = new ArrayList<>();
		Iterator i = new ProdutoIterator(dto.getProdutos());
		
		while (i.hasNext()) {
			ProdutoDTO prodDTO = (ProdutoDTO) i.next();
			
			if (prodDTO.getEstoque() > 0) {
				produtos.add(prodDTO);
			}
		}
		
		dto.setProdutos(produtos);
		return dto;
	}
	
}
