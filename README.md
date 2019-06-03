- [StarWarsApplication](#StarWarsApplication)
    - [Introdução](#introdução)
    - [API endpoints](#api-endpoints)
        - [GET /api/planetas/]
        - [GET /api/planetas/{id}]
        - [GET /api/planetas/nome/{nome}]
        - [GET /api/planetas/init]
        - [POST /api/planetas/novo]
        - [DELETE /planetas/{id}]
        
    - [Executando a app](#executando-a-app)

<!-- /TOC -->

## Introdução

StarWarsApplication é uma API REST feita para armazenar uma coleção de planetas da série Star Wars.  

Escrita em Java com framework SPRING-BOOT e usando base de dados H2 (banco em memória).  

O json abaixo exemplifica um típico "Planeta Star Wars":
```
 {
        "id": 2,
        "nome": "Hoth",
        "clima": "gelado",
        "terreno": "cavernas de gelo, tundras"
    }
```
## API endpoints

### GET /api/planetas/
**Description:** retorna todos os planetas cadastrados.  
**Response Codes:** 200 - Successo.  
**Response Data:** O Json com a lista de planetas cadastrados. Se não houverem planetas cadastrados será retornado HTTP 200 e no body um json de um array vazio `[]`     

### GET /api/planetas/{id}
**Description:** busca um planeta usando o seu id  
**Response Codes:** 200 - Successo. 404 - Planeta não encontrado.  
**Response Data:** Retorna o json de um planeta   
Ex: ` "data": {
        "id": 1,
        "nome": "Dagobah",
        "clima": "obscuro",
        "terreno": "pântano, selvas"
    }`  

### GET /api/planetas/nome/{nome}
**Description:** busca um planeta usando o seu nome  
**Query Params:** `nome`, obrigatório, o nome do planeta a ser buscado.  
**Response Codes:** 200 - Successo. 404 - Planeta não encontrado.  
**Response Data:** Retorna o json de um planeta  
Ex: ` "data": {
        "id": 1,
        "nome": "Dagobah",
        "clima": "obscuro",
        "terreno": "pântano, selvas"
    }`  

### GET /api/planetas/init/
**Description:** Inicializa alguns planetas na base em memória.
**Response Data:** Retorna o json dos planetas incluídos
Ex: 
```
[
    {
        "id": 1,
        "nome": "Endor",
        "clima": "quente",
        "terreno": "deserto"
    },
    {
        "id": 2,
        "nome": "Dagobah",
        "clima": "obscuro",
        "terreno": "pântano, selvas"
    },
    {
        "id": 3,
        "nome": "Hoth",
        "clima": "gelado",
        "terreno": "cavernas de gelo, tundras"
    }]
```  

### POST /api/planetas/novo
**Description:** Insere um novo planeta.  
**Request body:** Enviar um JSON com os campos "nome", "clima" e "terreno". O campo "nome" não pode ser nulo.
Ex: 
```
{
   "nome": "Endor",
   "clima": "quente",
   "terreno": "deserto"
}
```  
**Response Codes:** 201 (Created) - Criado com sucesso.
**Response Data:** Retorna o objeto criado, com o campo id preenchido.  
Ex: `"data": {
        "id": 5,
        "nome": "Endor",
        "clima": "quente",
        "terreno": "deserto"
    }`

### DELETE /api/planetas/{id}
**Description:** deleta o planeta identificado pelo id.  
**Response Codes:** 204 (No Content) - Planeta deletado com Successo. 404 - Planeta não encontrado.  


## Executando a app  


Uma vez que o código da aplicação disponível em uma pasta local, entrar no diretório onde está o pom.xml e rodar os seguintes comandos:

**compilar a app:** `mvn compile`  
**rodar a aplicação:** `mvn spring-boot:run`

