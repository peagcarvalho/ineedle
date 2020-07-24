package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ClienteController;
import controller.FuncionarioController;
import dto.FuncionarioDTO;
import view.components.Label;
import view.components.TextField;

public class PopUpDetalhesFunc extends TelaPopUp {
	
	public PopUpDetalhesFunc(JFrame telaBase, FuncionarioDTO funcSel) {
		super(telaBase);
		addComponentes(funcSel);
		setVisible(true);
	}
	
	private Label lbDetalhes;
	
	public void addComponentes(FuncionarioDTO funcSel) {
		TextField tfNome = new TextField("Nome");
		tfNome.setBounds(58, 120, 200, 45);
		tfNome.setEnabled(false);
		add(tfNome);
		
		TextField tfSobrenome = new TextField("Sobrenome");
		tfSobrenome.setBounds(268, 120, 200, 45);
		tfSobrenome.setEnabled(false);
		add(tfSobrenome);
		
		TextField tfID = new TextField("ID");
		tfID.setBounds(478, 120, 200, 45);
		tfID.setEnabled(false);
		add(tfID);
		
		TextField tfCelular = new TextField("Celular");
		tfCelular.setBounds(58, 180, 150, 45);
		tfCelular.setEnabled(false);
		add(tfCelular);
		
		TextField tfSexo = new TextField("Sexo");
		tfSexo.setBounds(218, 180, 130, 45);
		tfSexo.setEnabled(false);
		add(tfSexo);
		
		TextField tfSenha = new TextField("Senha");
		tfSenha.setBounds(358, 180, 150, 45);
		tfSenha.setEnabled(false);
		add(tfSenha);
		
		JCheckBox admCheck = new JCheckBox("Administrador");
		admCheck.setBounds(528, 182, 150, 45);
		admCheck.setBackground(Cores.BLACK);
		admCheck.setForeground(Color.LIGHT_GRAY);
		admCheck.setEnabled(false);
		add(admCheck);
		
		Label lbEndereco = new Label("Endereço", 15);
		lbEndereco.setBounds(58, 240, 100, 30);
		add(lbEndereco);
		
		TextField tfRua = new TextField("Rua");
		tfRua.setBounds(58, 280, 220, 45);
		tfRua.setEnabled(false);
		add(tfRua);
		
		TextField tfNum = new TextField("Nº");
		tfNum.setBounds(288, 280, 100, 45);
		tfNum.setEnabled(false);
		add(tfNum);
		
		TextField tfBairro = new TextField("Bairro");
		tfBairro.setBounds(398, 280, 140, 45);
		tfBairro.setEnabled(false);
		add(tfBairro);
		
		// SETA OS ATRIBUTOS NOS TEXTFIELDS
			tfNome.setText(funcSel.getNome());
			tfSobrenome.setText(funcSel.getSobrenome());
			tfID.setText(funcSel.getId());
			tfSenha.setText(funcSel.getSenha());
			tfCelular.setText(funcSel.getNumTel());
			tfSexo.setText(funcSel.getSexo());
			
			if (funcSel.isAdmin() == true) {
				admCheck.setSelected(true);
			}
			
			String[] endereco = funcSel.getEndereco().split(" - ");
			tfRua.setText(endereco[0]);
			tfNum.setText(endereco[1]);
			tfBairro.setText(endereco[2]);
		
		Label btSave = new Label("Salvar", 16);
		btSave.setBounds(290, 355, 160, 38);
		btSave.criarBotao();
		btSave.setVisible(false);
		btSave.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				funcSel.setNome(tfNome.getText());
				funcSel.setSobrenome(tfSobrenome.getText());
				funcSel.setNumTel(tfCelular.getText());
				funcSel.setEndereco(tfRua.getText() + " - " + tfNum.getText() + " - " + tfBairro.getText());
				funcSel.setSenha(tfSenha.getText());
				funcSel.setAdmin(admCheck.isSelected());
				
				FuncionarioController ctrl = new FuncionarioController();
				ctrl.atualizar(funcSel);
				
				getFrame().dispose();
				new TelaDeFuncionarios().setLocationRelativeTo(getTelaBase());
				getTelaBase().dispose();
			}
			
		});
		add(btSave);
		
		Label btEdit = new Label(Icones.EDIT, 36, 36);
		btEdit.setBounds(505, 40, 36, 36);
		btEdit.setToolTipText("Editar");
		btEdit.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				lbDetalhes.setText("EDITAR FUNCIONÁRIO");
				tfNome.setEnabled(true);
				tfSobrenome.setEnabled(true);
				tfCelular.setEnabled(true);
				tfSenha.setEnabled(true);
				admCheck.setEnabled(true);
				tfRua.setEnabled(true);
				tfNum.setEnabled(true);
				tfBairro.setEnabled(true);
				btSave.setVisible(true);
			}
			
		});
		add(btEdit);
		
		lbDetalhes = new Label("DETALHES DO FUNCIONÁRIO", 18);
		lbDetalhes.setBounds(0, 35, 750, 45);
		lbDetalhes.setHorizontalAlignment(JLabel.CENTER);
		lbDetalhes.setBackground(Cores.AQUAMARINE);
		lbDetalhes.setOpaque(true);
		add(lbDetalhes);
	}

}
