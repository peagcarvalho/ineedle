package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import view.Cores;

public class TextField extends JTextField {
	
	public TextField(String title) {
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setBackground(Cores.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 15));
		setHorizontalAlignment(JTextField.CENTER);
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder(title);
		setBorder(new CompoundBorder(titleBorder, null));
		
		addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent arg0) {
				titleBorder.setTitleColor(Color.LIGHT_GRAY);
				titleBorder.setBorder(new LineBorder(Color.LIGHT_GRAY));
				repaint();
			}
			
			public void focusGained(FocusEvent arg0) {
				titleBorder.setTitleColor(Cores.AQUAMARINE);
				titleBorder.setBorder(new LineBorder(Cores.AQUAMARINE));
				repaint();
			}
		});
	}

}
