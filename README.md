# code-arena

### Pré-requisitos:
- Git
- Java 8
- Maven
- Docker
- Docker Compose

### Subindo a aplicação

Atenção: Para subir a aplicação é necessário ter todos os pré-requisitos listados acima.

1. Clone este repositório na sua máquina: `git clone https://github.com/gabrielgouv/code-arena.git`
2. Entre no diretório raiz do projeto: `cd code-arena`
2. No diretório **code-arena-server** execute o seguinte comando: `mvn clean install`
3. Faça o mesmo para o diretório **code-arena-api-gateway**: `mvn clean install`
4. Volte para a raiz do projeto: `cd ..`
5. Execute o docker-compose: `docker-compose build` e em seguida `docker-compose up`

Isto irá subir 3 serviços:
1. O Code Arena Server (code-arena-server)
2. O Code Arena API Gateway (code-arena-api-gateway)
3. O banco de dados (PostgreSQL)


# Arquitetura dos serviços (WIP)

![Drag Racing](https://github.com/gabrielgouv/code-arena/blob/master/code-arena-docs/services-arch-v1.png?raw=true)
