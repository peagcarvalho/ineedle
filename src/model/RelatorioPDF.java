package model;

import java.io.File;
import java.util.ArrayList;
import com.itextpdf.text.Rectangle;
import dto.VendaDTO;

public interface RelatorioPDF {
	
	public File gerarPDF(String nomeDoArquivo, ArrayList<String> paragrafos, Rectangle pageSize);
	
	public File gerarPDFComTabela(String nomeDoArquivo, VendaDTO dto);

}
