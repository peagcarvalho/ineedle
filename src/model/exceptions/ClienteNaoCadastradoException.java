package model.exceptions;

public class ClienteNaoCadastradoException extends Exception {
	
	public ClienteNaoCadastradoException() {
		super("Cliente n�o pode ser cadastrado");
	}

}
