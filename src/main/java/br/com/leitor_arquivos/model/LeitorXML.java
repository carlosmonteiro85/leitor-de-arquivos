package br.com.leitor_arquivos.model;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.leitor_arquivos.model.utilizações.Produto;

public class LeitorXML {

	public void lendoXML(String enderecoXML) {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		try {

			//cria uma fabrica de cocumentos
			DocumentBuilder builder = fabrica.newDocumentBuilder();
			//passa para o documento o endereço do arquivo xml
			Document document = builder.parse(enderecoXML);
			// Recebe a tag específica do XML que retornara neste caso uma lita de produtos do xml
			NodeList produtos = document.getElementsByTagName("produto");

			//itera com varios produtos recebidos do xml
			for (int i = 0; i < produtos.getLength(); i++) {
				
				Element produto = (Element) produtos.item(i);
				//acesso o nome da tag nome, escolho o item 0 para acessar o nome de cada produto
				String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
				//acessa a tag preco e obtem todos os preços dos produtos
				double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
				//instancia um produto e seta as insformações do xml em um objeto da Classe Produto
				Produto prod = new Produto(nome, preco);
				
				System.out.println(prod.getNome());
				System.out.println(prod.getPreco());
				
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		
		
	}


}
