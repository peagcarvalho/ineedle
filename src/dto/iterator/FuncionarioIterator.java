package dto.iterator;

import java.util.ArrayList;
import dto.FuncionarioDTO;

public class FuncionarioIterator implements Iterator {
	
	ArrayList<FuncionarioDTO> funcionarios;
	int posicao = 0;
	
	public FuncionarioIterator(ArrayList<FuncionarioDTO> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public boolean hasNext() {
		if (posicao >= funcionarios.size()) {
			return false;
		} else {
			return true;
		}
	}

	public Object next() {
		FuncionarioDTO funcDTO = funcionarios.get(posicao);
		posicao++;
		return funcDTO;
	}

}
