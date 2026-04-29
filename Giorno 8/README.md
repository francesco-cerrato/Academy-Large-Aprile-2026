# Installazione e Import del progetto
Tramite il sito web start.spring.io, chiamato anche Spring Initializr, ho generato un'applicazione Java impostando il campo Group (identificativo del gruppo/azienda) come "com.academy" e il campo Artifact (identificativo del progetto Spring Boot) come "primo-progetto". In aggiunta ho inserito, nel app generata, le seguenti dipendenze: Spring Web, Spring Boot DevTools e Spring Boot Actuator. Scaricato il file zip, l'ho estratto e importato sull'IDE IntelliJ IDEA.

# Avvio tramite IDE
1. Importazione progetto -> File > Open
2. Individua la classe main annodata con `@SpringBootApplication`
3. Click destro sul file e seleziona "Run 'PrimoProgettoApplication.main()'"
4. L'applicazione sarà disponibile su "http://localhost:8080". Successivamente, all'interno del file properties, la porta verrà sostituita con 8081.  

# Elenco endpoint
1. /saluto: restituisce il valore String "Ciao dal mio primo Spring Boot!!!". Ogni ritorno, di tutti i metodi, sarà visualizzato sulla specifica pagina web.
2. /info: restiuisce un JSON composto dalla Key "Autore" e dal valore contenuto nella variabile String "nomeAutore". In questo caso sarà "Autore: Francesco Cerrato".
3. /app-info: restituisce una Stringa con il valore delle tre proprietà personalizzate aggiunte nel file principale .properties.
4. /configurazione-server: restituisce una stringa contente il numero della porta in ascolto, e dunque funzionante, del progetto/sito web.
