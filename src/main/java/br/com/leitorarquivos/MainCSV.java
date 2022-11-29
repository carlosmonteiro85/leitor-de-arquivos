package br.com.leitorarquivos;

import br.com.leitorarquivos.model.LeitorCSV;

public class MainCSV {

	public static void main(String[] args) {
		

		LeitorCSV leitorCsv = new LeitorCSV();
		
		leitorCsv.lendoCSV("nomes.csv");

	}

}
