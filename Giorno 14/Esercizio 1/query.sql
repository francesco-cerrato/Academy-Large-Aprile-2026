

/*
    Creazione tabella users se non esiste già,
    La clausola IF NOT EXISTS è una protezione: 
    evita che il database restituisca un errore 
    se la tabella è già presente.
    Il campo "username" di tipo stringa 
    (fino a 100 caratteri) è la chiave primaria
    unica per identificare ogni specifico utente.
    Il campo "password" contiene la password dell'utente
    eventualmente hashtata (cripatata)
*/
CREATE TABLE IF NOT EXISTS users
(
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

/*
    Creazione tabella authorities se non esiste già.
    In questa tabella è presente una FOREIGN KEY (chiave
    esterna).
    Innanzitutto CONSTRAINT definisce un vincolo di
    integrità per collegare le tabelle. FOREIGN KEY
    imposta la colonna "username" come chiave esterna.
    In fine con REFERECENS si specifica che ogni valore
    deve esistere nella colonna "username" della tabella
    "users". L'hash bcrypt richiede che il campo della 
    tabella sia lungo almeno 68 caratteri
*/
CREATE TABLE IF NOT EXISTS authorities
(
    username VARCHAR(100) NOT NULL,
    authority VARCHAR(100) NOT NULL,
    CONSTRAINT fk_authorities_users 
    FOREIGN KEY(username) 
    REFERENCES users(username)
);

/*
    Spring cerca per default le tabelle 
    "users" e "authorities".
*/

/* 
    All'intero della INSERT TO query si può anche omettere
    di specificare ogni singolo campo della tabella
    quando si inseriscono tutti i valori in VALUES.

    Il prefisso {noop} indica a Spring Security 
    che la password è in testo in chiaro (non hashata).

    Il prefisso {bcrypt} è uno standard per 
    l'hashing (cripatzione) delle password
*/
INSERT INTO users (username, password, enabled)
VALUES ('admin', '{noop}test123', true);

INSERT INTO authorities
VALUES ('admin', 'ROLE_admin');

INSERT INTO users
VALUES ('user', '{noop}test123', true);

INSERT INTO authorities
VALUES ('user', 'ROLE_user');


/*
    Questa UPDATE query modifica il campo "password"
    della tabella "users" inserendo l'hash (la password
    cripata) generata tramite 
    Bcrypt Generator:
    https://bcrypt-generator.com/
*/
UPDATE users
SET password = '$2a$12$b4snyIxlFST9omDL18/hYOS1aduIqHRHu0WYHQ1uJIquywGDbJI9e'
WHERE username = 'admin';

UPDATE users
SET password = '$2a$12$EpqjYwYhWC180U27R0mRy.f5gnQ6FMWisYTBf0xpPjZYLzZQu0y/a'
WHERE username = 'user';




/*
    Il codice SQL sottostante è utilizzato per 
    customizzare (personalizzare) i nomi 
    delle tabelle specifiche di "users" e "authorities"
    rilevate di default

    IMPORTANTE: Le table "users" ed "authorities"
    se create ed inserite nel DB vanno a coprire
    i dati inseriti nelle nuove table "members" e
    "roles"... Dunque per evitare ogni problema
    è necessario eseguire solamente i codici SQL 
    sottostanti, evitando dunque di creare e riempire
    le default table "users" e "authorities"
*/

CREATE TABLE IF NOT EXISTS members
(
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);


CREATE TABLE IF NOT EXISTS roles
(
    username VARCHAR(100) NOT NULL,
    authority VARCHAR(100) NOT NULL,
    CONSTRAINT fk_authorities_users 
    FOREIGN KEY(username) 
    REFERENCES members(username)
);

INSERT INTO members (username, password, enabled)
VALUES ('admin', '{noop}test123', true);

INSERT INTO roles
VALUES ('admin', 'ROLE_admin');

INSERT INTO members
VALUES ('user', '{noop}test123', true);

INSERT INTO roles
VALUES ('user', 'ROLE_user');

UPDATE members
SET password = '$2a$12$b4snyIxlFST9omDL18/hYOS1aduIqHRHu0WYHQ1uJIquywGDbJI9e'
WHERE username = 'admin';

UPDATE members
SET password = '$2a$12$EpqjYwYhWC180U27R0mRy.f5gnQ6FMWisYTBf0xpPjZYLzZQu0y/a'
WHERE username = 'user';