package view.panels;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Cores;
import view.components.Label;
import view.listeners.OuvinteDeMenu;

public class PainelDeFuncao extends JPanel {

	public PainelDeFuncao(Icon imagem, String str, int altura, JFrame frame) {
		setLayout(null);
		setBounds(0, altura, 220, 36);
		setBackground(Cores.BLACKER);
		
		JLabel icone = new JLabel();
		icone.setBounds(8, 3, 30, 30);
		icone.setIcon(imagem);
		add(icone);
		
		Label texto = new Label(str.toUpperCase(), 14);
		texto.setBounds(44, 3, 188, 30);
		add(texto);
		
		addMouseListener(new OuvinteDeMenu(this, texto.getText(), frame));
	}
}
