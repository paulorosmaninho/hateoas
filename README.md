# API Exemplo HATEOAS
![GitHub repo size](https://img.shields.io/github/repo-size/paulorosmaninho/hateoas)
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/paulorosmaninho/hateoas/blob/master/LICENSE) 


# Sobre a API

A sigla HATEOAS significa Hypermedia As the Engine Of Application State. Ao ser implementada em uma aplicação REST, a API passa a fornecer links que indicarão aos clientes como navegar através dos seus recursos. É uma API do tipo "discoverable". Isso facilita no momento de consumir pois o cliente descobrirá as URLs conforme navega entre seus recursos, acessando-os de forma circular, já que a API consegue ser autoexplicativa, guiando o consumidor através de suas requisições.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Front end
- Postman

## Implantação somente em modo de teste com banco de dados H2
- Banco de dados: H2

# Como executar o projeto

```bash
# clonar repositório
git clone https://github.com/paulorosmaninho/hateoas.git

# entrar na pasta local do projeto
exemplo: cd hateoas

# executar o comando abaixo
mvnw spring-boot:run

# abrir o browser de sua preferência para ter acesso ao console do H2 e digitar
http://localhost:8080/h2-console
```

# Exemplos de requisições
```bash

# request método GET via browser ou Postman:
# para visualizar a lista de produtos digitar URL
localhost:8080/produtos

# Response
[
    {
        "id": 1,
        "nome": "Notebook",
        "valor": 3447.99,
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/produtos/1"
            }
        ]
    },
    {
        "id": 2,
        "nome": "Monitor 20 Polegadas",
        "valor": 999.99,
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/produtos/2"
            }
        ]
    },
    
    . . .
]

# request via método GET via browser ou Postman
# para visualizar um produto individual digitar URL
http://localhost:8080/produtos/1

# Response
{
    "id": 1,
    "nome": "Notebook",
    "valor": 3447.99,
    "_links": {
        "self": {
            "href": "http://localhost:8080/produtos"
        }
    }
}

# request via método POST via Postman para salvar um produto
# digitar a URL
http://localhost:8080/produtos

# JSON exemplo
{
    "nome": "Celular",
    "valor": "1099.99"
}

```

## Back end
Pré-requisitos: 
Java versão 17

# Autor
Paulo Rosmaninho

https://www.linkedin.com/in/paulorosmaninho
