package br.com.leitor_arquivos.model;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LeitorXML extends DefaultHandler {

	// armazena tudo que foi lido até o momento do XML
	private StringBuffer estruturaLida = new StringBuffer(200);
	// armazena o que esta sendo lido do XML
	private StringBuffer valorAtual = new StringBuffer(100);

	public void run(String enderecoXML) {

		try {

			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
//           InputSource input = new InputSource("/home/ronaldo/Documentos/receita.xml");
			InputSource input = new InputSource(enderecoXML);
			parser.parse(input, new LeitorXML());

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// Logica fficará aqui
	public void startDocument() {
		System.out.print("Iniciando leitura XML ...");
	}

	public void endDocument() {
		System.out.print("\n Finalizando leitura XML...");
	}

	public void characters(char[] ch, int start, int length) {

		valorAtual.append(ch, start, length);

	}

	public void endElement(String uri, String localName, String tag) {

		System.out.print(valorAtual.toString().trim());
		valorAtual.delete(0, valorAtual.length());

		estruturaLida.delete(estruturaLida.length() - tag.length() - 1, estruturaLida.length());

	}

	public void startElement(String uri, String localName, String tag, Attributes atributos) {

		estruturaLida.append("/" + tag);

		System.out.print("\n<" + estruturaLida.substring(1) + (atributos.getLength() != 0 ? " +ATRIBUTOS" : "") + ">");

		valorAtual.delete(0, valorAtual.length());

	}

}
