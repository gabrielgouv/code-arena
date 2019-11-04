# Code Arena - Back-end
Projeto da disciplina de Sistemas Distribuídos - UniFBV

## Arquitetura
A arquitetura utilizada nesse projeto é a [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html), definida por Robert C. Martin

![Arquitetura](https://i.imgur.com/fVDVgnN.png)

- **Core**: Camada de utilidade e de serviços compartilhados entre as outras camadas, também conhecida como crosscutting;
- **Controllers**: Camada que expõe as APIs REST do sistema;
- **Persistence**: Implementação das interfaces Repository da camada Model;
- **Services**: Camada de serviçoes que faz a mediação entre Model, Persistence e Controllers;


## Instalação e Execução

- Clone o reposítório em sua máquina;
- Abra com a sua IDE, no meu caso, utilizo o IntelliJ;

Para buildar o projeto execute o comando:
`mvn package`

- Para rodar, basta executar a classe **CodeArenaApplication.java** no módulo Application do projeto.