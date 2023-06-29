# BDS03

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jefferson1995/bds03/blob/main/LICENSE.txt) 

# Sobre o projeto

Este é um sistema de funcionários e departamentos com uma relação N-1 entre eles.

Neste sistema, todas as rotas são protegidas. Usuários ADMIN podem ler e alterar recursos, enquanto que usuários OPERATOR podem apenas ler.

Validações de Employee:
-	Nome não pode ser vazio
-	Email deve ser válido
-	Departamento não pode ser nulo

Passos feito para resolver os testes:
-	Modelo de dados User-Role
-	Incluir infraestrutura de validação ao projeto
-	Incluir infraestrutura de segurança ao projeto
-	Implementar as funcionalidades



## Modelo conceitual 

![Web 1](https://github.com/jefferson1995/bds03/blob/main/Assets/diagrama.png)

# Tecnologias utilizadas
## Back end

- Java
- Spring Boot
- Spring security
- OAuth2
- JWT refresh token
- Junit 5
- TDD
- JPA / Hibernate
- Maven
- H2 banco de dados


# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/jefferson1995/bds03

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw/wrapper spring-boot:run
```



# Autor

Jefferson Barbosa dos Santos

https://www.linkedin.com/in/jefferson-barbosa-225349149/
