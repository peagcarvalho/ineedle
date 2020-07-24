package view.panels;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.FuncLogadoController;
import dto.FuncionarioDTO;
import view.Cores;
import view.Icones;
import view.components.Label;

public class BarraSuperior extends JPanel {
	
	public BarraSuperior() {
		setLayout(null);
		setBackground(Cores.BLACKER);
		setSize(1000, 45);
		addComponentes();
	}
	
	private Label lbMenu;

	private void addComponentes() {
		setLbMenu(new Label(Icones.MENU, 24, 24));
		getLbMenu().setBounds(0, 0, 42, 45);
		getLbMenu().setBackground(Cores.AQUAMARINE);
		getLbMenu().setOpaque(true);
		getLbMenu().setHorizontalAlignment(JLabel.CENTER);
		add(getLbMenu());
		
		Label lbTitulo = new Label("iNeedle", null, new Font("Comic Sans MS", Font.PLAIN, 24));
		lbTitulo.setBounds(56, 5, 90, 35);
		add(lbTitulo);
		
		JPanel painelConta = new JPanel();
		painelConta.setLayout(null);
		painelConta.setBackground(Cores.BLACKER);
		painelConta.setBounds(785, 0, 200, 45);
		
		FuncLogadoController ctrl = new FuncLogadoController();
		FuncionarioDTO funcLog = ctrl.recuperar();
		
		Label lbNome = new Label(funcLog.getNome() + " " + funcLog.getSobrenome(), 15);
		lbNome.setBounds(1, 12, 145, 25);
		lbNome.setHorizontalAlignment(JLabel.RIGHT);
		painelConta.add(lbNome);
		
		ImageIcon icone = null;
		if (funcLog.getSexo().equals("Femenino")) {
			icone = Icones.ACCOUNT_FEMALE;
		} else {
			icone = Icones.ACCOUNT_MALE;
		}
		Label lbIcone = new Label(icone, 40, 40);
		
		lbIcone.setBounds(150, 3, 40, 40);
		painelConta.add(lbIcone);
		
		add(painelConta);
	}

	public Label getLbMenu() {
		return lbMenu;
	}

	public void setLbMenu(Label lbMenu) {
		this.lbMenu = lbMenu;
	}

}