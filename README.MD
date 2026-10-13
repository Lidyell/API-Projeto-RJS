::: {align="center"}
# Tasks API

**API REST desenvolvida com Java e Spring Boot, com PostgreSQL hospedado
no Supabase.**

[![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring
Boot](https://img.shields.io/badge/Spring%20Boot-4.x-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?logo=docker&logoColor=white)](https://www.docker.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Supabase-4169E1?logo=postgresql&logoColor=white)](https://supabase.com/)
:::

------------------------------------------------------------------------

## ✨ Sobre o projeto

O **Tasks API** é uma aplicação Java com Spring Boot. O projeto pode ser
executado localmente pelo IntelliJ IDEA ou em um container Docker usando
Docker Compose.

O banco de dados PostgreSQL é remoto, hospedado no Supabase. **Não é
necessário iniciar um container PostgreSQL local.**

## 🧰 Tecnologias

-   **Java 21**
-   **Spring Boot**
-   **Maven**
-   **PostgreSQL**
-   **Supabase**
-   **Docker** e **Docker Compose**

## ✅ Pré-requisitos

Escolha o modo de execução desejado.

### Para executar com Docker

-   Docker instalado e em execução
-   Docker Compose (incluído no Docker Desktop e disponível no Docker
    Engine moderno)
-   Credenciais e dados de conexão do banco no Supabase

### Para executar pelo IntelliJ IDEA

-   JDK 21
-   IntelliJ IDEA
-   Credenciais e dados de conexão do banco no Supabase

## 🔐 Configuração das variáveis de ambiente

Na raiz do projeto, crie um arquivo chamado `.env` com as variáveis
abaixo:

``` dotenv
APP_PORT=8088
DB_URL=jdbc:postgresql://SEU_HOST:PORTA/postgres
DB_USER=SEU_USUARIO
DB_PASSWORD=SUA_SENHA
```

Substitua os valores de exemplo pelos dados fornecidos em **Supabase →
Connect**. Use o host, a porta e o usuário correspondentes ao método de
conexão escolhido. Se o Supabase exigir SSL, use a URL JDBC com os
parâmetros SSL indicados pelo próprio painel.

> **Segurança:** nunca envie o arquivo `.env` para o Git. Não coloque
> senhas ou credenciais reais neste README, no código-fonte ou em
> commits.

Confirme que o `.gitignore` contém:

``` gitignore
.env
```

O `application.yml` usa as variáveis `DB_URL`, `DB_USER` e
`DB_PASSWORD`. Ao executar pelo Docker Compose, o arquivo `.env` é
disponibilizado ao container pela configuração `env_file`.

## 🐳 Executar com Docker Compose

### 1. Clone o repositório

``` bash
git clone URL_DO_REPOSITORIO
cd NOME_DA_PASTA
```

Substitua `URL_DO_REPOSITORIO` pelo endereço do repositório e
`NOME_DA_PASTA` pelo diretório criado.

### 2. Configure o `.env`

Crie o arquivo conforme a seção [Configuração das variáveis de
ambiente](#-configuração-das-variáveis-de-ambiente).

### 3. Construa a imagem e inicie a aplicação

Execute na pasta onde estão o `Dockerfile` e o `docker-compose.yaml`:

``` bash
docker compose up --build
```

Esse comando constrói a imagem da aplicação e inicia o container. Os
logs aparecem no próprio terminal.

Para executar em segundo plano:

``` bash
docker compose up -d --build
```

### 4. Confira os logs e o estado

``` bash
docker compose ps
docker compose logs -f app
```

Use `Ctrl+C` para sair da visualização contínua dos logs. Isso não
encerra o container quando ele foi iniciado em segundo plano.

### 5. Acesse a aplicação

A aplicação está configurada para escutar na porta `8088`:

``` text
http://localhost:8088
```

A URL acima é a raiz da aplicação. Para testar a API, utilize um
endpoint que exista no projeto.

### Comandos úteis

  -----------------------------------------------------------------------
Comando                             Descrição
  ----------------------------------- -----------------------------------
`docker compose up --build`         Constrói/reconstrói a imagem e
inicia os serviços

`docker compose up -d --build`      Faz o mesmo em segundo plano

`docker compose logs -f app`        Acompanha os logs da aplicação

`docker compose ps`                 Mostra o estado dos serviços

`docker compose stop`               Para os containers sem removê-los

`docker compose start`              Inicia novamente os containers
parados

`docker compose down`               Para e remove os containers da
composição
  -----------------------------------------------------------------------

> Ao alterar o código Java ou arquivos incorporados à imagem, execute
> novamente `docker compose up --build` para reconstruir e iniciar a
> versão atualizada.

## 💻 Executar pelo IntelliJ IDEA

O modo Run executa a aplicação diretamente na máquina, sem usar o
container da aplicação.

1.  Instale e selecione o **JDK 21** no projeto.
2.  Abra **Run → Edit Configurations...**.
3.  Selecione a configuração Spring Boot da aplicação.
4.  Configure as variáveis de ambiente `DB_URL`, `DB_USER` e
    `DB_PASSWORD` com os valores do seu `.env`.
5.  Clique em **Apply → OK** e execute pelo botão **Run ▶**.

O IntelliJ não carrega automaticamente um arquivo `.env` só porque ele
está na raiz do projeto. Configure as variáveis na execução ou utilize
um recurso/plugin de carregamento de `.env`, se disponível na sua
instalação.

## 🛠️ Solução de problemas

### A aplicação não conecta ao Supabase

-   Confira host, porta, usuário e senha em **Supabase → Connect**.
-   Use o conjunto de dados correspondente ao tipo de conexão
    selecionado no Supabase.
-   Verifique se o `.env` está na raiz do projeto e se os nomes das
    variáveis estão exatamente como no exemplo.
-   Não tente corrigir um erro de conexão alterando o dialeto do
    Hibernate sem antes validar a conexão JDBC.

### O container inicia, mas a API não responde

-   Confira os logs com `docker compose logs -f app`.
-   Confira se a porta `8088` está livre.
-   Verifique se a aplicação iniciou sem exceções.

### Variável de ambiente não encontrada

-   Confirme que `DB_URL`, `DB_USER` e `DB_PASSWORD` estão no `.env`.
-   Confirme que o serviço `app` no Compose contém `env_file: .env`.
-   Se estiver executando pelo IntelliJ, configure as variáveis
    separadamente.

## 📁 Estrutura esperada

``` text
.
├── src/
├── .env                 # local; não versionar
├── .gitignore
├── Dockerfile
├── docker-compose.yaml
├── application.yml      # em src/main/resources/
├── pom.xml
└── README.md
```

*Nota: `application.yml` normalmente fica em `src/main/resources/`; ele
não precisa ficar na raiz do repositório.*

------------------------------------------------------------------------

::: {align="center"}
Feito com ☕ Java, Spring Boot e Docker.
:::
