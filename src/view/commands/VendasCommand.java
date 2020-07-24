package view.commands;

import javax.swing.JFrame;
import view.TelaDeVendas;

public class VendasCommand implements Command {

	public void executar(JFrame frame) {
		new TelaDeVendas().setLocationRelativeTo(frame);
		
		frame.dispose();
	}

}
