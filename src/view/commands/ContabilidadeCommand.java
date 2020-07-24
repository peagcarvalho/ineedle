package view.commands;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controller.VendaController;
import dto.VendaDTO;
import dto.iterator.Iterator;
import dto.iterator.VendaIterator;
import view.TelaContabilidade;

public class ContabilidadeCommand implements Command {

	public void executar(JFrame frame) {
		String[] opcoes = {"Dia", "Mês", "Ano"};
		String opcao = (String) JOptionPane.showInputDialog(frame, "Escolha uma opçao:", "Data", 
												JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		
		VendaController ctrl = new VendaController();
		ArrayList<VendaDTO> vendas = ctrl.recuperarLista().getVendas();
		
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
				
				new TelaContabilidade(dto).setLocationRelativeTo(frame);
				frame.dispose();
			}
		}
	}

}
