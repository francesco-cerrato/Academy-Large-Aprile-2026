package packageProjectGiorno6;

public class Prodotto 
{
	//Elenco parametri
	private String nome;
	private double prezzo;
	private boolean disponibile;
	
	public Prodotto()
	{
		//Costruttore vuoto richiesto per JavaBean
		/*
		 * il costruttore della classe deve essere vuoto (senza argomenti) 
		 * per consentire al container JSP (come Apache Tomcat) di istanziare la classe dinamicamente.
		 */
	}
	
	public Prodotto(String nome, double prezzo, boolean disponibile)
	{
		this.nome = nome;
		this.prezzo = prezzo;
		this.disponibile = disponibile;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}
	
	
}
