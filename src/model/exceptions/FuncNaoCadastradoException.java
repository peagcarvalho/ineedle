package model.exceptions;

public class FuncNaoCadastradoException extends Exception {
	
	public FuncNaoCadastradoException() {
		super("Funcionário não pode ser cadastrado");
	}

}
