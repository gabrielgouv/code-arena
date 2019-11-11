# Code Arena

### Pré-requisitos:
- Git
- Java 8
- Maven
- Docker
- Docker Compose

### Subindo a aplicação

**Atenção:** Para subir a aplicação é necessário ter todos os pré-requisitos listados acima.

1. Clone este repositório na sua máquina: `git clone https://github.com/gabrielgouv/code-arena.git`
2. Entre no diretório raiz do projeto: `cd code-arena`
3. No diretório **code-arena-api** execute o seguinte comando: `mvn clean install`
4. Faça o mesmo para o diretório **code-arena-api-gateway**: `mvn clean install`
5. Volte para a raiz do projeto: `cd ..`
6. Execute o docker-compose: `docker-compose build` e em seguida `docker-compose up`

⚠️ **Os passos 3, 4 e 5 podem ser substituídos executando o arquivo `mvn-clean-install-projects.sh` (MacOS ou Linux) ou o `mvn-clean-install-projects.bat` (Windows)**

---------

Isto irá subir 3 serviços:
1. Code Arena API (code-arena-api)
2. Code Arena API Gateway (code-arena-api-gateway)
3. Banco de dados (PostgreSQL)

Desta forma, o Code Arena API roda na porta 8081 que fica inacessível fora da rede do docker-compose. Para acessar o server é necessário passar pelo API Gateway que é exposto na porta 8080:

**Acesse o Swagger para verificar todos os end-points disponíveis: http://localhost:8080/api/swagger-ui.html**

# Arquitetura dos serviços (WIP)

![Drag Racing](https://github.com/gabrielgouv/code-arena/blob/master/code-arena-docs/services-arch-v1.png?raw=true)
