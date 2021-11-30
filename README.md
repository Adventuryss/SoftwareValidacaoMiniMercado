# SoftwareValidacaoMiniMercado

Nome: Bruno Fonseca Machado

* Informações Importantes *

O software foi desenvolvido utilizando a IDE NetBeans com JDK 1.8. Então é necessário possuir ambos na máquina, para acessar o projeto. É importante abrir o NetBeans como administrador para evitar qualquer erro de permissão ao acessar os arquivos. 

É necessário criar a base de dados MySQL para utilizar a aplicação. Ela pode ser encontrada na raiz do projeto, chamada de: "Banco_Mercado_10_10.sql" Caso tenha problemas com ela, no arquivo TXT chamado de "Scripts MySQL em Java.txt" também pode ser encontrado o código para a criação da base de dados. 
Para o funcionamento do software de validação, é necessário adicionar todos os JARs presentes na pasta "JARs Necessários" e "Biblioteca Jar".

É importante alterar os dados sobre a conexão MySQL na classe “ConnectionFactory”, para as que foram configuradas na máquina. Ex.: User, password...

A pasta "JARs Necessários", é onde pode ser encontrado todos os JARs obrigatórios para o funcionamento da biblioteca. Menos o JAR "mysql-connector-java-5.1.47", que é responsável pela conexão MySQL da aplicação do minimercado. Na pasta "Biblioteca Jar", é onde pode ser encontrada a Biblioteca de Internacionalização.

Caso o projeto fique vermelho, como se mostrasse um erro, provavelmente é apenas ele procurando os .jars em uma pasta diferente. 

Qualquer dúvida ou problema:
bruno.fonseca@ufn.edu.br
bruno-fonseca99@hotmail.com
