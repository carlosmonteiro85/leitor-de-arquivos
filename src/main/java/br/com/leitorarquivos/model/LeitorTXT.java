package br.com.leitorarquivos.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.com.leitorarquivos.model.utilizacoes.Produto;

public class LeitorTXT {

	public void lendoTxt(String enderecoCsv) {

		String linha = "";
		boolean linhaTitulo = true;

		try (BufferedReader br = new BufferedReader(new FileReader(enderecoCsv))) {

			while ((linha = br.readLine()) != null) {

				if (linhaTitulo) {
					linhaTitulo = false;
				} else {
					Produto produto = new Produto(linha.substring(0, 10).trim(), Double.parseDouble(linha.substring(10, 17).trim()));
					System.out.println(produto);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
