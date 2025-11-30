📝 Task Manager API

Essa é uma API REST simples de Gerenciador de Tarefas, desenvolvida como um projeto pessoal de estudo.
Inclui operações básicas para gerenciar tarefas e atualizar seus status.

- Tecnologias Utilizadas -
Java 17+
Spring Boot
Spring Web
Spring Data JPA
Banco de dados H2
Maven

- Funcionalidades -
Criar, atualizar, listar e excluir tarefas
Alterar o status da tarefa (pendente / concluída)
Uso de DTOs para uma comunicação mais limpa
Tratamento global de exceções
Arquitetura REST simples e organizada

- Estrutura do Projeto -
controller/ — endpoints REST
service/ — lógica de negócios
repository/ — persistência de dados
dto/ — objetos de requisição e resposta
exceptions/ — tratamento de exceções personalizadas

- Executando o Projeto -
Clone o repositório: git clone https://github.com/wCarvalhoDev/task-manager-api
Acesse a pasta: cd task-manager-api
Execute com Maven: mvn spring-boot:run
Acesse o console do H2: http://localhost:8080/h2-console
