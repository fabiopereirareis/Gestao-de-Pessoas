## Projeto desenvolvido no bootcamp Santander com a Digital Innovation One:

### Sistema de gerenciamento de pessoas em API REST com Spring Boot

Esse projeto é um pequeno sistema para o  gerenciamento de pessoas de uma empresa através de uma API REST, criada  com o Spring Boot.

Passo a passo do desenvolvimento do projeto:

- Setup inicial de projeto com o Spring Boot Initialzr
- Criação de modelo de dados para o mapeamento de entidades em bancos de dados
- Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).
- Relação de cada uma das operações acima com o padrão arquitetural  REST
- Desenvolvimento de testes unitários para validação das funcionalidades
- Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, siga os passos abaixo:
Navegue até a pasta gestaodepessoas/build/libs
Abra um terminal e digite o seguite comando:

```
java -jar gestaodepessoas-0.0.1-SNAPSHOT.jar
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v0/pessoa
```

Documentação de uso básico da aplicação pode ser visualizada no endereço:

`http://localhost:8080/swagger-ui/index.html`

Endereço da aplicação na web:

https://gestao-de-pessoas.herokuapp.com/api/v0/pessoa

Ferramentas usadas no desenvolvimento do projeto::

- OpenJDK Java 11 
- Gradle 
- Spring Boot 2.5.3
- Intellj IDEA Community Edition.
- Controle de versão GIT / GIT Hub .
