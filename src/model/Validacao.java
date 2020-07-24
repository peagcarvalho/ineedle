package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dao.FuncionarioDAOInterface;
import dao.postgresql.FuncionarioDAOPostgres;
import dto.ClienteDTO;
import dto.FuncionarioDTO;
import model.exceptions.CPFInvalidoException;
import model.exceptions.DataInvalidaException;
import model.exceptions.EmailInvalidoException;
import model.exceptions.IDInvalidoException;
import model.exceptions.LoginInvalidoException;
import model.exceptions.SenhaInvalidaException;
import model.exceptions.TextoInvalidoException;
	
public abstract class Validacao {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
												+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static Pattern pattern = null;
	
	public static boolean verificarCPF(String cpf) throws CPFInvalidoException {
		if (cpf.contains(" ") == true) {
			throw new CPFInvalidoException();
		} else {
			Cliente cliente = new Cliente();
			ArrayList<ClienteDTO> clientes = cliente.recuperarLista().getClientes();
			
			if (clientes.size() > 0) {
				for(ClienteDTO c : clientes) {
					if (cpf.equals(c.getCpf()) == true) {
						throw new CPFInvalidoException();
					}
				}
			}
			
		}
		
		return true;
	}
	
	public static boolean verificarID(String id) throws IDInvalidoException {
		if (id.contains(" ") == true) {
			throw new IDInvalidoException();
		} else {
			Funcionario funcionario = new Funcionario();
			
			FuncionarioDTO dto = funcionario.recuperarLista();
			ArrayList<FuncionarioDTO> funcionarios = dto.getFuncionarios();
			
			if (funcionarios.size() > 0) {
				for(FuncionarioDTO f : funcionarios) {
					if (id.equals(f.getId()) == true) {
						throw new IDInvalidoException();
					}
				}
			}
			
		}
		
		return true;
	}
	
	public static boolean verificarEmail(String email) throws EmailInvalidoException {
		pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(email);
	    
		if (matcher.matches() == false) {
			throw new EmailInvalidoException();
		}
		
		return true;
	}
	
	public static boolean verificarSenha(String senha) throws SenhaInvalidaException {
		if (senha.length() < 6) {
			throw new SenhaInvalidaException();
		} else {
			int digitos = 0;
			int letras = 0;
			char[] c = senha.toCharArray();
			
			for(char s : c) {
				if (Character.isDigit(s) == true) {
					digitos++;
				} else if (Character.isAlphabetic(s)){
					letras++;
				}
			}
			
			if (letras < 3 || digitos < 3) {
				throw new SenhaInvalidaException();
			}
 		}
		
		return true;
	}
	
	public static boolean verificarData(String data) throws DataInvalidaException {
		if (data.equals("  /  /    ")) {
			throw new DataInvalidaException();
		} else {
			String[] d = data.split("/");
			int dia = Integer.parseInt(d[0]);
			int mes = Integer.parseInt(d[1]);

				if (mes > 0 && mes < 13) {
					if (dia > 0 && dia < 32) {
						switch (dia) {
							case 31:
								if (mes == 4 || mes == 6 || mes == 9 || mes == 11 || mes == 2) {
									throw new DataInvalidaException();
								}
								break;
							case 29:
							case 30:
								if (mes == 2) {
									throw new DataInvalidaException();
								}
						}
					} else
						throw new DataInvalidaException();
				} else
					throw new DataInvalidaException();
		}
		
		return true;
	}

	public static boolean verificarTexto(String texto) throws TextoInvalidoException {
		if (texto.equals("")) {
			throw new TextoInvalidoException();
		}
		
		return true;
	}
	
	public static void verificarEspacos(String texto) throws TextoInvalidoException { // verifica se as Strings possuem espaços
		if (texto.contains(" ") == true) {
			throw new TextoInvalidoException();
		}
	}
	
	public static FuncionarioDTO verificarLogin(String ID, String senha) throws LoginInvalidoException {
		Funcionario funcionario = new Funcionario();
		
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setId(ID);
		
		dto = funcionario.buscar(dto);
		
		if (dto != null) {
			if (dto.getSenha().equals(senha) == true) {
				return dto;
			} else {
				throw new LoginInvalidoException();
			}
		} else {
			throw new LoginInvalidoException();
		}
	}
	
	public static void verificarEndereco(String endereco) throws TextoInvalidoException {
		String[] split = endereco.split(" - ");
		
		String rua = split[0];
		String num = split[1];
		String bairro = split[2];
		
		verificarTexto(rua);
		verificarTexto(num);
		verificarTexto(bairro);
	}
}
