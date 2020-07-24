package dao;

import dao.postgresql.PGSQLConnection;

public class ConexaoSingleton {
	
	private volatile static PGSQLConnection connection;
	
	public static PGSQLConnection getConnection() {
		if (connection == null) {
			synchronized (ConexaoSingleton.class) {
				if (connection == null) {
					connection = new PGSQLConnection(bancoDeDados);
				}
			}
		}
		
		return connection;
	}
	
	private static String bancoDeDados;
	
	public static void setBancoDeDados(String bancoDeDados) {
		ConexaoSingleton.bancoDeDados = bancoDeDados;
	}
}
