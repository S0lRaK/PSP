package servidor;

/* =============================================================================
 * Aplicació:
 * Arxiu:			CharacterFormatException.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté la classe-excepció CharacterFormatException.
 *					L'excepció es produirà quan una cadena no conté un sol
 *					caràcter.
 * ========================================================================== */
public class CharacterFormatException extends Exception
{
	public CharacterFormatException()
	{
	}

	public CharacterFormatException(String s)
	{
		super(s);
	}
}
