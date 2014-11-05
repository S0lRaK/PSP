// Paquet
package exempleagenda;

// Imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Conté els mètodes estàtics que permeten accedir a l'arxiu persones.txt
 * Data de creació: 17-10-2014
 * @author José Luis García Mañas
 */
public abstract class GestioArxius
{
	/**
	 * Llegeix les dades de l'arxiu persones.txt i els retorna en forma
	 * d'ArrayList
	 * @return ArrayList amb les dades de les persones
	 */
	public static ArrayList<Persona> llegirPersones()
	{
		// Creem un ArrayList per guardar les dades de l'arxiu
		ArrayList<Persona> persones = new ArrayList<>();
		
		try
		{
			// Obrim l'arxiu per llegir línia a línia
			FileReader fr = new FileReader("persones.txt");
			BufferedReader br = new BufferedReader(fr);
			
			// Llegim cada línia, treiem les dades i les guardem en un objecte
			// de la classe Persona, que afegim a l'ArrayList
			String linia = br.readLine();
			while(linia != null)
			{
				// Separem nom, cognoms i telèfons en diferents cadenes
				String [] dades = linia.split(":", 3);
				String nom = dades[0];
				String cognoms = dades[1];
				String strTelefons = dades[2];
				
				// Separem els telèfons i creem un ArrayList amb ells
				ArrayList<Telefon> telefons = separarTelefons(strTelefons);
				
				// Creem l'objecte i l'afegim a l'ArrayList
				Persona persona = new Persona(nom, cognoms, telefons);
				persones.add(persona);
				
				// Llegim la següent línia
				linia = br.readLine();
			}
			
			// Tanquem l'arxiu
			br.close();
			fr.close();
		}
		
		// Si no existeix l'arxiu no és un error o no fem res
		catch(FileNotFoundException e){}
		
		// En qualsevol altre cas, mostrem un missatge d'error genèric
		catch(Exception e)
		{
			System.out.printf("Error en accedir a l'arxiu persones.txt per " +
					"llegir");
		}
		
		return persones;
	}

	/**
	 * Grava les dades de totes les persones en l'arxiu persones.txt
	 * @param persones ArrayList amb les dades de les persones
	 */
	public static void gravarPersones(ArrayList<Persona> persones)
	{
		try
		{
			// Obrim l'arxiu per gravar
			FileWriter fw = new FileWriter("persones.txt");
			
			// Gravem les dades de cada persona de l'ArrayList
			for(int i = 0; i < persones.size(); i++)
			{
				// Accedim a una persona
				Persona persona = persones.get(i);
				
				// Gravem nom i cognoms
				fw.write(persona.getNom() + ":");
				fw.write(persona.getCognoms() + ":");
				
				// Recuperem l'ArrayList de telèfons de la persona
				ArrayList<Telefon> telefons = persona.getTelefons();
				
				// Accedim a cada telèfon de la persona i el gravem
				for(int j = 0; j < telefons.size(); j++)
				{
					if(j != 0)
					{
						fw.write(":");
					}
					fw.write(telefons.get(j).getTelefon());
				}
				fw.write("\n");
			}
			
			// Tanquem l'arxiu
			fw.close();
		}
		// En cas d'error, mostrem l'error corresponent
		catch(Exception e)
		{
			System.out.printf("Error en accedir a l'arxiu persones.txt per " +
					"gravar");
		}
	}

	/**
	 * Separa els números de telèfon de la cadena rebuda per paràmetre i els
	 * situa en un ArrayList d'objectes de la classe Telefon.
	 * @param strTelefons Cadena amb els números de telèfon
	 * @return ArrayList d'objectes de la classe Telefon
	 */
	private static ArrayList<Telefon> separarTelefons(String strTelefons)
	{
		// Creem l'ArrayList de telèfons on situarem els telèfons de la persona
		ArrayList<Telefon> telefons = new ArrayList<>();
		
		try
		{
			// Separem els números de telèfon en diferents cadenes
			String [] tels = strTelefons.split(":");
			
			// Per cada telèfon creem un objecte de la classe Telefon i l'afegim
			// a l'ArrayList
			for(int i = 0; i < tels.length; i++)
			{
				Telefon telefon = new Telefon(tels[i]);
				telefons.add(telefon);
			}
		}
		// En principi, recollim una excepció si hi ha un telèfon incorrecte.
		// Com que llegim de l'arxiu, això no hauria de passar mai.
		catch(Exception e){}
		
		// Retornem l'ArrayList de telèfons
		return telefons;
	}
}
