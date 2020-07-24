package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.VendaController;
import dto.VendaDTO;
import dto.iterator.Iterator;
import dto.iterator.VendaIterator;
import view.components.Label;

public class TelaContabilidade extends TelaLogado {
	
	private VendaDTO dto;
	
	public TelaContabilidade(VendaDTO dto) {
		this.dto = dto;
		
		addTitulo();
		addTabela();
		
		setVisible(true);
	}
	
	public void addTitulo() {
		String str = "CONTABILIDADE (" + dto.getDataRelatorio() + ")";
		Label lb1 = new Label(str, 18);
		lb1.setBounds(60, 45, 940, 50);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		add(lb1);
		
		Label btDown = new Label(Icones.DOWNLOAD, 36, 36);
		btDown.setBounds(680, 55, 36, 36);
		btDown.setToolTipText("Baixar relatório");
		btDown.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if (dto.getVendas().size() > 0) {
					VendaController ctrl = new VendaController();
					ctrl.contabilidade(dto);
					
				} else {
					JOptionPane.showMessageDialog(getFrame(), "Nenhuma venda foi registrado nessa data. O relatório não pode ser criado",
												  "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		add(btDown);
	}
	
	private DefaultTableModel modelo;
	
	public void addTabela() {
		modelo = new DefaultTableModel();
		
		modelo.addColumn("ID da Venda");
		modelo.addColumn("Produto Vendido");
		modelo.addColumn("Marca");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Lucro");

		JTable tabela = new JTable(modelo);
		tabela.setEnabled(false);
		
		// PREENCHE A TABELA
		preencherTabela();
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(60, 100, 900, 450);
		add(painel);
	}
	
	public void preencherTabela() {
		Iterator i = new VendaIterator(dto.getVendas());
		
		while (i.hasNext()) {
			VendaDTO vendaDTO = (VendaDTO) i.next();
			
			Object[] linha = {vendaDTO.getId(), vendaDTO.getProduto().getNome(), vendaDTO.getQuant(), 
							  vendaDTO.getProduto().getMarca(), vendaDTO.getValorTotal()};
	
			modelo.addRow(linha);
		}
	
	}

}
