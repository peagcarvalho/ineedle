package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.itextpdf.text.PageSize;
import dto.VendaDTO;
import dto.iterator.Iterator;
import dto.iterator.VendaIterator;

public class GeradorDeRelatorioFacade {

	 public static void notaFiscal(VendaDTO vendaDTO) {
		 String nomeDoArquivo = "nota fiscal";
		 ArrayList<String> paragrafos = new ArrayList<>();
		 
		 paragrafos.add("Nota Fiscal");
		 
		 paragrafos.add("*Produto comprado*");
		 paragrafos.add(vendaDTO.toString());
		 paragrafos.add("Valor total: " + vendaDTO.getValorTotal());
		 paragrafos.add("*Descrição do produto*");
		 paragrafos.add(vendaDTO.getProduto().getDescricao());
 
		 paragrafos.add("*Cliente*");
		 paragrafos.add(vendaDTO.getCliente().toString());
		 
		 RelatorioPDF relatorio = new ITextAdapter();
		 File pdf = relatorio.gerarPDF(nomeDoArquivo, paragrafos, PageSize.A4);
		 
		 try {
			java.awt.Desktop.getDesktop().open(pdf);
		} catch (IOException e) {}
	}
	 
	public static void contabilidade(VendaDTO dto) {
		String nomeDoArquivo = "contabilidade " + dto.getData();
		
		RelatorioPDF relatorio = new ITextAdapter();
		File pdf = relatorio.gerarPDFComTabela(nomeDoArquivo, dto);
		 
		try {
			java.awt.Desktop.getDesktop().open(pdf);
		} catch (IOException e) {}
	}
	
}
