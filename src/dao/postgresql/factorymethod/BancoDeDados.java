package dao.postgresql.factorymethod;

public abstract class BancoDeDados {
	
	public static final void conectar(String location) {
		BancoDeDados bd = null;
		
		if (location.equals("Sertânia")) {
			bd = new BancoDeDadosSertania();
		} else if (location.equals("Arcoverde")) {
			bd = new BancoDeDadosArcoverde();
		}
		
		bd.criarConexao(location);
	}
	
	protected abstract void criarConexao(String location);

}
