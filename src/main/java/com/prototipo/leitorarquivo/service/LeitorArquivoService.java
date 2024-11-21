package com.prototipo.leitorarquivo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.prototipo.leitorarquivo.model.Produto;
import com.prototipo.leitorarquivo.model.Usuario;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LeitorArquivoService {

    public List<Produto> leitorTxt(String pathFile) {
        String linha = "";
        boolean linhaTitulo = true;
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource(pathFile).getInputStream()))) {

            while ((linha = br.readLine()) != null) {
                if (linhaTitulo) {
                    linhaTitulo = false;
                } else {
                    Produto produto = new Produto(linha.substring(0, 10).trim(),
                            Double.parseDouble(linha.substring(10, 17).trim()));
                    produtos.add(produto);
                }
            }
        } catch (IOException e) {
            log.error("Erro ao processar o arquivo txt: {}", pathFile, e);
        }
        return produtos;
    }

    public List<Usuario> leitorCsv(String pathFile) {
        String linha = "";
        String csvDivisor = ",";
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource(pathFile).getInputStream()))) {
            while ((linha = br.readLine()) != null) {
                String[] arrey = linha.split(csvDivisor); // as posições do arrey mostra cada coluna do documento CSV
                Usuario usuario = new Usuario();
                usuario.setNome(arrey[0]);
                usuario.setEmail(arrey[1]);
                usuario.setSenha(arrey[2]);
                usuario.setTelefone(arrey[3]);

                usuarios.add(usuario);
            }
        } catch (IOException e) {
            log.error("Erro ao processar o arquivo csv: {}", pathFile, e);
        }
        return usuarios;
    }

    public List<Usuario> leitorJSON(String pathFile) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource(pathFile).getInputStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) { // Leitura do arquivo JSON
                sb.append(line);
            }
            return processarJSON(sb.toString()); // Processar o JSON
        } catch (IOException e) {
            log.error("Erro ao ler o arquivo JSON no caminho: {}", pathFile, e);
        }
        return List.of();
    }

    private List<Usuario> processarJSON(String jsonContent) {
      JSONArray jsonArray = new JSONArray(jsonContent);
      List<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objeto = jsonArray.getJSONObject(i);
            Usuario usuario = new Usuario();
            usuario.setNome(objeto.getString("nome"));
            List<String> contatos = processarArray(objeto.getJSONArray("contatos"));

            usuario.setTelefone(String.join(",", contatos));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    private List<String> processarArray(JSONArray array) {
        List<String> contatos = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            contatos.add(array.getString(i)); // adiciona o contato a lista de contatos
            log.info(" {}", array.getString(i));
        }
        return contatos;
    }

    public Produto leitorXML(String pathFile) {

        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        try {
            InputStream inputStream = new ClassPathResource(pathFile).getInputStream();
            // cria uma fabrica de cocumentos
            DocumentBuilder builder = fabrica.newDocumentBuilder();
            // passa para o documento o endereço do arquivo xml
            Document document = builder.parse(inputStream);
            // Recebe a tag específica do XML que retornara neste caso uma lita de produtos
            // do xml
            NodeList produtos = document.getElementsByTagName("produto");

            // itera com varios produtos recebidos do xml
            for (int i = 0; i < produtos.getLength();) {
                Element produto = (Element) produtos.item(i);
                // acesso o nome da tag nome, escolho o item 0 para acessar o nome de cada
                // produto
                String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
                // acessa a tag preco e obtem todos os preços dos produtos
                double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
                // instancia um produto e seta as insformações do xml em um objeto da Classe
                // Produto
                Produto prod = new Produto(nome, preco);
                log.info("Produto: {}", prod);
                return prod;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error("Erro ao ler o arquivo XML no caminho: {}", pathFile, e);
        }
        return null; // caso não encontre nenhum produto no XML retorna null
    }
}
