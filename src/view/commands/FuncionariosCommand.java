package view.commands;

import javax.swing.JFrame;
import view.TelaDeFuncionarios;

public class FuncionariosCommand implements Command {

	public void executar(JFrame frame) {
		new TelaDeFuncionarios().setLocationRelativeTo(frame);
		
		frame.dispose();
	}

}
