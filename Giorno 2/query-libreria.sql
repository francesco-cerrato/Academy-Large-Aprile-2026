--Inserimento all'interno della tabella LIBRI di 10 nuove righe (record)
INSERT INTO LIBRI (id, titolo, autore, genere, anno, prezzo, disponibile)
VALUES 
(1,'Il Signore degli Anelli', 'J.R.R. Tolkien', 'Fantasy', 1991, 25.50, 1),
(2,'1984', 'George Orwell', 'Distopico', 2020, 12.00, 0),
(3,'Il Nome della Rosa', 'Umberto Eco', 'Giallo Storico', 1999, 18.00, 1),
(4,'Il Piccolo Principe', 'Antoine de Saint-Exupéry', 'Fiaba', 2018, 9.90, 0),
(5,'Dune', 'Frank Herbert', 'Fantascienza', 2009, 35.00, 0),
(6,'La Coscienza di Zeno', 'Italo Svevo', 'Romanzo', 1990, 11.50, 1),
(7,'Harry Potter e la Pietra Filosofale', 'J.K. Rowling', 'Fantasy', 1997, 8.00, 1),
(8,'Orgoglio e Pregiudizio', 'Jane Austen', 'Romanzo Rosa', 2019, 8.50, 0),
(9,'Cronache del Ghiaccio e del Fuoco', 'George R.R. Martin', 'Fantasy', 1996, 30.00, 1),
(10,'Fondazione', 'Isaac Asimov', 'Fantascienza', 2017, 19.00, 1);

--Selezione di tutte le righe (record) della tabella libri ordinati per prezzo in modo crescente.
--ASC potrebbe anche essere omesso
SELECT * FROM LIBRI ORDER BY prezzo ASC;

--Selezione di tutte le righe in cui il campo disponibile è true (1)
--e il il valore del campo prezzo è compreso tra 10 e 20
SELECT * FROM LIBRI WHERE disponibile=1 AND prezzo BETWEEN 10 AND 20;
--Versione alternativa più lunga
SELECT * FROM LIBRI WHERE disponibile=1 AND prezzo > 10 AND prezzo < 20;

--Seleziona campi titolo e autore, con rispettivi alias, solo se il campo autore 
--contiene la lettera 'a' compresa tra il primo carattere e l'ultimo carattere
SELECT titolo AS 'book_titles', autore AS 'book_authors' FROM LIBRI 
WHERE autore LIKE '%a%';

--Seleziona tutti i record della tabella LIBRI il cui valore anno
--è compreso tra 2000 e 2015, raggrupati in maniera DESC (decrescente)
--per anno e solamente i primi 5 records (LIMIT 5)
SELECT * FROM LIBRI WHERE anno BETWEEN 2000 AND 2015
ORDER BY anno DESC
LIMIT 5;

--Seleziona tutti i record della tabella LIBRI il cui campo genere è incluso
--tra 'Fantasy' e ' Fantascienza'
SELECT * FROM LIBRI WHERE genere IN('Fantasy','Fantascienza');

--Questo comando COUNT(*) restituisce il numero totale di records/righe (libri) nella tabella LIBRI
SELECT COUNT(*) AS conteggio_libri FROM LIBRI;

--Comando che calcola il prezzo medio, il prezzo minimo e il prezzo massimo dei libri
SELECT AVG(prezzo), MIN(prezzo), MAX(prezzo) FROM LIBRI;

--Il comando seleziona il genere, conta il numero totale di righe 
--e calcola la media della colonna prezzo. 
--Il comando GROUP BY genere raggruppra i risultati in base alla colonna genere
--Il comando ORDER BY numero_libri DESC ordina il risultato finale in base al conteggio creato
SELECT genere, COUNT(*) AS 'numero_libri', AVG(prezzo) AS 'prezzo_medio'
FROM LIBRI
GROUP BY genere
ORDER BY numero_libri DESC;

--Il comando seleziona il genere e conta quanti libri ci sono per ognuno-
--Raggruppa i risultati per il nome del genere
--Filtra i gruppi creati monstrando solo quelli che contano più di 2 libri
SELECT genere, COUNT(*) AS 'numero_libri'
FROM LIBRI
GROUP BY genere
HAVING COUNT(*) > 2;

--IL comando restistusce tutti i titoli dei libri in upper_case (maiuscolo)
--e restistuice la lunghezza totale (length) di ogni titolo di ogni libro
SELECT upper(titolo), length(titolo) FROM LIBRI;


--Il comando ROUND arrotonda il risultato matematico alla seconda cifra decimale
--Il comando CAST... AS DECIMAL assicura che il risultato venga visualizzato con due decimali 
SELECT titolo, prezzo AS 'prezzo_originale',
CAST(ROUND(prezzo * 1.22,2) AS DECIMAL(10,2)) AS prezzo_con_iva
FROM LIBRI;

--Il comando restituisce il titolo e l'anno di ogni libro
--restituisce con YEAR(CURDATE()) l'anno attuale in cui siamo
--con l'operazione YEAR(CURDATE()) - anno calcola quanti anni sono passati dalla pubblicazione
SELECT titolo, anno, 
YEAR(CURDATE()) AS 'anno_corrente',
YEAR(CURDATE()) - anno AS 'anni_passati'
FROM LIBRI;
 


--Il risultato della prima query COUNT(*) è 10.
--Sono stati inseriti dunque 10 records (10 libri)