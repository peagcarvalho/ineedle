package model.exceptions;

public class ClienteNaoCadastradoException extends Exception {
	
	public ClienteNaoCadastradoException() {
		super("Cliente não pode ser cadastrado");
	}

}
