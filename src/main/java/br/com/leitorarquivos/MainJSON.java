package br.com.leitorarquivos;

import br.com.leitorarquivos.model.LeitorJSON;

public class MainJSON {

	public static void main(String[] args) {

		LeitorJSON leitor = new LeitorJSON();
		leitor.lendoJSON("teste.json");
	}

}
