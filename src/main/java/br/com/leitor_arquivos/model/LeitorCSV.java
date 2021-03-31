package br.com.leitor_arquivos.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {

	public void lendoCSV(String enderecoCsv) {

		String linha = "";
		String csvDivisor = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(enderecoCsv))) {

			while ((linha = br.readLine()) != null) {
				// as posições do arrey mostra cada coluna do documento CSV
				String[] arrey = linha.split(csvDivisor);

				for (int i = 0; i < arrey.length; i++) {
					// Imprimindo todas as colunas
					System.out.println("Conteudo Arrey: " + arrey[i]);

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
