package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import controller.FuncLogadoController;
import dao.postgresql.factorymethod.BancoDeDados;
import dto.FuncionarioDTO;
import view.Fontes;

public class Inicializador {
	
	public static void main(String[] args) {
		alterarUI();
		
		String[] cidades = {"Sertânia", "Arcoverde"};
		String opcao = (String) JOptionPane.showInputDialog(null, "Qual é a cidade de acesso?", "Localização", 
												JOptionPane.QUESTION_MESSAGE, null, cidades, cidades[0]);
		
		if (opcao != null) {
			BancoDeDados.conectar(opcao);
			
			FuncLogadoController ctrl = new FuncLogadoController();
			FuncionarioDTO funcLog = ctrl.recuperar();
			
			if (funcLog != null) { // Verifica se existe algum funcionário logado
				if (funcLog.isManterLogin() == true) { // Confere se a opção de manter login foi selecionada
					if (funcLog.isAdmin() == true) { // Se o funcionário logado for um administrador, abre a tela de administrador
						new TelaDeFuncionarios();
						
					} else { // Se não, abre a tela de funcionário comum
						new TelaDeVendas();
					}
					
				} else { // Se a opção de manter login estiver desativada, então abre a tela de login
					ctrl.deslogar();
					new TelaDeLogin();
				}
			} else {
				new TelaDeLogin();
			}
		}
		
	}
	
	public static void alterarUI() {
		UIManager.put("ToolTip.foreground", new ColorUIResource(Color.BLACK));
		UIManager.put("ToolTip.background", new ColorUIResource(Color.WHITE));
		UIManager.put("ToolTip.font", new FontUIResource(new Font("Arial", Font.PLAIN, 12)));
		UIManager.put("ToolTip.border", new BorderUIResource(new LineBorder(Color.GRAY)));
		UIManager.put("TitledBorder.titleColor", new ColorUIResource(Color.lightGray));
		UIManager.put("ComboBox.background", new ColorUIResource(Cores.BLACK));
		UIManager.put("ComboBox.foreground", new ColorUIResource(Color.WHITE));
		UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Cores.AQUAMARINE));
		UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.WHITE));
		UIManager.put("Table.font", new FontUIResource(Fontes.ARIAL_14));
	}

}
