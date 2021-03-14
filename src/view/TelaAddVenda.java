package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import dto.ClienteDTO;
import dto.ProdutoDTO;
import dto.VendaDTO;
import model.GeradorDeRelatorioFacade;
import model.Validacao;
import model.exceptions.CPFInvalidoException;
import model.exceptions.TextoInvalidoException;
import view.components.Label;
import view.components.PainelCliente;
import view.components.TextField;
import view.components.TextFieldFormatado;
import view.Cores;

public class TelaAddVenda extends TelaLogado {
	
	public TelaAddVenda() {
		setVisible(true);
	}
	
	private TextFieldFormatado cpf;
	
	public void addComponentes() {
		super.addComponentes();
		
		PainelCliente painelC = new PainelCliente();
		painelC.setVisible(false);
		add(painelC);
		
		JPanel painel = new JPanel();
		painel.setBackground(Cores.BLACK);
		painel.setBorder(new LineBorder(Color.WHITE));
		painel.setBounds(83, 70, 220, 60);
		painel.setToolTipText("Cliente escolhido");
		add(painel);
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			cpf = new TextFieldFormatado("CPF", mask);
		} catch (ParseException e) {}
		cpf.setBounds(380, 70, 240, 55);
		cpf.setToolTipText("CPF do Cliente");
		cpf.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				try {
					Validacao.verificarEspacos(cpf.getText());
					
					ClienteDTO dto = new ClienteDTO();
					dto.setCpf(cpf.getText());
					
					ClienteController ctrl = new ClienteController();
					dto = ctrl.buscar(dto);
					
					if (dto != null) {
						painelC.atualizarDados(dto);
					}
				} catch (TextoInvalidoException e) {
					painelC.setVisible(false);
				}
			}
			
			public void keyReleased(KeyEvent arg0) {}
			
			public void keyPressed(KeyEvent arg0) {}
		});
		add(cpf);
		
		addTabela();
		
		tfCod = new TextField("Código");
		tfCod.setBounds(580, 210, 100, 45);
		tfCod.setEnabled(false);
		tfCod.setToolTipText("Código do produto");
		add(tfCod);
		
		tfProd = new TextField("Produto");
		tfProd.setBounds(690, 210, 240, 45);
		tfProd.setEnabled(false);
		add(tfProd);
		
		tfQuant = new TextField("Quantidade");
		tfQuant.setBounds(580, 270, 115, 45);
		add(tfQuant);
		
		tfValor = new TextField("Valor Total");
		tfValor.setBounds(705, 270, 130, 45);
		tfValor.setEnabled(false);
		add(tfValor);
		
		Label lbReg = new Label("Registrar", 16);
		lbReg.criarBotao();
		lbReg.setBounds(700, 80, 205, 40);
		lbReg.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				if (produtoSel != null) {
					try {
						Validacao.verificarEspacos(cpf.getText());
						
						try {
							Validacao.verificarCPF(cpf.getText());
							
							JOptionPane.showMessageDialog(getFrame(), "CPF não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
						} catch (CPFInvalidoException e) {
							VendaDTO dto = new VendaDTO();
							dto.setQuant(Integer.parseInt(tfQuant.getText()));
							
							ClienteDTO dto2 = new ClienteDTO();
							dto2.setCpf(cpf.getText());
							
							ProdutoDTO dto3 = new ProdutoDTO();
							dto3.setCodigo(produtoSel.getCodigo());
							
							dto.setCliente(dto2);
							dto.setProduto(dto3);
							
							VendaController ctrl = new VendaController();
							ctrl.cadastrar(dto);
							
							new TelaDeVendas().setLocationRelativeTo(getFrame());
							getFrame().dispose();

							ctrl.gerarNotaFiscal(dto);
						}
					} catch (TextoInvalidoException e1) {
						JOptionPane.showMessageDialog(getFrame(), "CPF não foi preenchido corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(getFrame(), "Nenhum produto foi selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		add(lbReg);
		
		Label btReset = new Label(Icones.DELETE, 30, 30);
		btReset.setHorizontalAlignment(JLabel.CENTER);
		btReset.setToolTipText("Cancelar venda");
		btReset.setBounds(865, 160, 30, 30);
		btReset.setOpaque(true);
		btReset.setBackground(Cores.BLACK);
		btReset.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				tfCod.setText("");
				tfProd.setText("");
				tfQuant.setText("");
				tfQuant.setEnabled(true);
				tfValor.setText("");
				cpf.setText("");
				produtoSel = null;
				painelC.setVisible(false);
			}
			
		});
		add(btReset);
		
		Label lbDetalhes = new Label("DETALHES DA VENDA", 18);
		lbDetalhes.setBounds(548, 157, 420, 35);
		lbDetalhes.setHorizontalAlignment(JLabel.CENTER);
		add(lbDetalhes);
	}
	
	private DefaultTableModel modelo;
	private ArrayList<ProdutoDTO> produtos;
	private ProdutoDTO produtoSel; // produto selecionado
	private TextField tfCod;
	private TextField tfProd;
	private TextField tfQuant;
	private TextField tfValor;
	
	public void addTabela() {
		modelo = new DefaultTableModel();
		
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("Marca");
		modelo.addColumn("Preço");
		modelo.addColumn("Estoque");
		
		ProdutoController prodControl = new ProdutoController();
		produtos = prodControl.listaEstoqueValido().getProdutos();
		
		if (produtos.size() > 0) {
			for(ProdutoDTO prod : produtos) {
				
				Object[] linha = {prod.getCodigo(), prod.getNome(), prod.getMarca(),
								  prod.getPreco(), prod.getEstoque()};
				
				modelo.addRow(linha);
			}
		}
		
		JTable tabela = new JTable(modelo);
		tabela.setEnabled(false);
		tabela.setToolTipText("Selecione um produto");
		tabela.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					if (!(tfQuant.getText().contains(" ") || tfQuant.getText().equals(""))) {
						int quant = Integer.parseInt(tfQuant.getText());
						
						if (produtoSel == null) {
							int row = tabela.rowAtPoint(arg0.getPoint());
							produtoSel = produtos.get(row);
							
							if (produtoSel.getEstoque() >= quant) {
								
								
								tfCod.setText(Integer.toString(produtoSel.getCodigo()));
								tfProd.setText(produtoSel.getNome());
								tfQuant.setEnabled(false);
								float valorTotal = produtoSel.getPreco() * quant;
								tfValor.setText(Float.toString(valorTotal));
							} else {
								JOptionPane.showMessageDialog(getFrame(), "A quantidade ultrapassa o estoque disponível", "Erro", JOptionPane.ERROR_MESSAGE);
								produtoSel = null;
							}
							
						} else {
							JOptionPane.showMessageDialog(getFrame(), "Você já selecionou um produto", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(getFrame(), "Você não digitou a quantidade", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			
		});
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(83, 157, 450, 380);
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				 			 "Produtos", TitledBorder.CENTER, TitledBorder.TOP);
		title.setTitleColor(Color.BLACK);
		painel.setBorder(title);
		add(painel);
	}

}
