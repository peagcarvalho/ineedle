package dto.iterator;

import java.util.ArrayList;
import dto.ProdutoDTO;

public class ProdutoIterator implements Iterator {
	
	ArrayList<ProdutoDTO> produtos;
	int posicao = 0;

	public ProdutoIterator(ArrayList<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public boolean hasNext() {
		if (posicao >= produtos.size()) {
			return false;
		} else {
			return true;
		}
	}

	public Object next() {
		ProdutoDTO prodDTO = produtos.get(posicao);
		posicao++;
		return prodDTO;
	}

}
