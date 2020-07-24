package view.panels;

import javax.swing.JFrame;
import view.Icones;

public class PainelDeFuncionario extends PainelDeMenu {

	public PainelDeFuncionario(JFrame frame) {
		super(frame);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		PainelDeFuncao clientes = new PainelDeFuncao(Icones.CLIENTS, "Clientes", 10, getFrame());
		clientes.setToolTipText("Clientes");
		add(clientes);
		
		PainelDeFuncao produtos = new PainelDeFuncao(Icones.BOX, "Produtos", 50, getFrame());
		produtos.setToolTipText("Produtos");
		add(produtos);
		
		PainelDeFuncao vendas = new PainelDeFuncao(Icones.BASKET, "Vendas", 90, getFrame());
		vendas.setToolTipText("Vendas");
		add(vendas);
	}

}
