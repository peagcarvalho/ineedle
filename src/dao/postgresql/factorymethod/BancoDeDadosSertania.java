package dao.postgresql.factorymethod;

import dao.ConexaoSingleton;

public class BancoDeDadosSertania extends BancoDeDados {

	protected void criarConexao(String location) {
		ConexaoSingleton.setBancoDeDados("BDCidadeA");
	}

}