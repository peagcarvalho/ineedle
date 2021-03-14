package dao.postgresql.factorymethod;

public abstract class BancoDeDados {
	
	public static final void conectar(String location) {
		BancoDeDados bd = null;
		
		if (location.equals("Sert�nia")) {
			bd = new BancoDeDadosSertania();
		} else if (location.equals("Arcoverde")) {
			bd = new BancoDeDadosArcoverde();
		}
		
		bd.criarConexao(location);
	}
	
	protected abstract void criarConexao(String location);

}
