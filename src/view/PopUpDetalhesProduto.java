package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controller.FuncLogadoController;
import controller.ProdutoController;
import dto.FuncionarioDTO;
import dto.ProdutoDTO;
import view.components.Label;
import view.components.TextArea;
import view.components.TextField;

public class PopUpDetalhesProduto extends TelaPopUp {
	
	public PopUpDetalhesProduto(JFrame telaBase, ProdutoDTO produtoSel) {
		super(telaBase);
		addComponentes(produtoSel);
		setVisible(true);
	}
	
	private Label lbDetalhes;
	
	public void addComponentes(ProdutoDTO produtoSel) {
		super.addComponentes();
		
		TextField tfNome = new TextField("Nome");
		tfNome.setBounds(50, 120, 200, 45);
		tfNome.setEnabled(false);
		add(tfNome);
		
		TextField tfPreco = new TextField("Preço");
		tfPreco.setBounds(260, 120, 100, 45);
		tfPreco.setEnabled(false);
		add(tfPreco);
		
		TextField tfMarca = new TextField("Marca");
		tfMarca.setBounds(50, 180, 150, 45);
		tfMarca.setEnabled(false);
		add(tfMarca);
		
		TextField tfCategoria = new TextField("Categoria");
		tfCategoria.setBounds(210, 180, 150, 45);
		tfCategoria.setEnabled(false);
		add(tfCategoria);
		
		TextField tfEstoque = new TextField("Estoque");
		tfEstoque.setBounds(50, 240, 150, 45);
		tfEstoque.setEnabled(false);
		add(tfEstoque);
		
		TextArea taDesc = new TextArea("Descrição");
		taDesc.setBounds(390, 120, 300, 230);
		taDesc.setEnabled(false);
		add(taDesc);
		
		// SETA OS ATRIBUTOS NOS TEXTFIELDS
			tfNome.setText(produtoSel.getNome());
			tfPreco.setText(Float.toString(produtoSel.getPreco()));
			tfMarca.setText(produtoSel.getMarca());
			tfCategoria.setText(produtoSel.getCategoria());
			tfEstoque.setText(Integer.toString(produtoSel.getEstoque()));
			taDesc.setText(produtoSel.getDescricao());
		
		Label btSave = new Label("Salvar", 16);
		btSave.setBounds(125, 310, 160, 38);
		btSave.criarBotao();
		btSave.setVisible(false);
		btSave.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				produtoSel.setNome(tfNome.getText());
				produtoSel.setPreco(Float.parseFloat(tfPreco.getText()));
				produtoSel.setMarca(tfMarca.getText());
				produtoSel.setCategoria(tfCategoria.getText());
				produtoSel.setEstoque(Integer.parseInt(tfEstoque.getText()));
				produtoSel.setDescricao(taDesc.getText());
				
				ProdutoController ctrl = new ProdutoController();
				ctrl.atualizar(produtoSel);
				
				getFrame().dispose();
				new TelaDeProdutos().setLocationRelativeTo(getTelaBase());
				getTelaBase().dispose();
			}
			
		});
		add(btSave);
		
		Label btEdit = new Label(Icones.EDIT, 36, 36);
		btEdit.setBounds(505, 40, 36, 36);
		btEdit.setToolTipText("Editar");
		btEdit.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				lbDetalhes.setText("EDITAR PRODUTO");
				tfNome.setEnabled(true);
				tfPreco.setEnabled(true);
				tfMarca.setEnabled(true);
				tfCategoria.setEnabled(true);
				tfEstoque.setEnabled(true);
				taDesc.setEnabled(true);
				btSave.setVisible(true);
			}
			
		});
		add(btEdit);
		
		FuncLogadoController ctrl = new FuncLogadoController();
		FuncionarioDTO funcLogado = ctrl.recuperar();
		
		if (funcLogado.isAdmin() == false) {
			btEdit.setVisible(false);
		}
		
		lbDetalhes = new Label("DETALHES DO PRODUTO", 18);
		lbDetalhes.setBounds(0, 35, 750, 45);
		lbDetalhes.setHorizontalAlignment(JLabel.CENTER);
		lbDetalhes.setBackground(Cores.AQUAMARINE);
		lbDetalhes.setOpaque(true);
		add(lbDetalhes);
	}

}
