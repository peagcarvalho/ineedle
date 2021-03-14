package view.panels;

import javax.swing.JFrame;
import view.Icones;

public class PainelDeAdmin extends PainelDeMenu {

	public PainelDeAdmin(JFrame frame) {
		super(frame);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		/*PainelDeFuncao inicio = new PainelDeFuncao(Icones.HOME, "Início", 10, getFrame());
		inicio.setToolTipText("Início");
		add(inicio);*/
		
		PainelDeFuncao funcionarios = new PainelDeFuncao(Icones.STAFF, "Funcionários", 10, getFrame());
		funcionarios.setToolTipText("Funcionários");
		add(funcionarios);
		
		PainelDeFuncao clientes = new PainelDeFuncao(Icones.CLIENTS, "Clientes", 50, getFrame());
		clientes.setToolTipText("Clientes");
		add(clientes);
		
		PainelDeFuncao produtos = new PainelDeFuncao(Icones.BOX, "Produtos", 90, getFrame());
		produtos.setToolTipText("Produtos");
		add(produtos);
		
		PainelDeFuncao vendas = new PainelDeFuncao(Icones.BASKET, "Vendas", 130, getFrame());
		vendas.setToolTipText("Vendas");
		add(vendas);
		
		PainelDeFuncao contab = new PainelDeFuncao(Icones.COIN, "Contabilidade", 170, getFrame());
		contab.setToolTipText("Contabilidade");
		add(contab);
	}

}
