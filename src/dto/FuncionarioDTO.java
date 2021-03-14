package dto;

import java.util.ArrayList;

public class FuncionarioDTO extends PessoaDTO {
	
	private String id;
	private String senha;
	private boolean isAdmin;
	private ArrayList<FuncionarioDTO> funcionarios = new ArrayList<>();
	
	private boolean manterLogin;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ArrayList<FuncionarioDTO> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<FuncionarioDTO> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void addFuncionario(FuncionarioDTO dto) {
		funcionarios.add(dto);
	}

	public boolean isManterLogin() {
		return manterLogin;
	}

	public void setManterLogin(boolean manterLogin) {
		this.manterLogin = manterLogin;
	}
	
}
