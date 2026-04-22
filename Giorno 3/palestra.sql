INSERT INTO SOCI (nome, cognome, email, data_iscrizione, attivo) 
VALUES
('Mario', 'Rossi', 'mario.rossi@email.it', '2023-01-15', 1),
('Laura', 'Bianchi', 'laura.bianchi@email.it', '2023-02-20', 1),
('Giovanni', 'Verdi', 'gio.verdi@email.it', '2023-03-10', 1),
('Anna', 'Neri', 'anna.neri@email.it', '2023-04-05', 0),
('Luca', 'Russo', 'luca.russo@email.it', '2023-05-12', 1);

INSERT INTO CORSI (nome, istruttore, max_partecipanti, livello)
VALUES 
('Yoga Dolce', 'Maria Rossi', 15, 'Principiante'),
('Cross Training', 'Luca Bianchi', 10, 'Avanzato'),
('Pilates Matwork', 'Anna Verdi', 20, 'Intermedio');

SELECT * FROM SOCI;
SELECT * FROM CORSI;
SELECT * FROM ISCRIZIONI;

INSERT INTO ISCRIZIONI(socio_id, corso_id,data_iscrizione)
VALUES (2,1,'2024-01-02'),
(4,3,'2024-02-05');

UPDATE SOCI SET email='mario.rossi.2000@email.it'
WHERE id=1;

UPDATE SOCI SET attivo=0
WHERE id=3;

ALTER TABLE CORSI
ADD costo_mensile DECIMAL(6,2);

UPDATE CORSI
SET costo_mensile = 99.99;

SELECT SOCI.nome AS nome_socio,
SOCI.cognome AS cognome_socio,
CORSI.nome AS nome_corso,
ISCRIZIONI.data_iscrizione AS data_iscrizione_socio
FROM SOCI 
INNER JOIN ISCRIZIONI  ON SOCI.id = ISCRIZIONI.id
INNER JOIN CORSI ON ISCRIZIONI.socio_id = CORSI.id
WHERE SOCI.attivo = 1;

SELECT CORSO_id, COUNT(*) AS numero_iscrizioni
FROM Iscrizioni
GROUP BY corso_id;