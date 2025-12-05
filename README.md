# Posto-Combustivel

Projeto Spring Boot de exemplo para gestão de um posto de combustível (Desafio).

**Descrição**
- API REST simples que gerencia tipos de combustível, bombas e abastecimentos.
- Implementado com Spring Boot, Spring Data (repositories) e Lombok.


**Requisitos**
- Java 17+ (verifique `pom.xml` para versão exata do compilador configurado).
- Maven 3.6+
- Lombok: o projeto depende de Lombok para gerar getters/setters; assegure que sua IDE tem suporte a Lombok (plugin + annotation processing habilitado) ou rode via Maven.

**Como compilar**
Abra um terminal (PowerShell no Windows) na raiz do projeto (`posto-combustivel`) e execute:

```powershell
mvn -DskipTests clean package
```

Isso irá gerar o artefato em `target/`.

**Como executar**
Após build, execute:

```powershell
java -jar target\posto-combustivel-0.0.1-SNAPSHOT.jar
```

A aplicação sobe por padrão na porta `8080` (ver `src/main/resources/application.properties`).

**Endpoints (resumo)**
Os controllers expõem operações CRUD para as entidades principais. Exemplos (assumindo `localhost:8080`):

- `GET /tipos-combustivel` — listar tipos de combustível
- `POST /tipos-combustivel` — criar tipo de combustível
- `PUT /tipos-combustivel/{id}` — atualizar
- `DELETE /tipos-combustivel/{id}` — remover

- `GET /bombas` — listar bombas
- `POST /bombas` — criar bomba

- `GET /abastecimentos` — listar abastecimentos
- `POST /abastecimentos` — registrar abastecimento



