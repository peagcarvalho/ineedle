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
import controller.ClienteController;
import dto.ClienteDTO;
import dto.iterator.ClienteIterator;
import dto.iterator.Iterator;
import view.components.Label;

public class TelaDeClientes extends TelaLogado {
	
	public TelaDeClientes() {
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		addTabela();
		
		Label btAdd = new Label(Icones.ADD, 36, 36);
		btAdd.setBounds(928, 70, 36, 36);
		btAdd.setToolTipText("Adicionar cliente");
		btAdd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				new PopUpAddCliente(getFrame()).setLocationRelativeTo(getFrame());
			}
			
		});
		add(btAdd);
		
		Label btRemove = new Label(Icones.REMOVE, 36, 36);
		btRemove.setBounds(928, 118, 36, 36);
		btRemove.setToolTipText("Remover cliente");
		btRemove.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if (clienteSel != null) {
					String mensagem = "Tem certeza que deseja excluir " + clienteSel.getNome() + "?";
					int opcao = JOptionPane.showConfirmDialog(getFrame(), mensagem, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
					
					if (opcao == JOptionPane.YES_OPTION) {
						ClienteController ctrl = new ClienteController();
						ctrl.excluir(clienteSel);
						
						new TelaDeClientes().setLocationRelativeTo(getFrame());
						getFrame().dispose();
					}
				} else {
					JOptionPane.showMessageDialog(getFrame(), "Nenhum cliente foi selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		add(btRemove);
	}
	
	private ArrayList<ClienteDTO> clientes;
	private DefaultTableModel modelo;
	private ClienteDTO clienteSel; // cliente selecionado
	
	public void addTabela() {
		modelo = new DefaultTableModel();
		
		modelo.addColumn("CPF");
		modelo.addColumn("Nome");
		modelo.addColumn("Endereço");
		modelo.addColumn("Data de Nascimento");
		modelo.addColumn("Celular");
		
		ClienteController clientCtrl = new ClienteController();
		clientes = clientCtrl.recuperarLista().getClientes();
		Iterator i = new ClienteIterator(clientes);
		
		while (i.hasNext()) {
			ClienteDTO c = (ClienteDTO) i.next();
			
			Object[] linha = {c.getCpf(), c.getNome() + " " + c.getSobrenome(), c.getEndereco(),
							  c.getDataNasc(), c.getNumTel()};
			
			modelo.addRow(linha);
		}
		
		JTable tabela = new JTable(modelo);
		tabela.setEnabled(false);
		
		tabela.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.rowAtPoint(arg0.getPoint());
				clienteSel = clientes.get(row);
				
				if (arg0.getClickCount() == 2) {
					new PopUpDetalhesCliente(getFrame(), clienteSel).setLocationRelativeTo(getFrame());
				}
			}
			
		});
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(60, 65, 850, 478);
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
							 "CLIENTES", TitledBorder.CENTER, TitledBorder.TOP);
		title.setTitleColor(Color.BLACK);
		painel.setBorder(title);
		add(painel);
	}

}
