// Paquet
package exempleagenda;

// Import
import java.util.ArrayList;

/**
 * Conté les dades d'una persona (nom, cognoms i telèfons) per a l'agenda.
 * Data de creació: 17-10-2014
 * @author José Luis García Mañas
 */
public class Persona
{
	// Atributs
	private String nom;
	private String cognoms;
	private ArrayList<Telefon> telefons;

	/**
	 * Constructor parametritzat de la classe
	 * @param nom Nom de la persona
	 * @param cognoms Cognoms de la persona
	 * @param telefons Telèfons de la persona
	 */
	public Persona(String nom, String cognoms, ArrayList<Telefon> telefons)
	{
		this.nom = nom;
		this.cognoms = cognoms;
		this.telefons = telefons;
	}
	
	/**
	 * Constructor parametritzat de la classe (sense els telèfons)
	 * @param nom Nom de la persona
	 * @param cognoms Cognoms de la persona	 */
	public Persona(String nom, String cognoms)
	{
		this.nom = nom;
		this.cognoms = cognoms;
		telefons = new ArrayList<>(); // Creem un ArrayList buit pels telèfons
	}

	/**
	 * Setter per l'atribut non
	 * @param nom Nom de la persona
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Setter per l'atribut cognoms
	 * @param cognoms Cognoms de la persona
	 */
	public void setCognoms(String cognoms)
	{
		this.cognoms = cognoms;
	}

	/**
	 * Setter per l'atribut Telefons
	 * @param telefons ArrayList amb els telèfons de la persona
	 */
	public void setTelefons(ArrayList<Telefon> telefons)
	{
		this.telefons = telefons;
	}

	/**
	 * Getter per l'atribut non
	 * @return Nom de la persona
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Getter per l'atribut cognoms
	 * @return Cognoms de la persona
	 */
	public String getCognoms()
	{
		return cognoms;
	}

	/**
	 * Getter per l'atribut telefons
	 * @return ArrayList amb els telèfons de la persona
	 */
	public ArrayList<Telefon> getTelefons()
	{
		return telefons;
	}

	/**
	 * Afegeix un telèfon a la llista de telèfons de la persona
	 * @param telefon Telèfon a afegir a la llista de telèfons
	 */
	public void afegirTelefon(Telefon telefon)
	{
		telefons.add(telefon);
	}

	/**
	 * Retorna el nom i els cognoms de la persona
	 * @return Cadena amb el nom i els cognoms de la persona
	 */
	public String toString()
	{
		return nom + " " + cognoms;
	}
}
