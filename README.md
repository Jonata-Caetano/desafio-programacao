# API do Software Desafio

## Principais tecnologias utilizadas neste projeto
- Java 8
- Spring Boot
- JUnit 5
- Mockito
- Docker
- MYSQL
- Maven
- JavaScript
- Materialize

## Como rodar a aplicação
- É necessário ter instalado o Docker e Maven.
- Na pasta raiz do Desafio, rodar o comando abaixo:
````
docker-compose-up
````
- Este comando acima, irá subir o Banco de Dados com a estrutura necessária.
- Para derrubar o Banco de Dados é necessario ir ao terminal e ficar pressionando CTRL + C.
- Para remover o container por definitivo é só rodar o comando abaixo:
````
docker-compose rm
````
- Para rodar uma aplicação é necessario roda o comando abaixo, ele levantará o servidor na porta 8080
````
mvn spring-boot:run
````
- Para testar se a aplicação está no ar, executar uma chamada HTTP GET em localhost:8080/healthcheck,
-Para rodar os testes unitários
````
mvn test
````