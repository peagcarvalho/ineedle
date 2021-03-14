package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.Cores;

public class Label extends JLabel {
	
	public Label() {}

	public Label(String texto, ImageIcon icone, Font fonte) {
		setText(texto);
		setIcon(icone);
		setFont(fonte);
		setForeground(Color.WHITE);
	}
	
	public Label(ImageIcon icone, int width, int height) {
		setIcon(new ImageIcon(icone.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
	}
	
	public Label(String texto, int tamanho) {
		setText(texto);
		setForeground(Color.WHITE);
		setFont(new Font("Franklin Gothic Medium", Font.PLAIN, tamanho));
		setHorizontalAlignment(JLabel.LEFT);
	}
	
	public void criarBotao() {
		setForeground(Color.WHITE);
		setBackground(Cores.AQUAMARINE);
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
	}
	
}
