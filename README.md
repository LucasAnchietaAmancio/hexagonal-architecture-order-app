 API de Gerenciamento de Pedidos
 
## 1. Sobre o projeto
 
Projeto acadêmico desenvolvido em **Java** e **Spring Boot** para implementação de uma API REST de gerenciamento de clientes e pedidos.
 
O projeto tem como objetivo estudar e aplicar, de forma prática, os conceitos de **Arquitetura Hexagonal (Ports and Adapters)** e **modelagem de domínio** junto com **Spring WEB** e **Spring Data JPA**.
 
## 2. Funcionalidades
 
- Cadastro e consulta de clientes;
- Criação, consulta, atualização e exclusão de pedidos;
- Listagem de pedidos;
- Cancelamento de pedidos;
- Gerenciamento de itens;
- Cálculo do valor total dos pedidos.
## 3. Tecnologias
 
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Docker Compose
## 4. Arquitetura
 
O projeto utiliza a **Arquitetura Hexagonal (Ports and Adapters)** como referência arquitetural.
 
O objetivo é manter as regras de negócio independentes dos mecanismos externos da aplicação.
 
As decisões sobre entidades, Value Objects, Aggregate Roots, Ports, Adapters e organização dos casos de uso fazem parte do exercício de desenvolvimento.