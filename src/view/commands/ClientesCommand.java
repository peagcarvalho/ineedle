package view.commands;

import javax.swing.JFrame;
import view.TelaDeClientes;

public class ClientesCommand implements Command {

	public void executar(JFrame frame) {
		new TelaDeClientes().setLocationRelativeTo(frame);
		
		frame.dispose();
	}

}
