package view.components;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dto.ClienteDTO;
import view.Cores;
import view.Icones;

public class PainelCliente extends JPanel {
	
	private Label lbNome;
	private Label lbCPF;
	
	public PainelCliente() {
		setLayout(null);
		setBackground(Cores.AQUAMARINE);
		setBounds(85, 72, 216, 56);
		setToolTipText("Cliente");
		
		Label lbIcone = new Label(Icones.CLIENT, 50, 50);
		lbIcone.setBounds(2, 4, 50, 50);
		add(lbIcone);
		
		lbNome = new Label("", 14);
		lbNome.setBounds(54, 4, 158, 20);
		lbNome.setHorizontalAlignment(JLabel.CENTER);
		add(lbNome);
		
		lbCPF = new Label("", null, new Font("Franklin Gothic Medium", Font.ITALIC, 14));
		lbCPF.setBounds(52, 30, 158, 20);
		lbCPF.setHorizontalAlignment(JLabel.CENTER);
		add(lbCPF);
	}
	
	public void atualizarDados(ClienteDTO c) {
		lbNome.setText((c.getNome() + " " + c.getSobrenome()).toUpperCase());
		lbCPF.setText("CPF: " + c.getCpf());
		
		repaint();
		setVisible(true);
	}

}
