package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controller.ClienteController;
import dto.ClienteDTO;
import view.components.Label;
import view.components.TextField;

public class PopUpDetalhesCliente extends TelaPopUp {
	
	public PopUpDetalhesCliente(JFrame telaBase, ClienteDTO clienteSel) {
		super(telaBase);
		addComponentes(clienteSel);
		setVisible(true);
	}
	
	private Label lbDetalhes;
	
	public void addComponentes(ClienteDTO clienteSel) {
		TextField tfNome = new TextField("Nome");
		tfNome.setBounds(58, 120, 200, 45);
		tfNome.setEnabled(false);
		add(tfNome);
		
		TextField tfSobrenome = new TextField("Sobrenome");
		tfSobrenome.setBounds(268, 120, 200, 45);
		tfSobrenome.setEnabled(false);
		add(tfSobrenome);
		
		TextField tfCPF = new TextField("CPF");
		tfCPF.setBounds(478, 120, 200, 45);
		tfCPF.setEnabled(false);
		add(tfCPF);
		
		TextField tfDataNasc = new TextField("Data de Nascimento");
		tfDataNasc.setBounds(58, 180, 150, 45);
		tfDataNasc.setEnabled(false);
		add(tfDataNasc);
		
		TextField tfCelular = new TextField("Celular");
		tfCelular.setBounds(218, 180, 150, 45);
		tfCelular.setEnabled(false);
		add(tfCelular);
		
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
		tfNome.setText(clienteSel.getNome());
		tfSobrenome.setText(clienteSel.getSobrenome());
		tfCPF.setText(clienteSel.getCpf());
		tfDataNasc.setText(clienteSel.getDataNasc());
		tfCelular.setText(clienteSel.getNumTel());
		
		String[] endereco = clienteSel.getEndereco().split(" - ");
		tfRua.setText(endereco[0]);
		tfNum.setText(endereco[1]);
		tfBairro.setText(endereco[2]);
		
		Label btSave = new Label("Salvar", 16);
		btSave.setBounds(290, 355, 160, 38);
		btSave.criarBotao();
		btSave.setVisible(false);
		btSave.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				clienteSel.setNome(tfNome.getText());
				clienteSel.setSobrenome(tfSobrenome.getText());
				clienteSel.setNumTel(tfCelular.getText());
				clienteSel.setEndereco(tfRua.getText() + " - " + tfNum.getText() + " - " + tfBairro.getText());
				
				ClienteController ctrl = new ClienteController();
				ctrl.atualizar(clienteSel);
				
				getFrame().dispose();
				new TelaDeClientes().setLocationRelativeTo(getTelaBase());
				getTelaBase().dispose();
			}
			
		});
		add(btSave);
		
		Label btEdit = new Label(Icones.EDIT, 36, 36);
		btEdit.setBounds(505, 40, 36, 36);
		btEdit.setToolTipText("Editar");
		btEdit.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				lbDetalhes.setText("EDITAR CLIENTE");
				tfNome.setEnabled(true);
				tfSobrenome.setEnabled(true);
				tfCelular.setEnabled(true);
				tfRua.setEnabled(true);
				tfNum.setEnabled(true);
				tfBairro.setEnabled(true);
				btSave.setVisible(true);
			}
			
		});
		add(btEdit);
		
		lbDetalhes = new Label("DETALHES DO CLIENTE", 18);
		lbDetalhes.setBounds(0, 35, 750, 45);
		lbDetalhes.setHorizontalAlignment(JLabel.CENTER);
		lbDetalhes.setBackground(Cores.AQUAMARINE);
		lbDetalhes.setOpaque(true);
		add(lbDetalhes);
	}
}
