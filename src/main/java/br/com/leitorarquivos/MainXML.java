package br.com.leitorarquivos;

import br.com.leitorarquivos.model.LeitorXML;

public class MainXML {

	public static void main(String[] args) {
	
		LeitorXML leitor = new LeitorXML();
		leitor.lendoXML("arquivo.xml");
	}
}
