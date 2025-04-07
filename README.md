# API Cadastro

---

Este é um projeto simples em Spring Boot que implementa operações básicas de CRUD (Create, Read, Update, Delete) para cadastro de funcionários e suas atividades.
O sistema utiliza:

- Java 17: Linguagem de programação
- Spring Boot: Para criação da aplicação web e gerenciamento de dependências.
- Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
- Flyway: Para gerenciamento de migrações do banco de dados.
- JPA (Java Persistence API): Para mapeamento objeto-relacional (ORM).
- Lombok: Redução de boilerplate code
- Swagger: Documentação interativa da API
- Maven: Para build e gerenciamento de dependências do projeto.
- SQL: Manipulação do banco de dados
- Git: Controle de versão para gerenciamento de mudanças no código.

---
#  Requisitos

Antes de rodar a aplicação, você precisa ter instalado na sua máquina:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/)

---

#  Como rodar o projeto localmente

Siga os passos abaixo para clonar, construir e executar a aplicação:

### 1. Clone o repositório
```bash
git clone https://github.com/LuigiNastri/APICadastro
```

### 2. Navegue até o diretório do projeto
```bash
cd APICadastro
```

### 3. Construa o projeto com o Maven
```bash
mvn clean install
```

### 4. Execute a aplicação
```bash
mvn spring-boot:run
```

### 5. Acesse a aplicação
Abra seu navegador e vá para:
```
http://localhost:8080
```


# Documentação dos Endpoint

## FuncionarioController
**Caminho Base:** `/funcionario`

### Endpoints

#### `GET /boasvindas`
- **Descrição:** Mensagem de boas-vindas
- **Respostas:**
    - `200`: "Essa é minha primeira mensagem nessa rota"

#### `POST /criar`
- **Descrição:** Criar novo funcionário
- **Corpo da Requisição:** `FuncionarioDTO` (obrigatório)
- **Respostas:**
    - `201`: "Funcionário criado com sucesso: [nome] (ID): [id]"
    - `400`: "Erro na criação do funcionário"

#### `GET /listar`
- **Descrição:** Listar todos os funcionários
- **Respostas:**
    - `200`: Retorna `List<FuncionarioDTO>`

#### `GET /listar/{id}`
- **Descrição:** Obter funcionário por ID
- **Parâmetros:**
    - `id` (caminho, obrigatório)
- **Respostas:**
    - `200`: Retorna `FuncionarioDTO`
    - `404`: "O funcionário com o ID: [id] não foi encontrado"

#### `DELETE /deletar/{id}`
- **Descrição:** Excluir funcionário por ID
- **Parâmetros:**
    - `id` (caminho, obrigatório)
- **Respostas:**
    - `200`: "Funcionário com o ID [id] excluído com sucesso"
    - `404`: "O funcionário com o ID [id] não foi encontrado"

#### `PUT /alterar/{id}`
- **Descrição:** Atualizar funcionário por ID
- **Parâmetros:**
    - `id` (caminho, obrigatório)
    - `FuncionarioDTO` (corpo, obrigatório)
- **Respostas:**
    - `200`: Retorna `FuncionarioDTO` atualizado
    - `404`: "O funcionário com o ID ([id]) não foi encontrado para atualização"

## AtividadeController
**Caminho Base:** `/atividade`

### Endpoints

#### `GET /listar`
- **Descrição:** Listar todas as atividades
- **Respostas:**
    - `200`: Retorna `List<AtividadeDTO>`

#### `GET /listar/{id}`
- **Descrição:** Obter atividade por ID
- **Parâmetros:**
    - `id` (caminho, obrigatório)
- **Respostas:**
    - `200`: Retorna `AtividadeDTO`
    - `404`: "Atividade com o ID: [id] não foi encontrada"

#### `POST /criar`
- **Descrição:** Criar nova atividade
- **Corpo da Requisição:** `AtividadeDTO` (obrigatório)
- **Respostas:**
    - `201`: "Atividade criada com sucesso: [descricao] (ID: [id])"

#### `PUT /alterar/{id}`
- **Descrição:** Atualizar atividade por ID
- **Parâmetros:**
    - `id` (caminho, obrigatório)
    - `AtividadeDTO` (corpo, obrigatório)
- **Respostas:**
    - `200`: Retorna `AtividadeDTO` atualizado
    - `404`: "Atividade com o ID: [id] não encontrada para atualização"

#### `DELETE /deletar/{id}`
- **Descrição:** Excluir atividade por ID
- **Parâmetros:**
    - `id` (caminho, obrigatório)
- **Respostas:**
    - `200`: "Atividade com o ID [id] excluída com sucesso"
    - `404`: "Atividade com o ID [id] não encontrada"

---

