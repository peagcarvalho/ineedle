package view;

import javax.swing.JFrame;

public class TelaPopUp extends Tela {
	
	private JFrame telaBase;
	
	public TelaPopUp(JFrame telaBase) {
		this.setTelaBase(telaBase);
		setSize(750, 470);
		addComponentes();
		setLocationRelativeTo(null);
	}
	
	public void addComponentes() {}

	public JFrame getTelaBase() {
		return telaBase;
	}

	public void setTelaBase(JFrame telaBase) {
		this.telaBase = telaBase;
	}

}