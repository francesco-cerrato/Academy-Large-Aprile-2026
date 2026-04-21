--Creazione nuova tabella con 7 campi,ossia 7 colonne:
--due interi, tre stringhe da 100 caratteri massimo, un valore decimale e un valore booleano
CREATE TABLE LIBRI
(
	id INT,
	titolo VARCHAR(100),
	autore VARCHAR(100),
	genere VARCHAR(100),
	anno INT,
	prezzo DECIMAL(10,2),
	disponibile BOOL
)