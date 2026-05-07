## Test paginazione
GET /api/studenti?page=0&size=2

{
    "content": [
        {
            "nome": "Marcello",
            "cognome": "Aliberti",
            "email": "Marcello.Aliberti@Gmail.com",
            "data_nascita": "2000-11-11",
            "id": 3
        },
        {
            "nome": "Antonio",
            "cognome": "Leo",
            "email": "Antonio.Leo@Gmail.com",
            "data_nascita": "1990-09-12",
            "id": 4
        }
    ],
    "empty": false,
    "first": true,
    "last": false,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 2,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 2,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 3,
    "totalPages": 2
}

## Test ordinamento
GET http://localhost:8080/api/studenti?sort=cognome,asc

{
    "content": [
        {
            "nome": "Marcello",
            "cognome": "Aliberti",
            "email": "Marcello.Aliberti@Gmail.com",
            "data_nascita": "2000-11-11",
            "id": 3
        },
        {
            "nome": "Antonio",
            "cognome": "Leo",
            "email": "Antonio.Leo@Gmail.com",
            "data_nascita": "1990-09-12",
            "id": 4
        },
        {
            "nome": "Giuseppe",
            "cognome": "Leo",
            "email": "Giuseppe.Leo@Gmail.com",
            "data_nascita": "2012-04-03",
            "id": 5
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 3,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 20,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 3,
    "totalPages": 1
}

## Test paginazione + ordinamento
GET http://localhost:8080/api/studenti?page=0&size=3&sort=cognome,desc

{
    "content": [
        {
            "nome": "Antonio",
            "cognome": "Leo",
            "email": "Antonio.Leo@Gmail.com",
            "data_nascita": "1990-09-12",
            "id": 4
        },
        {
            "nome": "Giuseppe",
            "cognome": "Leo",
            "email": "Giuseppe.Leo@Gmail.com",
            "data_nascita": "2012-04-03",
            "id": 5
        },
        {
            "nome": "Marcello",
            "cognome": "Aliberti",
            "email": "Marcello.Aliberti@Gmail.com",
            "data_nascita": "2000-11-11",
            "id": 3
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 3,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 3,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 3,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 3,
    "totalPages": 1
}