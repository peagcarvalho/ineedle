package dto;

import java.util.ArrayList;

public class ClienteDTO extends PessoaDTO {
	
	private String cpf;
	private ArrayList<ClienteDTO> clientes = new ArrayList<>();

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<ClienteDTO> clientes) {
		this.clientes = clientes;
	}
	
	public void addCliente(ClienteDTO dto) {
		clientes.add(dto);
	}
	
	public String toString() {
		return "Nome: " + getNome() + " " + getSobrenome() + ", CPF: " + getCpf();
	}

}
