package dao.xml;

import java.util.ArrayList;

import dao.FuncLogDAOInterface;
import dto.FuncionarioDTO;

public class FuncLogDAOXML implements FuncLogDAOInterface {

	public void logar(FuncionarioDTO funcLog) {
		ArrayList<String> func = new ArrayList<>();
		func.add(funcLog.getId());
		func.add(funcLog.getNome());
		func.add(funcLog.getSobrenome());
		func.add(funcLog.getNumTel());
		func.add(funcLog.getSexo());
		func.add(funcLog.getSenha());
		func.add(funcLog.isAdmin() + "");
		func.add(funcLog.isManterLogin() + "");
		
		Persistencia.salvar(func, "funcLogado");
	}

	public void deslogar() {
		Persistencia.salvar(null, "funcLogado");
	}
	
	public FuncionarioDTO recuperar() {
		ArrayList<String> func = Persistencia.recuperar("funcLogado");
		FuncionarioDTO dto = null;
		
		if (func != null && func.size() > 0) {
			dto = new FuncionarioDTO();
			
			dto.setId(func.get(Constantes.ID_FUNC));
			dto.setNome(func.get(Constantes.NOME));
			dto.setSobrenome(func.get(Constantes.SOBRENOME));
			dto.setNumTel(func.get(Constantes.NUM_TEL_FUNC));
			dto.setSexo(func.get(Constantes.SEXO_FUNC));
			dto.setSenha(func.get(Constantes.SENHA_FUNC));
			dto.setAdmin(Boolean.parseBoolean(func.get(Constantes.IS_ADMIN)));
			dto.setManterLogin(Boolean.parseBoolean(func.get(Constantes.MANTER_LOGIN)));
		}
		
		return dto;
	} 

}
