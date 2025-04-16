# CRUD em Java com PostgreSQL

Esse foi um dos meus primeiros projetos de CRUD feito em Java. Estou estudando no Serratec e esse exercício foi uma forma de treinar e aprofundar os conceitos de banco de dados, JDBC e lógica de programação.

## 💡 O que esse projeto faz

É um sistema simples de cadastro no console onde é possível:

- Adicionar nomes
- Listar todos os nomes cadastrados
- Atualizar um nome pelo ID
- Deletar um nome pelo ID

Os dados ficam salvos em um banco de dados utilzando PostgreSQL. A tabela inicial é criada automaticamente caso não exista.

---

## 🧱 Tecnologias usadas

- Java
- PostgreSQL
- JDBC (Driver de Conexão)
- Scanner (entrada de dados pelo console)

---

## ⚙️ Como rodar o projeto

1. Tenha o PostgreSQL instalado e rodando
2. Crie o banco com o nome `testeapp` e o schema `primeiro` ou altere os dados de conexão no código se for necessário:

```java
String url = "jdbc:postgresql://localhost:5432/testeapp";
String usuario = "app";
String senha = "1234";
4. Rode o programa a partir da classe teste.java
```

---

## 📚Aprendizados

Esse projeto me ajudou a entender melhor como funciona a conexão entre um applicativo Java e o banco de dados relacional, além de reforçar minha lógica de programação com menus e operações CRUD.
