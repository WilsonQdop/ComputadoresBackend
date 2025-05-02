# 💻 Setup de Computadores API

Este projeto é uma API RESTful desenvolvida com **Spring Boot** que permite a criação de setups de computadores, onde cada usuário pode cadastrar seus hardwares (como CPU, GPU, RAM, etc.), atribuindo nome, preço, descrição e link.

## 📚 Funcionalidades

- Cadastro de usuários  
- Criação de setups vinculados a usuários  
- Adição de hardwares a setups  
- Edição, listagem e exclusão de setups e hardwares  
- Relacionamento entre entidades com JPA  
- Documentação automática com Swagger *(implementar ainda)*  

## 🚀 Tecnologias utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Swagger (via Springdoc OpenAPI) *(futuramente)*  
- Maven  

## 📡 Como funcionam as requisições

### 1️⃣ Criar um usuário  
**Requisição:** `POST /users`  
**Exemplo de corpo:**

```json
{
  "name": "Wilson",
  "email": "Wilson.qdop@gmail.com",
  "password": "123A2"
}
```

### 2️⃣ Criar um setup para um usuário com hardwares
  
**Requisição:** `POST /setup/{userId}`  
**exemplo de corpo:**

```json
{
  "name": "Meu Computador Gamer",
  "hardwares": [
    {
      "name": "Placa de vídeo",
      "description": "RX 580 8GB",
      "price": 354.55,
      "url": "https://exemplo.com/rx580"
    },
    {
      "name": "Processador",
      "description": "Ryzen 5 3600",
      "price": 799.99,
      "url": "https://exemplo.com/ryzen5"
    }
  ]
}
```


### 3️⃣ Manipular individualmente os hardwares

Esta etapa é opcional no backend, mas será essencial na implementação do frontend.
Você pode implementar os métodos GET, PUT e DELETE para os hardwares com base em seus IDs.


## 🔧 Como rodar o projeto ##

1. **Clone o repositório:**

```bash
git clone https://github.com/WilsonQdop/ComputadoresBackend.git
cd ComputadoresBackend
```
2. **Configure o application.properties com seu banco MySQL:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```




