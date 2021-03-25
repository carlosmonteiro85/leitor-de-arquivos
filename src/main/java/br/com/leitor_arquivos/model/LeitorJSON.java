package br.com.leitor_arquivos.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class LeitorJSON {

	public void lendoJSON(String enderecoJSON) {

		BufferedReader br = null;
		String line;

		try {
			//lê o arquivo Json recebido
			br = new BufferedReader(new FileReader(enderecoJSON));
			StringBuilder sb = new StringBuilder();
			
			//aqui onde é feito a leitura do arquivo
			while ((line = br.readLine()) != null) {
				sb = sb.append(line);
			}

			br.close();

			//é posto em um array todo conteudo
			JSONArray ja = new JSONArray(sb.toString());

			for (int x = 0; x < ja.length(); x++) {
				JSONObject ob = ja.getJSONObject(x);

				//joga o valor de cada atributo para uma variável específica
				String id = ob.getString("id");
				String nome = ob.getString("nome");
				String apelido = ob.getString("mostraApelido");
				String estado = ob.getString("estado");
				String cidade = ob.getString("cidade");

				//saida dos valores
				System.out.println("id = " + id + "\n" + "nome = " + nome + "\n" + "apelido = " + apelido + "\n"
						+ "estado =  " + estado + "\n" + "cidade = " + cidade + "\n");

				System.out.println("endereco");
				
				//array para receber todos os endereços
				JSONArray aends = ob.getJSONArray("endereco");
				for (int z = 0; z < aends.length(); z++) {
					String s = aends.getString(z);
					System.out.println(" " + s);
				}

				System.out.println("contatos");
				// arrey de contatos
				JSONArray acontatos = ob.getJSONArray("contatos");
				for (int z = 0; z < acontatos.length(); z++) {
					String s = acontatos.getString(z);
					System.out.println(" " + s);

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
