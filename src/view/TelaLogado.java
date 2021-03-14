package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.FuncLogadoController;
import dto.FuncionarioDTO;
import view.panels.BarraSuperior;
import view.panels.PainelDeAdmin;
import view.panels.PainelDeFuncionario;
import view.panels.PainelDeMenu;

public class TelaLogado extends Tela {
	
	public TelaLogado() {
		addComponentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private boolean menuAberto = false;
	public PainelDeMenu menu;
	
	public void addComponentes() {
		FuncLogadoController ctrl = new FuncLogadoController();
		FuncionarioDTO funcLog = ctrl.recuperar();
		
		if (funcLog.isAdmin()) {
			menu = new PainelDeAdmin(this);
		} else {
			menu = new PainelDeFuncionario(this);
		}
		add(menu);
		
		JPanel painelSemCor = new JPanel();
		painelSemCor.setBounds(200, 45, 800, 520);
		painelSemCor.setOpaque(false);
		painelSemCor.setVisible(false);
		painelSemCor.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				menu.setSize(42, 520);
				painelSemCor.setVisible(false);
			}
			
		});
		add(painelSemCor);
		
		BarraSuperior barra = new BarraSuperior();
		barra.getLbMenu().addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {}
			
			public void mouseEntered(MouseEvent arg0) {}
			
			public void mouseClicked(MouseEvent arg0) {
				if (menuAberto == false) {
					menu.setSize(200, 520);
					painelSemCor.setVisible(true);
					menuAberto = true;
				} else {
					menu.setSize(42, 520);
					painelSemCor.setVisible(false);
					menuAberto = false;
				}
			}
		});
		add(barra);
	}

}
