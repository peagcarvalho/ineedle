package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ClienteController;
import controller.FuncionarioController;
import dto.ClienteDTO;
import dto.FuncionarioDTO;
import view.components.Label;
import view.components.TextField;
import view.components.TextFieldSenha;

public class PopUpAddFunc extends TelaPopUp {
	
	public PopUpAddFunc(JFrame telaBase) {
		super(telaBase);
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		Label lbAdd = new Label("ADICIONAR FUNCIONÁRIO", 18);
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
		
		TextField tfID = new TextField("ID");
		tfID.setBounds(478, 120, 200, 45);
		add(tfID);
		
		TextField tfCelular = new TextField("Celular");
		tfCelular.setBounds(58, 180, 150, 45);
		add(tfCelular);
		
		String[] opcoes = {"Masculino", "Femenino"};
		JComboBox cbSexo = new JComboBox(opcoes);
		cbSexo.setToolTipText("Sexo");
		cbSexo.setBounds(218, 188, 130, 36);
		add(cbSexo);
		
		TextFieldSenha tfSenha = new TextFieldSenha("Senha");
		tfSenha.setBounds(358, 180, 150, 45);
		add(tfSenha);
		
		JCheckBox admCheck = new JCheckBox("Administrador");
		admCheck.setBounds(528, 182, 150, 45);
		admCheck.setBackground(Cores.BLACK);
		admCheck.setForeground(Color.LIGHT_GRAY);
		add(admCheck);
		
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
				FuncionarioDTO dto = new FuncionarioDTO();
				
				dto.setId(tfID.getText());
				dto.setNome(tfNome.getText());
				dto.setSobrenome(tfSobrenome.getText());
				dto.setSexo((String) cbSexo.getSelectedItem());
				dto.setNumTel(tfCelular.getText());
				dto.setSenha(new String(tfSenha.getPassword()));
				dto.setAdmin(admCheck.isSelected());
				dto.setEndereco(tfRua.getText() + " - " + tfNum.getText() + " - " + tfBairro.getText());
				
				FuncionarioController ctrl = new FuncionarioController();
				ctrl.cadastrar(dto);
				
				getFrame().dispose();
				new TelaDeFuncionarios().setLocationRelativeTo(getTelaBase());
				getTelaBase().dispose();
			}
			
		});
		add(btAdd);
	}

}
