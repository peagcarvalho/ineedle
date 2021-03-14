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
import controller.FuncionarioController;
import dto.FuncionarioDTO;
import dto.iterator.FuncionarioIterator;
import dto.iterator.Iterator;
import view.components.Label;

public class TelaDeFuncionarios extends TelaLogado {
	
	public TelaDeFuncionarios() {
		setVisible(true);
	}
	
	public void addComponentes() {
		super.addComponentes();
		
		addTabela();
		
		Label btAdd = new Label(Icones.ADD, 36, 36);
		btAdd.setBounds(928, 70, 36, 36);
		btAdd.setToolTipText("Adicionar funcionário");
		btAdd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				new PopUpAddFunc(getFrame()).setLocationRelativeTo(getFrame());
			}
			
		});
		add(btAdd);
		
		Label btRemove = new Label(Icones.REMOVE, 36, 36);
		btRemove.setBounds(928, 118, 36, 36);
		btRemove.setToolTipText("Remover funcionário");
		btRemove.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if (funcSel != null) {
					String mensagem = "Tem certeza que deseja excluir " + funcSel.getNome() + "?";
					int opcao = JOptionPane.showConfirmDialog(getFrame(), mensagem, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
					
					if (opcao == JOptionPane.YES_OPTION) {
						FuncionarioController ctrl = new FuncionarioController();
						ctrl.excluir(funcSel);
						
						new TelaDeFuncionarios().setLocationRelativeTo(getFrame());
						getFrame().dispose();
					}
				} else {
					JOptionPane.showMessageDialog(getFrame(), "Nenhum funcionário foi selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		add(btRemove);
	}
	
	private ArrayList<FuncionarioDTO> funcionarios;
	private DefaultTableModel modelo;
	private FuncionarioDTO funcSel; // funcionario selecionado
	
	public void addTabela() {
		modelo = new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Endereço");
		modelo.addColumn("Celular");
		modelo.addColumn("Sexo");
		modelo.addColumn("Senha");
		modelo.addColumn("É Administrador?");
		
		FuncionarioController funcCtrl = new FuncionarioController();
		funcionarios = funcCtrl.recuperarLista().getFuncionarios();
		funcionarios.remove(0);
		Iterator i = new FuncionarioIterator(funcionarios);
		
		while (i.hasNext()) {
			FuncionarioDTO func = (FuncionarioDTO) i.next();
			
			String str = null;
			if (func.isAdmin() == true) {
				str = "Sim";
			} else {
				str = "Não";
			}
			
			Object[] linha = {func.getId(), func.getNome() + " " + func.getSobrenome(), func.getEndereco(),
							  func.getNumTel(), func.getSexo(), func.getSenha(), str};
			
			modelo.addRow(linha);
		}
		
		JTable tabela = new JTable(modelo);
		tabela.setEnabled(false);
		
		tabela.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.rowAtPoint(arg0.getPoint());
				funcSel = funcionarios.get(row);
				
				if (arg0.getClickCount() == 2) {
					new PopUpDetalhesFunc(getFrame(), funcSel).setLocationRelativeTo(getFrame());
				}
			}
			
		});
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(60, 65, 850, 478);
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
							 "FUNCIONÁRIOS", TitledBorder.CENTER, TitledBorder.TOP);
		title.setTitleColor(Color.BLACK);
		painel.setBorder(title);
		add(painel);
	}

}
