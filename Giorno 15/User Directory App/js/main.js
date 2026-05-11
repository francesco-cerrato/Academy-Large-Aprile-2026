/*
    Funzione asincrona che effettua una richiesta HTTP GET per recuperare gli utenti.
    Ritorna una Promise che, se risolta, conterrà l'array dei dati JSON.
 */
function fetchUsers()
{
   
    return fetch('https://jsonplaceholder.typicode.com/users')
        .then ( response => {
            /* 
                Controlla se la risposta del server è andata a buon fine.
                Converte il corpo della risposta in formato JSON
            */
            if (!response.ok) throw new Error('Risposta non valida');
            return response.json(); // Converte in JSON
        })
        .then (data => {
            // Ritorna i dati convertiti al blocco successivo della catena .then()
            return data;
        })
        .catch( error => {
            console.error("Errore: " + error);
        })
}

let usersList = [];


// Chiamata alla funzione di fetch e gestione della Promise risultant
fetchUsers().then(data => {
    usersList = data; 
    console.log("Dati salvati nella variabile:", usersList);

    // Chiamo la funzione SOLO ORA che i dati sono disponibili
    renderUsersList(usersList);
});

/*
    Funzione responsabile della manipolazione del DOM per mostrare la lista degli utenti nell'HTML.
    Accetta un array di utenti (può essere l'elenco completo o un elenco filtrato).
 */
function renderUsersList(renderList)
{

    const usersUnorderedList = document.getElementById("usersList");
    usersUnorderedList.innerHTML = ""; //elimino ogni elemento non dinamico in HTML usato per creare il template
      // Ciclo for...of utilizzato per iterare gli oggetti contenuti all'interno dell'array passato come parametro
    for (let utente of renderList) 
    {
        // Ogni 'utente' è un oggetto. Accediamo alle sue proprietà (es. id, name, username)

        const newElement = document.createElement("li");

        newElement.innerHTML = "<strong>" + utente.name + "</strong> <br> <span>" + utente.email + "</span> <br> <a href=" 
        + "'https://jsonplaceholder.typicode.com/users/" + utente.id + "' target='_blank'>Dettagli utente </a>";

        newElement.classList.add("list_card");

        /*
            Struttura HTML della card che si intende generare dinamicamente:
            <li class="list_card"> 
                <strong> Mario Rossi </strong> 
                <br>
                <span>Mario.Rossi@gmail.com </span> 
                <br>
                <a href="https://www.google.com"> Dettagli utente </a>
            </li>
        */


        // Appende (inserisce) il tag <li> appena configurato come figlio diretto dell'elemento <ul> nella pagina
        usersUnorderedList.appendChild(newElement);
    }

}

/*
    Funzione di ricerca avviata ad ogni digitazione dell'utente grazie all'evento "oninput" del campo di testo.
*/
function findUser()
{
    const inputSearchUsers = document.getElementById("inputSearchUser");
    let inputText = inputSearchUsers.value;

    // Filtra l'array originale creando una nuova lista filtrata
    const filteredUsers = usersList.filter(utente => 
        utente.name.toLowerCase().includes(inputText.toLowerCase())
    );

    renderUsersList(filteredUsers);
    
}




