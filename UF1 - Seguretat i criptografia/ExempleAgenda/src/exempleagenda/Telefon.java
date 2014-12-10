// Paquet
package exempleagenda;

/**
 * Conté un número de telèfon validat.
 * Data de creació: 17-10-2014
 * @author José Luis García Mañas
 */
public class Telefon
{
	// Atributs de la classe
	private String telefon;

	/**
	 * Constructor parametritzat de la classe Telefon
	 * @param telefon Número de telèfon
	 * @throws Exception Es llença si la cadena rebuda com a paràmetre no conté
	 * un número de telèfon.
	 */
	public Telefon(String telefon) throws Exception
	{
		// Si el telèfon rebut com a paràmetre és un telèfon vàlid, s'assigna a
		// l'atribut i es crea l'objecte; en cas contrari, es llença una
		// excepció
		if(comprovarTelefon(telefon))
		{
			this.telefon = telefon;
		}
		else
		{
			throw new Exception("Telèfon incorrecte");
		}
	}

	/**
	 * Setter per a l'atribut telefon
	 * @param telefon Telèfon que s'ha d'assignar a l'atribut
	 * @throws Exception Cas que el telèfon rebut no sigui un telèfon vàlid,
	 * es llença una excepció i no es fa l'assignació
	 */
	public void setTelefon(String telefon) throws Exception
	{
		if(comprovarTelefon(telefon))
		{
			this.telefon = telefon;
		}
		else
		{
			throw new Exception("Telèfon incorrecte");
		}
	}

	/**
	 * Getter per a l'atribut telefon
	 * @return El número de telèfon en forma de cadena
	 */
	public String getTelefon()
	{
		return telefon;
	}

	/**
	 * Retorna el mateix que el mètode getTelefon
	 * @return El número de telèfon en forma de cadena
	 */
	public String toString()
	{
		return telefon;
	}

	/**
	 * Comprova si el número de telèfon rebut com a paràmetre és un número de
	 * telèfon correcte
	 * @param telefon Número de telèfon a comprovar
	 * @return true si és un telèfon correcte; false si no
	 */
	private boolean comprovarTelefon(String telefon)
	{
		boolean comprovar = true;
		int i = 0;
		
		// Si tots els caràcters que composen la cadena són dígits numèrics,
		// és un telèfon vàlid. En cas contrari, no.
		do
		{
			if(!Character.isDigit(telefon.charAt(i)))
			{
				comprovar = false;
			}
			else
			{
				i++;
			}
		}while(comprovar == true && i < telefon.length());
		
		return comprovar;
	}
}

