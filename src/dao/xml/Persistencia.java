package dao.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia {
	
	static XStream stream = new XStream(new DomDriver());
	
	public static void salvar(ArrayList<String> atributos, String nomeDoArquivo) {
		File arquivo = new File(nomeDoArquivo + ".xml");
		
		String xml = stream.toXML(atributos);
		
		try {
	        if (arquivo.exists() == false) {
	            arquivo.createNewFile();
	        }
	        
	        PrintWriter salvar = new PrintWriter(arquivo);
	        salvar.print(xml);
	        salvar.close();
	        
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

	public static ArrayList<String> recuperar(String nomeDoArquivo) {
		File arquivo = new File(nomeDoArquivo + ".xml");
		
		try {
	        if (arquivo.exists()) {
	            FileInputStream fileInStream = new FileInputStream(arquivo);
	            return (ArrayList<String>) stream.fromXML(arquivo);
	        }
	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    
		return new ArrayList<>();
	}

}
