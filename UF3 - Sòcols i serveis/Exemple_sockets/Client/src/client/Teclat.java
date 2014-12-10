/* =============================================================================
 * Aplicació:
 * Arxiu:			Teclat.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté diferents mètodes per llegir dades des del teclat, en
 *					funció del tipus de dada a llegir.
 * ========================================================================== */

// Paquet
package client;

// Imports
import java.io.*;

// Classe Teclat
public class Teclat
{
	// Atributs
	private static InputStreamReader isr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);

	/* -------------------------------------------------------------------------
	 * Mètode llegirTeclatString
	 * Paràmetres d'entrada:	cap
	 * Retorn:					String La cadena llegida des del teclat.
	 * Descripció:	Llegeix una cadena des del teclat i la retorna. Si es
	 *				produeix un error d'entrada/sortida, mostra un missatge
	 *				d'error i retorna una cadena buida.
	 * ---------------------------------------------------------------------- */
	public static String llegirTeclatString() throws IOException
	{
		// Inicialitzem la cadena a cadena buida. Si es produeix algun error,
		// es retornarà aquest valor
		String s = "";

		// Si no es produeix cap error, es retornarà la cadena llegida
		try
		{
			s = br.readLine();
		}
		// Si es produeix un error d'entrada/sortida, es mostrarà un missatge
		// d'error
		catch(IOException e)
		{
			throw new IOException("No s'ha pogut llegir la cadena des del " +
					"teclat");
		}

		return s;
	}

	/* -------------------------------------------------------------------------
	 * Mètode llegirTeclatChar
	 * Paràmetres d'entrada:	cap
	 * Retorn:					char El caràcter llegit des del teclat.
	 * Descripció:	Llegeix un caràcter des del teclat i el retorna. Si es
	 *				produeix un error d'entrada/sortida o bé allò introduït no
	 *				és un caràcter, mostra un missatge d'error i retorna un
	 *				caràcter buit.
	 * ---------------------------------------------------------------------- */
	public static char llegirTeclatChar() throws IOException,
												 CharacterFormatException
	{
		// Inicialitzem el caràcter a caràcter buit. Si es produeix algun error,
		// es retornarà aquest valor
		char c = 0;

		// Si no es produeix cap error, es retornarà el caràcter llegit
		try
		{
			String s = br.readLine();

			// Controlem que el que s'ha llegit és un caràcter
			if(s.length() == 1)
			{
				c = s.charAt(0);
			}
			else
			{
				throw new CharacterFormatException();
			}
		}
		// Si es produeix un error d'entrada/sortida, es mostrarà un missatge
		// d'error
		catch(IOException e)
		{
			throw new IOException("No s'ha pogut llegir el caràcter des del " +
					"teclat.");
		}
		// Si s'introdueix quelcom que no sigui un caràcter, es mostra un
		// missatge d'error
		catch(CharacterFormatException e)
		{
			throw new CharacterFormatException("La dada introduïda no és un " +
					"caràcter.");
		}

		return c;
	}

	/* -------------------------------------------------------------------------
	 * Mètode llegirTeclatInt
	 * Paràmetres d'entrada:	cap
	 * Retorn:					int El número enter llegit des del teclat.
	 * Descripció:	Llegeix un número enter des del teclat i el retorna. Si es
	 *				produeix un error d'entrada/sortida o bé allò introduït no
	 *				és un número enter, mostra un missatge d'error i retorna
	 *				zero.
	 * ---------------------------------------------------------------------- */
	public static int llegirTeclatInt() throws IOException,
											   NumberFormatException
	{
		// Inicialitzem el número a 0. Si es produeix algun error, es retornarà
		// aquest valor
		int i = 0;

		// Si no es produeix cap error, es retornarà el número llegit
		try
		{
			String s = br.readLine();
			i = Integer.parseInt(s);
		}
		// Si es produeix un error d'entrada/sortida, es mostrarà un missatge
		// d'error
		catch(IOException e)
		{
			throw new IOException ("No s'ha pogut llegir el número enter des " +
					"del teclat.");
		}
		// Si s'introdueix quelcom que no sigui un número enter, es mostra un
		// missatge d'error
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("La dada introduïda no és un " +
					"número enter.");
		}

		return i;
	}

	/* -------------------------------------------------------------------------
	 * Mètode llegirTeclatDouble
	 * Paràmetres d'entrada:	cap
	 * Retorn:					int El número real llegit des del teclat.
	 * Descripció:	Llegeix un número real des del teclat i el retorna. Si es
	 *				produeix un error d'entrada/sortida o bé allò introduït no
	 *				és un número real, mostra un missatge d'error i retorna
	 *				zero.
	 * ---------------------------------------------------------------------- */
	public static double llegirTeclatDouble() throws IOException,
													 NumberFormatException
	{
		// Inicialitzem el número a 0. Si es produeix algun error, es retornarà
		// aquest valor
		double d = 0D;

		// Si no es produeix cap error, es retornarà el número llegit
		try
		{
			String s = br.readLine();
			d = Double.parseDouble(s);
		}
		// Si es produeix un error d'entrada/sortida, es mostrarà un missatge
		// d'error
		catch(IOException e)
		{
			 throw new IOException("No s'ha pogut llegir el número des del " +
					 "teclat.");
		}
		// Si s'introdueix quelcom que no sigui un número real, es mostra un
		// missatge d'error
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("La dada introduïda no és un " +
					"número real.");
		}

		return d;
	}
}
// =============================================================================
