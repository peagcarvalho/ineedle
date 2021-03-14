package view.commands;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class Invoker {
	
	private Map<String, Command> comandos = new HashMap<>();
	
	public Invoker() {
		comandos.put("INÍCIO", new InicioCommand());
		comandos.put("FUNCIONÁRIOS", new FuncionariosCommand());
		comandos.put("CLIENTES", new ClientesCommand());
		comandos.put("PRODUTOS", new ProdutosCommand());
		comandos.put("VENDAS", new VendasCommand());
		comandos.put("CONTABILIDADE", new ContabilidadeCommand());
		comandos.put("SAIR", new SairCommand());
	}
	
	public void invocar(String chave, JFrame frame) {
		Command comando = comandos.get(chave);
		
		comando.executar(frame);
	}

}
