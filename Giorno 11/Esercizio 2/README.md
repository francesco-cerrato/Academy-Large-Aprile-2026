Endpoint disponibili

GET /api/studenti
Restituisce la lista di tutti gli studenti.

GET /api/studenti/{id}
Restituisce uno studente per ID.
200 OK se trovato
404 NOT FOUND se non esiste

POST /api/studenti
Crea un nuovo studente.
Body esempio:

{
  "nome": "Mario",
  "cognome": "Rossi",
  "email": "mario@email.com",
  "data_Nascita": "2000-01-01",
  "corso_Laurea": "Informatica"
}
201 CREATED


PUT /api/studenti/{id}
Aggiorna uno studente esistente.
200 OK
404 NOT FOUND


DELETE /api/studenti/{id}
Elimina uno studente.
204 NO CONTENT
404 NOT FOUND