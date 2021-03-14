package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import dto.VendaDTO;
import view.components.Label;
import view.components.TextField;

public class PopUpDetalhesVenda extends TelaPopUp {
	
	public PopUpDetalhesVenda(JFrame telaBase, VendaDTO vendaSel) {
		super(telaBase);
		addComponentes(vendaSel);
		setVisible(true);
	}
	
	public void addComponentes(VendaDTO vendaSel) {
		Label lbCliente = new Label("Cliente", 15);
		lbCliente.setBounds(58, 95, 100, 30);
		add(lbCliente);
		
		TextField tfCPF = new TextField("CPF");
		tfCPF.setBounds(58, 135, 200, 45);
		tfCPF.setEnabled(false);
		add(tfCPF);
		
		TextField tfNome = new TextField("Nome");
		tfNome.setBounds(268, 135, 200, 45);
		tfNome.setEnabled(false);
		add(tfNome);
		
		TextField tfSobrenome = new TextField("Sobrenome");
		tfSobrenome.setBounds(478, 135, 200, 45);
		tfSobrenome.setEnabled(false);
		add(tfSobrenome);
		
		Label lbProd = new Label("Produto Vendido", 15);
		lbProd.setBounds(58, 200, 200, 30);
		add(lbProd);
		
		TextField tfCod = new TextField("Código");
		tfCod.setBounds(58, 240, 150, 45);
		tfCod.setEnabled(false);
		add(tfCod);
		
		TextField tfProd = new TextField("Produto");
		tfProd.setBounds(218, 240, 250, 45);
		tfProd.setEnabled(false);
		add(tfProd);
		
		TextField tfMarca = new TextField("Marca");
		tfMarca.setBounds(478, 240, 200, 45);
		tfMarca.setEnabled(false);
		add(tfMarca);
		
		TextField tfQuant = new TextField("Quantidade");
		tfQuant.setBounds(58, 300, 150, 45);
		tfQuant.setEnabled(false);
		add(tfQuant);
		
		TextField tfValor = new TextField("Valor");
		tfValor.setBounds(218, 300, 150, 45);
		tfValor.setEnabled(false);
		add(tfValor);
		
		// SETA OS ATRIBUTOS NOS TEXTFIELDS
			tfCPF.setText(vendaSel.getCliente().getCpf());
			tfNome.setText(vendaSel.getCliente().getNome());
			tfSobrenome.setText(vendaSel.getCliente().getSobrenome());
			tfCod.setText(Integer.toString(vendaSel.getProduto().getCodigo()));
			tfProd.setText(vendaSel.getProduto().getNome());
			tfMarca.setText(vendaSel.getProduto().getMarca());
			tfQuant.setText(Integer.toString(vendaSel.getQuant()));
			tfValor.setText(Float.toString(vendaSel.getValorTotal()));
		
		Label lbDetalhes = new Label("DETALHES DA VENDA", 18);
		lbDetalhes.setBounds(0, 35, 750, 45);
		lbDetalhes.setHorizontalAlignment(JLabel.CENTER);
		lbDetalhes.setBackground(Cores.AQUAMARINE);
		lbDetalhes.setOpaque(true);
		add(lbDetalhes);
	}
	
}
