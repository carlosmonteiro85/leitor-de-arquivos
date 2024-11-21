# Leitor de arquivos
Projeto consiste em gerar um leitor de arquivos csv, txt, json e xml 


 # Tecnologias e ferramentas usadas
 * Spring boot - Framework utilizada com a arquitetura MVC.
 * Lombok - para Gerar os construtores e os métodos Getter e Setter no projeto..
 * Spring-boot-devtools - Pela facilidade no reload ao realizar uma modificação.
 * Java 17 - usado no código fonte.

# Executando o projeto

## Existe duas formas de execultar o projeto: 
* Com o código fonte, neste é necessário executar o arquivo "LeitorArquivoApplication.java", como "Java application" ou executando o comando mvn spring-boot:run

 Os arquivos de exemplo estão na pasta resources

# Acessos a API

* leitor TXT http://localhost:8080/api/txt
* leitor CSV http://localhost:8080/api/csv
* leitor JSON http://localhost:8080/api/json
* leitor XML http://localhost:8080/api/xml
