package view.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OuvinteDeLetras implements KeyListener {

	public void keyPressed(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if (Character.isLetter(c) == true) {
			arg0.consume();
		}
	}

}
