import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.leitor_arquivos.model.utilizações.Produto;

public class MainXML {

	public static void main(String[] args) {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = fabrica.newDocumentBuilder();
			Document document = builder.parse("arquivo.xml");
			// Recebe a tag específica do XML
			NodeList produtos = document.getElementsByTagName("produto");

			for (int i = 0; i < produtos.getLength(); i++) {
				
				Element produto = (Element) produtos.item(i);
				//acesso o nome da tag nome, escolho o item 0 para acessar o primeiro nome
				String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
				double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());				
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

//		LeitorXML leitor = new LeitorXML();
//		
//		leitor.run("arquivo.xml");
//	}
	}
}
