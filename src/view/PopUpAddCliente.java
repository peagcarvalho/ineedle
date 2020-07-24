package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controller.ClienteController;
import dto.ClienteDTO;
import view.components.Label;
import view.components.TextField;

public class PopUpAddCliente extends TelaPopUp {
	
	public PopUpAddCliente(JFrame telaBase) {
		super(telaBase);
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		Label lbAdd = new Label("ADICIONAR CLIENTE", 18);
		lbAdd.setBounds(0, 35, 750, 45);
		lbAdd.setHorizontalAlignment(JLabel.CENTER);
		lbAdd.setBackground(Cores.AQUAMARINE);
		lbAdd.setOpaque(true);
		add(lbAdd);
		
		TextField tfNome = new TextField("Nome");
		tfNome.setBounds(58, 120, 200, 45);
		add(tfNome);
		
		TextField tfSobrenome = new TextField("Sobrenome");
		tfSobrenome.setBounds(268, 120, 200, 45);
		add(tfSobrenome);
		
		TextField tfCPF = new TextField("CPF");
		tfCPF.setBounds(478, 120, 200, 45);
		add(tfCPF);
		
		TextField tfDataNasc = new TextField("Data de Nascimento");
		tfDataNasc.setBounds(58, 180, 150, 45);
		add(tfDataNasc);
		
		TextField tfCelular = new TextField("Celular");
		tfCelular.setBounds(218, 180, 150, 45);
		add(tfCelular);
		
		Label lbEndereco = new Label("Endereço", 15);
		lbEndereco.setBounds(58, 240, 100, 30);
		add(lbEndereco);
		
		TextField tfRua = new TextField("Rua");
		tfRua.setBounds(58, 280, 220, 45);
		add(tfRua);
		
		TextField tfNum = new TextField("Nº");
		tfNum.setBounds(288, 280, 100, 45);
		add(tfNum);
		
		TextField tfBairro = new TextField("Bairro");
		tfBairro.setBounds(398, 280, 140, 45);
		add(tfBairro);
		
		Label btAdd = new Label("Adicionar", 16);
		btAdd.setBounds(290, 355, 160, 38);
		btAdd.criarBotao();
		btAdd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				ClienteDTO dto = new ClienteDTO();
				
				dto.setCpf(tfCPF.getText());
				dto.setNome(tfNome.getText());
				dto.setSobrenome(tfSobrenome.getText());
				dto.setDataNasc(tfDataNasc.getText());
				dto.setNumTel(tfCelular.getText());
				dto.setEndereco(tfRua.getText() + " - " + tfNum.getText() + " - " + tfBairro.getText());
				
				ClienteController ctrl = new ClienteController();
				ctrl.cadastrar(dto);
				
				getFrame().dispose();
				new TelaDeClientes().setLocationRelativeTo(getTelaBase());
				getTelaBase().dispose();
			}
			
		});
		add(btAdd);
	}

}
