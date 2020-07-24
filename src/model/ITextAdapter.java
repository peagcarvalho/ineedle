package model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.VendaDTO;
import dto.iterator.Iterator;
import dto.iterator.VendaIterator;
import view.Icones;

public class ITextAdapter implements RelatorioPDF {

	public File gerarPDF(String nomeDoArquivo, ArrayList<String> paragrafos, Rectangle pageSize) {
		Document doc = new Document(pageSize);
		String arquivo = nomeDoArquivo + ".pdf";
		
        try {
            OutputStream output = new FileOutputStream(nomeDoArquivo + ".pdf");
            PdfWriter.getInstance(doc, output);
            
            doc.open();
            
            Font fonteTitulo = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font fontePadrao = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
            
			try {
				Image figura = Image.getInstance(Icones.LOGO.getImage(), Color.WHITE);
				figura.setAlignment(Element.ALIGN_CENTER);
				doc.add(figura);
			} catch (IOException e) {} 
            
            Paragraph titulo = new Paragraph(paragrafos.get(0).toUpperCase(), fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);
            doc.add(new Paragraph(" "));
            
            for(int i = 1; i < paragrafos.size(); i++) {
            	Paragraph paragrafo = null;
            	
            	if (paragrafos.get(i).contains("*")) {
            		paragrafo = new Paragraph(paragrafos.get(i).replace("*", ""), fonteTitulo);
            		doc.add(new Paragraph(" "));
            	} else {
            		paragrafo = new Paragraph(paragrafos.get(i), fontePadrao);
            	}
            	
            	doc.add(new Paragraph(paragrafo));
            }
            
            doc.close();
        } catch (FileNotFoundException ex) {} catch (DocumentException ex) {}
        
        return new File(arquivo);
	}

	public File gerarPDFComTabela(String nomeDoArquivo, VendaDTO vendaDTO) {
		Document doc = new Document(PageSize.A4);
		String arquivo = nomeDoArquivo + ".pdf";
		
		try {
            OutputStream output = new FileOutputStream(nomeDoArquivo + ".pdf");
            PdfWriter.getInstance(doc, output);
            
            doc.open();
            
            Font fonteTitulo = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font fontePadrao = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
            
			try {
				Image figura = Image.getInstance(Icones.LOGO.getImage(), Color.WHITE);
				figura.setAlignment(Element.ALIGN_CENTER);
				doc.add(figura);
			} catch (IOException e) {} 
            
            Paragraph titulo = new Paragraph("CONTABILIDADE (" + vendaDTO.getDataRelatorio() + ")", fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);
            doc.add(new Paragraph(" "));
            
            PdfPTable tabela = new PdfPTable(new float[] {5f, 15f, 8f, 10f, 8f});
            
            String[] colunas = {"ID da Venda", "Produto Vendido", "Marca", "Quantidade", "Lucro"};
            for(int i = 0; i < 5; i++) {
	            PdfPCell coluna = new PdfPCell(new Phrase(colunas[i]));
	            coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
	            coluna.setBackgroundColor(BaseColor.GRAY);
	            
	            tabela.addCell(coluna);
            }
            
    		Iterator i = new VendaIterator(vendaDTO.getVendas());
    		float lucro = 0;
    		
    		while (i.hasNext()) {
    			VendaDTO dto = (VendaDTO) i.next();
    			lucro += dto.getValorTotal();
    			
    			tabela.addCell(new PdfPCell(new Phrase(dto.getId() + "")));
    			tabela.addCell(new PdfPCell(new Phrase(dto.getProduto().getNome())));
    			tabela.addCell(new PdfPCell(new Phrase(dto.getProduto().getMarca())));
    			tabela.addCell(new PdfPCell(new Phrase(dto.getQuant() + "")));
    			tabela.addCell(new PdfPCell(new Phrase(dto.getValorTotal() + "")));
    		}

    		doc.add(tabela);
    		
    		doc.add(new Paragraph(" "));
    		doc.add(new Paragraph("Lucro Total: " + lucro));
            
            doc.close();
        } catch (FileNotFoundException ex) {} catch (DocumentException ex) {}
        
        return new File(arquivo);
	}
}