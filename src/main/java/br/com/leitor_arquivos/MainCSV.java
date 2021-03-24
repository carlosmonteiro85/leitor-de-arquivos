package br.com.leitor_arquivos;

import br.com.leitor_arquivos.model.LeitorCSV;

public class MainCSV {

	public static void main(String[] args) {
		

		LeitorCSV leitorCsv = new LeitorCSV();
		
		leitorCsv.lendoCSV("nomes.csv");

	}

}
