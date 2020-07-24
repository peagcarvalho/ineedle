package view.commands;

import javax.swing.JFrame;
import view.TelaLogado;

public class InicioCommand implements Command {

	public void executar(JFrame frame) {
		new TelaLogado().setLocationRelativeTo(frame);
		
		frame.dispose();
	}

}
