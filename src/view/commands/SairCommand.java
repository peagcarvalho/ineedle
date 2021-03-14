package view.commands;

import javax.swing.JFrame;
import controller.FuncLogadoController;
import view.TelaDeLogin;

public class SairCommand implements Command {

	public void executar(JFrame frame) {
		FuncLogadoController ctrl = new FuncLogadoController();
		ctrl.deslogar();
		
		new TelaDeLogin().setLocationRelativeTo(frame);
		frame.dispose();
	}

}
