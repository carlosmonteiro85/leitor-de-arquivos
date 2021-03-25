package br.com.leitor_arquivos;

import br.com.leitor_arquivos.model.LeitorXML;

public class MainXML {

	public static void main(String[] args) {
	
		LeitorXML leitor = new LeitorXML();
		leitor.lendoXML("arquivo.xml");
	}
}
