package br.com.leitor_arquivos;

import br.com.leitor_arquivos.model.LeitorJSON;

public class MainJSON {

	public static void main(String[] args) {

		LeitorJSON leitor = new LeitorJSON();
		leitor.lendoJSON("teste.json");
	}

}
