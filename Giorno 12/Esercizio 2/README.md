Nota:
- Le richieste diverse da GET /api/studenti richiedono autenticazione.
- Autenticazione configurata con Basic Auth.

## Endpoint API Studenti

| URL                         | Metodo | Accesso        |
|-----------------------------|--------|----------------|
| /api/studenti               | GET    | Tutti          |
| /api/studenti/cerca         | GET    | USER / ADMIN   |
| /api/studenti/{id}          | GET    | USER / ADMIN   |
| /api/studenti/{id}/corso    | GET    | USER / ADMIN   |
| /api/studenti               | POST   | USER / ADMIN   |
| /api/studenti/{id}          | PUT    | USER / ADMIN   |
| /api/studenti/{id}          | DELETE | USER / ADMIN   |