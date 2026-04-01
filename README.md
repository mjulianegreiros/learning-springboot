# ☕ Java & Spring Boot: Exercícios de Fixação

Este repositório centraliza meus estudos práticos de Java e Spring Boot. O foco aqui é a aplicação dos conceitos da trilha "Building a REST API with Spring Boot" da Spring Academy em exercícios independentes.

---

## 🗂️ Estrutura do Repositório

O repositório está organizado por módulos de aprendizado. Dentro de cada módulo, cada exercício é tratado como um projeto independente com suas próprias configurações de build.

### 📁 Módulo 1
* **`testing-first`**: Prática de TDD com Spring Boot e JUnit. Foco em serialização e deserialização com Jackson, cobrindo fluxos de sucesso e tratamento de erros (JSON e dados inválidos).
* **`spring-get-exercise`**: Implementação de endpoints GET para busca de usuários por ID e nome. Validação de respostas 200 e 404 seguindo a abordagem TDD, sem o uso de MockMvc.
* **`biblioteca`**: Construção de uma API REST de biblioteca, entendendo JPA, H2 e rotas GET.
* **`catalogo`**: Prática de testes com Spring Boot e JUnit. Foco em validação de Repository e Controller, cobrindo persistência, respostas via ResponseEntity e retorno de Location URI.
* **`item-api`**: Desenvolvimento de uma API REST para gerenciamento de itens com Spring Boot e Spring Data JPA. Implementação de endpoints GET (listagem e busca por id) e POST com retorno adequado (201 Created e Location). Integração com banco H2 em memória, uso de scripts SQL (data.sql) para inicialização de dados e prática de testes de integração com TestRestTemplate, validando requisições HTTP reais, status codes e fluxo completo da aplicação.

> [!NOTE]
> **Próximos Módulos:** (Em breve) novos exercícios serão adicionados conforme a progressão nos estudos.

---

## 🚀 Como Executar

Para rodar qualquer um dos exercícios, navegue até a pasta específica do projeto e execute o Maven Wrapper:

```bash
# Acesse a pasta do exercício
cd modulo1/nome-do-exercicio

# Execute o projeto
./mvnw spring-boot:run
```
---

**Mantido por Maria Júlia Negreiros**
