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

- É necessário ter instalado o **Docker** e **Maven**.


- Em um terminal de sua preferência, acessa a pasta raiz do Desafio **desafioprogramacao/back-end/desafio/**, executar o comando abaixo:

````
docker-compose-up
````
- *Este comando acima, irá subir o Banco de Dados com a estrutura necessária para rodar a aplicação.*


- Para acessar o banco de dados, **http://localhost:5050/**


- **Usuario:** user / **Senha:**user / **Base de dados**: mydb


- Para derrubar o Banco de Dados é necessario ir até o *terminal* e pressionar **CTRL + C.**


- Para remover o container por definitivo execute o comando abaixo:

````
docker-compose rm
````


- Para rodar uma aplicação é necessario executar o comando abaixo em um *terminal* no seguinte endereço: 


- **desafioprogramacao/back-end/desafio/**. Ele levantará o servidor na porta **http://localhost:8080/**

````
mvn spring-boot:run
````

- Para verificar se a aplicação está no ar, executar uma chamada **HTTP GET** em **localhost:8080/healthcheck**,


- Para rodar os testes unitários, é necessario executar o comando abaixo em um *terminal* no seguinte endereço:


- **desafioprogramacao/back-end/desafio/**.


````
mvn test
````

- Para abrir a interface, basta acessar o seguinte caminho:


- **desafioprogramacao/front-end/** o arquivo **index.html**.


