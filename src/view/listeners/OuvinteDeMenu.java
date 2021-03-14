package view.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import view.Cores;
import view.commands.Invoker;
import view.panels.PainelDeFuncao;

public class OuvinteDeMenu implements MouseListener {
	
	private PainelDeFuncao painel;
	private String texto;
	private JFrame frame;
	
	public OuvinteDeMenu(PainelDeFuncao painel, String texto, JFrame frame) {
		this.painel = painel;
		this.texto = texto;
		this.frame = frame;
	}
	
	public void mouseEntered(MouseEvent arg0) {
		try {
			Thread.sleep(70);
		} catch (InterruptedException e) {}
		painel.setBackground(Cores.AQUAMARINE);
		painel.repaint();
	}

	public void mouseExited(MouseEvent arg0) {
		try {
			Thread.sleep(70);
		} catch (InterruptedException e) {}
		painel.setBackground(Cores.BLACKER);
		painel.repaint();
	}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

	public void mouseClicked(MouseEvent arg0) {
		Invoker invocador = new Invoker();
		
		invocador.invocar(texto, frame);
	}

}