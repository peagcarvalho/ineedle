package view;

import javax.swing.JFrame;

public class Tela extends JFrame {
	
	private JFrame frame = this;
	
	public Tela() {
		setSize(1000, 600);
		setTitle("iNeedle");
		setIconImage(Icones.MAIN.getImage());
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Cores.BLACK);
	}
	
	public void addComponentes() {
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}