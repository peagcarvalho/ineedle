package dao.postgresql.factorymethod;

import dao.ConexaoSingleton;

public class BancoDeDadosArcoverde extends BancoDeDados {

	protected void criarConexao(String location) {
		ConexaoSingleton.setBancoDeDados("BDCidadeB");
	}

}
