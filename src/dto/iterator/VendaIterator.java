package dto.iterator;

import java.util.ArrayList;
import dto.VendaDTO;

public class VendaIterator implements Iterator {

	ArrayList<VendaDTO> vendas;
	int posicao = 0;
	
	public VendaIterator(ArrayList<VendaDTO> vendas) {
		this.vendas = vendas;
	}

	public boolean hasNext() {
		if (posicao >= vendas.size()) {
			return false;
		} else {
			return true;
		}
	}

	public Object next() {
		VendaDTO vendaDTO = vendas.get(posicao);
		posicao++;
		return vendaDTO;
	}
	
}
