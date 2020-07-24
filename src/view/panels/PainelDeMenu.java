package view.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import view.Cores;
import view.Icones;

public class PainelDeMenu extends JPanel {
	
	private JFrame frame;
	
	public PainelDeMenu(JFrame frame) {
		setFrame(frame);
		setLayout(null);
		setBackground(Cores.BLACKER);
		setBounds(0, 45, 42, 520);
		addComponentes();
		setVisible(true);
	}

	public void addComponentes() {
		PainelDeFuncao deslogar = new PainelDeFuncao(Icones.LOGOUT, "Sair", 480, frame);
		deslogar.setToolTipText("Sair");
		add(deslogar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
