package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controller.ProdutoController;
import dto.ProdutoDTO;
import view.components.Label;
import view.components.TextArea;
import view.components.TextField;

public class PopUpAddProduto extends TelaPopUp {
	
	public PopUpAddProduto(JFrame telaBase) {
		super(telaBase);
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		Label lbAdd = new Label("ADICIONAR PRODUTO", 18);
		lbAdd.setBounds(0, 35, 750, 45);
		lbAdd.setHorizontalAlignment(JLabel.CENTER);
		lbAdd.setBackground(Cores.AQUAMARINE);
		lbAdd.setOpaque(true);
		add(lbAdd);
		
		TextField tfNome = new TextField("Nome");
		tfNome.setBounds(50, 120, 200, 45);
		add(tfNome);
		
		TextField tfPreco = new TextField("Preço");
		tfPreco.setBounds(260, 120, 100, 45);
		add(tfPreco);
		
		TextField tfMarca = new TextField("Marca");
		tfMarca.setBounds(50, 180, 150, 45);
		add(tfMarca);
		
		TextField tfCategoria = new TextField("Categoria");
		tfCategoria.setBounds(210, 180, 150, 45);
		add(tfCategoria);
		
		TextField tfEstoque = new TextField("Estoque");
		tfEstoque.setBounds(50, 240, 150, 45);
		add(tfEstoque);
		
		TextArea taDesc = new TextArea("Descrição");
		taDesc.setBounds(390, 120, 300, 230);
		add(taDesc);
		
		Label btAdd = new Label("Adicionar", 16);
		btAdd.setBounds(125, 310, 160, 38);
		btAdd.criarBotao();
		btAdd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				ProdutoDTO dto = new ProdutoDTO();
				
				dto.setNome(tfNome.getText());
				dto.setPreco(Float.parseFloat(tfPreco.getText()));
				dto.setMarca(tfMarca.getText());
				dto.setCategoria(tfCategoria.getText());
				dto.setEstoque(Integer.parseInt(tfEstoque.getText()));
				dto.setDescricao(taDesc.getText());
				
				ProdutoController ctrl = new ProdutoController();
				ctrl.cadastrar(dto);
				
				getFrame().dispose();
				new TelaDeProdutos().setLocationRelativeTo(getTelaBase());
				getTelaBase().dispose();
			}
			
		});
		add(btAdd);
	}

}
