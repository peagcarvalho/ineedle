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
import controller.VendaController;
import dto.FuncionarioDTO;
import dto.VendaDTO;
import dto.iterator.Iterator;
import dto.iterator.VendaIterator;
import view.components.Label;

public class TelaDeVendas extends TelaLogado {
	
	public TelaDeVendas() {
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		addTabela();
		
		Label btAdd = new Label(Icones.ADD, 36, 36);
		btAdd.setBounds(928, 70, 36, 36);
		btAdd.setToolTipText("Registrar venda");
		btAdd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				new TelaAddVenda().setLocationRelativeTo(getFrame());
				getFrame().dispose();
			}
			
		});
		add(btAdd);
		
		Label btRemove = new Label(Icones.REMOVE, 36, 36);
		btRemove.setBounds(928, 118, 36, 36);
		btRemove.setToolTipText("Apagar venda");
		btRemove.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if (vendaSel != null) {
					String mensagem = "Tem certeza que deseja excluir a venda de ID " + vendaSel.getId() + "?";
					int opcao = JOptionPane.showConfirmDialog(getFrame(), mensagem, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
					
					if (opcao == JOptionPane.YES_OPTION) {
						VendaController ctrl = new VendaController();
						ctrl.excluir(vendaSel);
						
						new TelaDeVendas().setLocationRelativeTo(getFrame());
						getFrame().dispose();
					}
				} else {
					JOptionPane.showMessageDialog(getFrame(), "Nenhuma venda foi selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		add(btRemove);
		
		Label btDown = new Label(Icones.DOWNLOAD, 36, 36);
		btDown.setBounds(928, 166, 36, 36);
		btDown.setToolTipText("Baixar relatório");
		btDown.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				/*String[] opcoes = {"Dia", "Mês", "Ano"};
				String opcao = (String) JOptionPane.showInputDialog(getFrame(), "Escolha uma opçao:", "Data", 
														JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				
				Iterator i = new VendaIterator(vendas);
				ArrayList<VendaDTO> vendasPorData = new ArrayList<>();
				
				if (vendas.size() > 0) {
					if (opcao != null) {
						String str = JOptionPane.showInputDialog(null, "Digite a data");
						
						if (opcao.equals("Dia")) {
							
							while (i.hasNext()) {
								VendaDTO vendaDTO = (VendaDTO) i.next();
								
								if (vendaDTO.getData().equals(str)) {
									vendasPorData.add(vendaDTO);
								}
							}
							
						} else if (opcao.equals("Mês")) {
							while (i.hasNext()) {
								VendaDTO vendaDTO = (VendaDTO) i.next();
								
								String[] data = str.split("/");
								String[] dataVenda = vendaDTO.getData().split("/");
								
								if (data[0].equals(dataVenda[1]) && data[1].equals(dataVenda[2])) {
									vendasPorData.add(vendaDTO);
								}
							}
							
							
						} else {
							
							while (i.hasNext()) {
								VendaDTO vendaDTO = (VendaDTO) i.next();
								
								String[] data = str.split("/");
								String[] dataVenda = vendaDTO.getData().split("/");
								
								if (data[0].equals(dataVenda[2])) {
									vendasPorData.add(vendaDTO);
								}
							}
						}
						
						VendaDTO dto = new VendaDTO();
						dto.setVendas(vendasPorData);
						dto.setDataRelatorio(str);
						
						VendaController ctrl = new VendaController();
						ctrl.vendasRealizadas(dto);
					}
				}*/
			
			}
		});
		add(btDown);
		
		FuncLogadoController ctrl = new FuncLogadoController();
		FuncionarioDTO dto = ctrl.recuperar();
		
		if (dto.isAdmin() == false) {
			btDown.setVisible(false);
		}
	}
	
	private ArrayList<VendaDTO> vendas;
	private DefaultTableModel modelo;
	private VendaDTO vendaSel;
	
	public void addTabela() {
		modelo = new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("CPF do Cliente");
		modelo.addColumn("Produto");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Valor");
		modelo.addColumn("Data");
		
		VendaController vendaCtrl = new VendaController();
		vendas = vendaCtrl.recuperarLista().getVendas();
		Iterator i = new VendaIterator(vendas);
		
		while (i.hasNext()) {
			VendaDTO vendaDTO = (VendaDTO) i.next();
				
			Object[] linha = {vendaDTO.getId(), vendaDTO.getCliente().getCpf(), vendaDTO.getProduto().getNome(), 
							  vendaDTO.getQuant(), vendaDTO.getValorTotal(), vendaDTO.getData()};
			
			modelo.addRow(linha);
		}
		
		JTable tabela = new JTable(modelo);
		tabela.setEnabled(false);
		tabela.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.rowAtPoint(arg0.getPoint());
				vendaSel = vendas.get(row);
				
				if (arg0.getClickCount() == 2) {
					new PopUpDetalhesVenda(getFrame(), vendaSel).setLocationRelativeTo(getFrame());
				}
			}
			
		});
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(60, 65, 850, 478);
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
							 "VENDAS", TitledBorder.CENTER, TitledBorder.TOP);
		title.setTitleColor(Color.BLACK);
		painel.setBorder(title);
		add(painel);
	}

}
