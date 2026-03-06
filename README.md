# Simulador FGTS - Backend

API REST desenvolvida em Java com Spring Boot para gerenciar simulações de saque-aniversário do FGTS. Calcula automaticamente valores disponíveis baseados em faixas de saldo.

O frontend consome esta API para realizar as simulações de saque-aniversário do FGTS.

## Sobre o Projeto

Sistema backend que fornece API REST para:

-  Calcular valores de saque-aniversário do FGTS baseado em 7 faixas de saldo
-  Persistir simulações em banco de dados MySQL
-  Operações CRUD completas (Create, Read, Update, Delete)
-  Validação automática de dados
-  Cálculo automático de alíquota e parcela adicional por faixa
-  Registro de data/hora da simulação

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 4.0.2**
- **Spring Data JPA** - Persistência de dados
- **Spring Web MVC** - API REST
- **Spring Validation** - Validação de dados
- **MySQL Connector** - Driver de conexão
- **Lombok** - Redução de boilerplate
- **Maven** - Gerenciamento de dependências

## Pré-requisitos

- [Java JDK 17](https://www.oracle.com/java/technologies/downloads/) ou superior
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [MySQL 8.0+](https://www.mysql.com/downloads/)
- [Git](https://git-scm.com/)

## Instalação e Configuração

### 1. Clone o repositório

```bash
git clone https://github.com/ClaudirFantuci/crud-simulador_fgts-Back.git
cd crud-simulador_fgts-Back
```

### 2. Configure o banco de dados MySQL

Crie o banco de dados:

```sql
CREATE DATABASE simuladorFgts;
```

### 3. Configure as credenciais

Edite o arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=crud-simulador_fgts-backend
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/simuladorFgts
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_AQUI
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### 4. Compile o projeto

```bash
./mvnw clean install
```

No Windows:
```bash
mvnw.cmd clean install
```

### 5. Execute a aplicação

```bash
./mvnw spring-boot:run
```

No Windows:
```bash
mvnw.cmd spring-boot:run
```

A API estará disponível em `http://localhost:8080`

## Estrutura do Projeto

```
crud-simulador_fgts-Back/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── crud_simulador_fgts_backend/
│   │   │       ├── controller/
│   │   │       │   └── SaqueAniversarioController.java
│   │   │       ├── model/
│   │   │       │   └── SaqueAniversario.java
│   │   │       ├── repository/
│   │   │       │   └── SaqueAniversarioRepository.java
│   │   │       ├── service/
│   │   │       │   └── SaqueAniversarioService.java
│   │   │       └── enums/
│   │   │           └── FaixaSaldoFgts.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .mvn/
├── pom.xml
└── README.md
```

## Endpoints da API

### Base URL: `/api/SaqueAniversario`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/SaqueAniversario` | Criar nova simulação |
| GET | `/api/SaqueAniversario` | Listar todas simulações |
| PUT | `/api/SaqueAniversario/{id}` | Atualizar simulação |
| DELETE | `/api/SaqueAniversario/{id}` | Excluir simulação |


## Tabela de Faixas FGTS

O sistema utiliza 7 faixas de saldo para cálculo:

| Faixa | Saldo Mínimo | Saldo Máximo | Alíquota | Parcela Adicional |
|-------|--------------|--------------|----------|-------------------|
| 1 | R$ 0,00 | R$ 500,00 | 50% | R$ 0,00 |
| 2 | R$ 500,01 | R$ 1.000,00 | 40% | R$ 50,00 |
| 3 | R$ 1.000,01 | R$ 5.000,00 | 30% | R$ 150,00 |
| 4 | R$ 5.000,01 | R$ 10.000,00 | 20% | R$ 650,00 |
| 5 | R$ 10.000,01 | R$ 15.000,00 | 15% | R$ 1.150,00 |
| 6 | R$ 15.000,01 | R$ 20.000,00 | 10% | R$ 1.900,00 |
| 7 | R$ 20.000,01 | Acima | 5% | R$ 2.900,00 |


##  Integração com Frontend

Este backend fornece a API REST para o frontend React.

**Repositório do Frontend**: [crud-simulador_fgts-Front](https://github.com/ClaudirFantuci/crud-simulador_fgts-Front)

Certifique-se de que o backend esteja rodando antes de iniciar o frontend.

## Melhorias Futuras

- [ ] Implementar autenticação e autorização (Spring Security + JWT)
- [ ] Implementar calculo de antecipação
- [ ] Adicionar documentação Swagger/OpenAPI
- [ ] Implementar paginação na listagem
- [ ] Adicionar filtros de busca (por nome, faixa, período)


## Licença

Este projeto está sob a licença MIT.

## 🔗 Links Relacionados

- [Frontend do Projeto](https://github.com/ClaudirFantuci/crud-simulador_fgts-Front)
- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Informações sobre FGTS Saque-Aniversário](https://www.gov.br/trabalho-e-previdencia/pt-br/assuntos/fgts)


