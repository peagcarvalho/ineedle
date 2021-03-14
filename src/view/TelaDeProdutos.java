package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import controller.FuncLogadoController;
import controller.ProdutoController;
import dto.FuncionarioDTO;
import dto.ProdutoDTO;
import dto.iterator.Iterator;
import dto.iterator.ProdutoIterator;
import view.components.Label;

public class TelaDeProdutos extends TelaLogado {
	
	public TelaDeProdutos() {
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		addTabela();
		
		Label btAdd = new Label(Icones.ADD, 36, 36);
		btAdd.setBounds(928, 70, 36, 36);
		btAdd.setToolTipText("Adicionar produto");
		btAdd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				new PopUpAddProduto(getFrame()).setLocationRelativeTo(getFrame());
			}
			
		});
		add(btAdd);
		
		Label btRemove = new Label(Icones.REMOVE, 36, 36);
		btRemove.setBounds(928, 118, 36, 36);
		btRemove.setToolTipText("Remover produto");
		btRemove.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if (produtoSel != null) {
					String mensagem = "Tem certeza que deseja excluir " + produtoSel.getNome() + "?";
					int opcao = JOptionPane.showConfirmDialog(getFrame(), mensagem, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
					
					if (opcao == JOptionPane.YES_OPTION) {
						ProdutoController ctrl = new ProdutoController();
						ctrl.excluir(produtoSel);
						
						new TelaDeProdutos().setLocationRelativeTo(getFrame());
						getFrame().dispose();
					}
				} else {
					JOptionPane.showMessageDialog(getFrame(), "Nenhum produto foi selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		add(btRemove);
		
		FuncLogadoController ctrl = new FuncLogadoController();
		FuncionarioDTO funcLog = ctrl.recuperar();
		
		if (funcLog.isAdmin() == false) {
			btAdd.setVisible(false);
			btRemove.setVisible(false);
		}
		
	}
	
	private ArrayList<ProdutoDTO> produtos;
	private DefaultTableModel modelo;
	private ProdutoDTO produtoSel; // produto selecionado
	private JScrollPane painel;
	
	public void addTabela() {
		modelo = new DefaultTableModel();
		
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("Preço");
		modelo.addColumn("Marca");
		modelo.addColumn("Categoria");
		modelo.addColumn("Descrição");
		
		ProdutoController prodControl = new ProdutoController();
		produtos = prodControl.recuperarLista().getProdutos();
		Iterator i = new ProdutoIterator(produtos);
		
		while (i.hasNext()) {
			ProdutoDTO prod = (ProdutoDTO) i.next();
				
				Object[] linha = {prod.getCodigo(), prod.getNome(), prod.getPreco(), prod.getMarca(),
								  prod.getCategoria(), prod.getDescricao()};
				
				modelo.addRow(linha);
		}
		
		JTable tabela = new JTable(modelo);
		tabela.setEnabled(false);
		tabela.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.rowAtPoint(arg0.getPoint());
				produtoSel = produtos.get(row);
				
				if (arg0.getClickCount() == 2) {
					new PopUpDetalhesProduto(getFrame(), produtoSel).setLocationRelativeTo(getFrame());
				}
			}
			
		});
		
		FuncLogadoController ctrl = new FuncLogadoController();
		FuncionarioDTO funcLog = ctrl.recuperar();
		
		JScrollPane painel = new JScrollPane(tabela);
		if (funcLog.isAdmin() == true) {
			painel.setBounds(60, 65, 850, 478);
		} else {
			painel.setBounds(60, 65, 880, 478);
		}
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
							 "PRODUTOS", TitledBorder.CENTER, TitledBorder.TOP);
		title.setTitleColor(Color.BLACK);
		painel.setBorder(title);
		add(painel);
	}

}
