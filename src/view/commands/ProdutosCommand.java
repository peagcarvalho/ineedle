package view.commands;

import javax.swing.JFrame;
import view.TelaDeProdutos;

public class ProdutosCommand implements Command {

	public void executar(JFrame frame) {
		new TelaDeProdutos().setLocationRelativeTo(frame);
		
		frame.dispose();
	}

}
