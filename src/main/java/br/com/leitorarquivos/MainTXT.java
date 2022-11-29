package br.com.leitorarquivos;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import br.com.leitorarquivos.model.LeitorTXT;

public class MainTXT {

	public static void main(String[] args) {
		LeitorTXT leitorTXT = new LeitorTXT();
		
		try {
			File file = new File(new URI("file://192.168.0.22/bd/teste2.txt"));
			System.out.println(file);
			
			leitorTXT.lendoTxt(file.getAbsolutePath());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		            checker.check("");
//        checker.check("//192.168.0.21/home/monteiro/dockercompose/mysql/5/docker-compose.yml");
//        checker.check("\\\\server\\path");
//        checker.check("\\\\192.168.0.22\\bd");
//		leitorTXT.lendoTxt("teste.txt");

//		leitorTXT.lendoTxt("file://192.168.0.21/home/monteiro/arquivos-rede/teste.txt");

//		URI uri;
//		try {
//			uri = new URI("file://192.168.0.22/bd/teste2.txt");
//			URL url = uri.toURL();
//			URLConnection conn = url.openConnection();
//			conn.connect();
//			System.out.println(conn);
//			
//		} catch (URISyntaxException | IOException e) {
//			e.printStackTrace();
//		}
	}
}
