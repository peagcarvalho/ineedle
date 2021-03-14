package view.components;

import java.awt.Color;
import javax.swing.JLabel;
import view.Cores;
import view.Fontes;

public class LabelException extends JLabel {
	
	public LabelException(String texto) {
		setText(texto);
		setForeground(Color.WHITE);
		setOpaque(true);
		setBackground(Cores.POMEGRANADE);
		setFont(Fontes.FRANKLIN_14);
		setBounds(0, 0, 1000, 25);
		setHorizontalAlignment(JLabel.CENTER);
	}

}
