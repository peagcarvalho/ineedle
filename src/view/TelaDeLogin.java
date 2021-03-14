package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import controller.FuncLogadoController;
import controller.FuncionarioController;
import dto.FuncionarioDTO;
import view.components.Label;
import view.components.LabelException;
import view.components.TextField;
import view.components.TextFieldSenha;

public class TelaDeLogin extends Tela {
	
	public TelaDeLogin() {
		addComponentes();
		setVisible(true);
	}
	
	public void addComponentes() {
		LabelException lbExc = new LabelException("Não foi possível iniciar a sessão. Verifique o ID e a senha");
		lbExc.setVisible(false);
		add(lbExc);
		
		Label lbIcone = new Label(Icones.MAIN, 50, 50);
		lbIcone.setBounds(390, 48, 50, 50);
		add(lbIcone);
		
		Label lbTitulo = new Label("iNeedle", null, new Font("Comic Sans MS", Font.PLAIN, 45));
		lbTitulo.setBounds(440, 45, 180, 50);
		add(lbTitulo);
		
		Label lbDetalhes = new Label("INICIAR SESSÃO", 18);
		lbDetalhes.setBounds(0, 110, 1000, 40);
		lbDetalhes.setHorizontalAlignment(JLabel.CENTER);
		lbDetalhes.setBackground(Cores.AQUAMARINE);
		lbDetalhes.setOpaque(true);
		add(lbDetalhes);
		
		TextField tfID = new TextField("ID");
		tfID.setBounds(365, 180, 265, 50);
		add(tfID);
		
		TextFieldSenha tfSenha = new TextFieldSenha("Senha");
		tfSenha.setBounds(365, 250, 265, 50);
		add(tfSenha);
		
		JCheckBox loginCheck = new JCheckBox("Mantenha-me conectado");
		loginCheck.setBounds(365, 315, 200, 30);
		loginCheck.setBackground(Cores.BLACK);
		loginCheck.setForeground(Color.LIGHT_GRAY);
		loginCheck.setFont(Fontes.FRANKLIN_14);
		add(loginCheck);
		
		Label btIniciar = new Label("Iniciar", 16);
		btIniciar.setBounds(365, 365, 265, 40);
		btIniciar.criarBotao();
		btIniciar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				FuncionarioDTO dto = new FuncionarioDTO();
				FuncionarioController ctrl = new FuncionarioController();
				
				dto.setId(tfID.getText());
				dto.setManterLogin(loginCheck.isSelected());
				dto = ctrl.buscar(dto);
				
				if (dto.getSenha() != null) {
					if (dto.getSenha().equals(new String(tfSenha.getPassword()))) {
						FuncLogadoController ctrl2 = new FuncLogadoController();
						
						ctrl2.logar(dto);
						
						TelaLogado tela = null;
						if (dto.isAdmin() == true) {
							tela = new TelaDeFuncionarios();
						} else {
							tela = new TelaDeVendas();
						}
						
						tela.setLocationRelativeTo(getFrame());
						getFrame().dispose();
						
					} else {
						lbExc.setVisible(true);
					}
				} else {
					lbExc.setVisible(true);
				}
				
			}
			
		});
		add(btIniciar);
	}

}
