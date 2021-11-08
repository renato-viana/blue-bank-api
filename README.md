# Blue Bank
Seja bem-vindo a API do Blue Bank, simples prática e rápida, com este projeto você consegue criar contas, fazer transferências e listar as transferências efetuadas de forma simples e direta.

O projeto foi criado usando [Spring](https://spring.io/) um dos frameworks que vem crescendo cada vez mais no mundo Java

<br/>

> 💡 Projeto de conclusão do programa IBM Blue Academy promovido por [IBM](https://www.ibm.com/br-pt) e [Gama Academy](https://www.gama.academy/)


<br>

## Autores

[Renato Viana](https://github.com/renato-viana)
<br>
[Mateus André](https://github.com/MateusAndraste)


<br>
<br>

# Como rodar
Para rodar o projeto basta fazer o clonet, abrir em uma IDE (Eclipse, Intellij, Vscode) e rodar o arquivo [BlueBankApiApplication.java](src/main/java/com/blueknights/bank/BlueBankApiApplication.java)

<br>
<br>

# Documentação
<details>
  <summary><span style="color: orange; font-weight: bold">POST</span> | CRIAR USUÁRIO</summary>
  
  ### Criar um novo usuário na aplicação, no caso o dono de uma conta
  [http://localhost:8080/holders](http://localhost:8080/holders)

### Request body
```java
{
    "cpf": "000.000.000-00",
    "name": "Renato",
    "email": "renato@gmail.com",
    "accounts": [
        {
            "number": "23550-9",
            "agency": "8506",
            "balance": 2000
        },
        {
            "number": "51890-2",
            "agency": "3467",
            "balance": 3500
        }
    ]
}
```
### Response
```java
{
    "id": 4,
    "name": "Renato",
    "email": "renato@gmail.com",
    "accounts": [
        {
            "number": "23550-9",
            "agency": "8506",
            "balance": 2000
        },
        {
            "number": "51890-2",
            "agency": "3467",
            "balance": 3500
        }
    ]
}
```  
</details>

<br>

<details>
  <summary><span style="color: blue; font-weight: bold">GET</span> | LISTAR USUÁRIOS</summary>
  
  ### Listar todos os usuários cadastrados na base
  [http://localhost:8080/holders](http://localhost:8080/holders)

### Response
```java
[
    {
        "id": 1,
        "name": "Renato",
        "email": "renato@gmail.com",
        "accounts": [
            {
                "number": "42565-8",
                "agency": "5252",
                "balance": 3000
            }
        ]
    },
    {
        "id": 2,
        "name": "Mateus",
        "email": "mateus@gmail.com",
        "accounts": [
            {
                "number": "58566-3",
                "agency": "8686",
                "balance": 3000
            }
        ]
    }
]
```  
</details>

<br>

<details>
  <summary><span style="color: blue; font-weight: bold">GET</span> | LISTAR USUÁRIO POR ID</summary>
  
  ### Listar um usuário especificando seu ID na url
  [http://localhost:8080/holders/:id](http://localhost:8080/holders/1)

### Response
```java
{
    "id": 1,
    "name": "Renato",
    "email": "renato@gmail.com",
    "accounts": [
        {
            "number": "42565-8",
            "agency": "5252",
            "balance": 3000
        }
    ]
}
```  
</details>

<br>

<details>
  <summary><span style="color: orange; font-weight: bold">POST</span> | TRANSFERÊNCIA</summary>
  
  ### Efetuar transferências entre contas passando como parâmetro de url a conta de origem da transferência
  [localhost:8080/accounts/:id/transfer](localhost:8080/accounts/1/transfer)
### Request body
@id: id da conta de destino
<br>
@value: valor a ser transferido
```java
{
	"id": 2,
	"value": 500
}
```
### Response
200 | <span style="color: green;">SUCCESS</span>
```java
{
    "message": "Transferência executada com sucesso"
}
```  
400 | <span style="color: yellow;">BAD REQUEST</span>
```java
{
    "status": 400,
    "timestamp": "2021-11-08T17:47:13.703845649-03:00",
    "type": "https://bluebank.com.br/erro-negocio",
    "title": "Violação de regra de negócio",
    "detail": "Você não tem saldo suficiente para completar a operação",
    "userMessage": "Você não tem saldo suficiente para completar a operação"
}
```
404 | <span style="color: yellow;">NOT FOUND</span>
```java
{
    "status": 404,
    "timestamp": "2021-11-08T17:47:49.009580923-03:00",
    "type": "https://bluebank.com.br/recurso-nao-encontrado",
    "title": "recurso não encontrado",
    "detail": "Não existe um cadastro de conta com código 20!",
    "userMessage": "Não existe um cadastro de conta com código 20!"
}
```  
</details>


<br>

<details>
  <summary><span style="color: blue; font-weight: bold">GET</span> | LISTAR TRANSFERÊNCIAS</summary>
  
  ### Listar todas as transferências efetuadas
  [localhost:8080/accounts/:id/transfer](localhost:8080/accounts/1/transfer)

### Response
200 | <span style="color: green;">SUCCESS</span>
```java
[
    {
        "id": 1,
        "originAccount": {
            "id": 1,
            "number": "42565-8",
            "agency": "5252",
            "balance": 2000
        },
        "destinationAccount": {
            "id": 2,
            "number": "58566-3",
            "agency": "8686",
            "balance": 3500
        },
        "value": 500,
        "transactionDate": "2021-11-08T17:44:52.29275-03:00"
    },
    {
        "id": 2,
        "originAccount": {
            "id": 1,
            "number": "42565-8",
            "agency": "5252",
            "balance": 2000
        },
        "destinationAccount": {
            "id": 5,
            "number": "51890-2",
            "agency": "3467",
            "balance": 4000
        },
        "value": 500,
        "transactionDate": "2021-11-08T17:47:44.331297-03:00"
    }
]
```    
</details>

<br>
