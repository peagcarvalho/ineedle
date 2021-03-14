package dto.iterator;

import java.util.ArrayList;
import dto.ClienteDTO;

public class ClienteIterator implements Iterator {
	
	ArrayList<ClienteDTO> clientes;
	int posicao = 0;
	
	public ClienteIterator(ArrayList<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	public boolean hasNext() {
		if (posicao >= clientes.size()) {
			return false;
		} else {
			return true;
		}
	}

	public ClienteDTO next() {
		ClienteDTO clienteDTO = clientes.get(posicao);
		posicao++;
		return clienteDTO;
	}
	
	

}
