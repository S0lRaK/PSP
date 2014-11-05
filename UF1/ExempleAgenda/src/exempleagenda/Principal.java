// Paquet
package exempleagenda;

// Imports
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Conté la lògica del programa que permet la interacció entre usuari i 
 * aplicació, amb el menú i les seves opcions.
 * Data de creació: 17-10-2014
 * @author José Luis García Mañas
 */
public class Principal
{

	/**
	 * Punt d'entrada del programa i crides a les opcions de menú.
	 * @param args Aquest programa no rep paràmetres des de la línia de comandes
	 */
	public static void main(String[] args)
	{
		int opcio;

		// Repetirem fins que l'usuari esculli l'opció 0 (sortir)
		do
		{
			// Demanem l'opció a l'usuari
			opcio = menu();
			
			// Anem a l'opció escollida
			switch(opcio)
			{
				case 1:
					opcioMostrarPersones();
					break;
				case 2:
					opcioMostrarTelefonsPersona();
					break;
				case 3:
					opcioAfegirPersona();
					break;
				case 4:
					opcioModificarPersona();
					break;
				case 5:
					opcioEliminarPersona();
					break;
				case 0:
					System.out.println("Fins aviat!");
					break;
				default:
					System.out.println("Opció errònia");
					break;
			}
		}while(opcio != 0);
	}

	/**
	 * Mostra a l'usuari les opcions de menú i retorna l'opció escollida
	 * @return Opció escollida per l'usuari
	 */
	private static int menu()
	{
		int opcio = -1;
		
		try
		{
			// Mostrem a les opcions a l'usuari
			System.out.println("\n\nMENÚ PRINCIPAL\n");

			System.out.println("1. Mostrar totes les persones");
			System.out.println("2. Mostrar telèfons d'una persona");
			System.out.println("3. Afegir persona");
			System.out.println("4. Modificar persona");
			System.out.println("5. Eliminar persona");
			System.out.println("0. Sortir\n");

			// Demanem l'opció a l'usuari
			System.out.print("Opció: ");
			Scanner sc = new Scanner(System.in);
			opcio = sc.nextInt();
		}
		// Si es produeix una opció en la introducció de l'opció, no fem res
		// (retornarem -1, o sigui, opció incorrecta)
		catch(Exception e){}

		return opcio;
	}

	/**
	 * Opció que mostra el nom i cognoms de totes les persones de l'agenda
	 */
	private static void opcioMostrarPersones()
	{
		System.out.println("\n\nLLISTA DE PERSONES\n");
		
		// Recollim la llista de persones de l'arxiu en un ArrayList
		ArrayList<Persona> persones = GestioArxius.llegirPersones();
		
		// Calculem el total de persones
		int numPersones = persones.size();
		
		// Si hi ha persones emmagatzemades, es mostren
		if(numPersones > 0)
		{
			for(int i = 0; i < numPersones; i++)
			{
				Persona persona = persones.get(i);
				System.out.println(persona.toString());
			}
		}
		// Si no hi ha persones emmagatzemades, mostrem un missatge informatiu
		else
		{
			System.out.println("No hi ha cap persona guardada");
		}
	}

	/**
	 * Opció que mostra els telèfons d'una persona escollida per teclat
	 */
	private static void opcioMostrarTelefonsPersona()
	{
		System.out.println("\n\nMOSTRAR TELÈFONS D'UNA PERSONA\n");
		
		// Demanem les dades d'una persona i les recuperem des de l'arxiu
		Persona persona = demanarDadesPersona();

		// Cas que la persona estigui a l'agenda, mostrem els seus telèfons
		if(persona != null)
		{
			mostrarTelefons(persona.getTelefons());
		}
		
		// En cas contrari, mostrem un missatge informatiu
		else
		{
			System.out.println("Persona no trobada");
		}
	}
	
	/**
	 * Opció que afegeix les dades d'una persona a l'agenda
	 */
	private static void opcioAfegirPersona()
	{
		System.out.println("\n\nAFEGIR PERSONA\n");

		// Demanem les dades de la persona
		Scanner sc = new Scanner(System.in);
		System.out.print("Nom: ");
		String nom = sc.nextLine();
		System.out.print("Cognoms: ");
		String cognoms = sc.nextLine();
		
		// Recuperem la llista de persones de l'agenda i comprovem si la persona
		// hi és
		ArrayList<Persona> persones = GestioArxius.llegirPersones();
		Persona persona = cercaPersona(persones, nom, cognoms);
		
		// Cas que la persona no hi sigui, l'afegim i demanem els telèfons
		if(persona == null)
		{
			// Creem la nova persona
			Persona novaPersona = new Persona(nom, cognoms);
			
			// Demanem els seus telèfons
			demanarTelefons(novaPersona);
			
			// Afegim la nova persona a l'agenda
			persones.add(novaPersona);
			
			// Tornem a gravar la llista de persones a l'agenda
			GestioArxius.gravarPersones(persones);
			
			// Mostrem un missatge informatiu per pantalla
			System.out.println("Persona introduïda");
		}
		// En cas contrari, mostrem un missatge informatiu per pantalla i no
		// l'afegim
		else
		{
			System.out.println("Aquesta persona ja havia estat introduïda");
		}
	}

	/**
	 * Opció que permet modificar les dades d'una persona de l'agenda
	 */
	private static void opcioModificarPersona()
	{
		System.out.println("\n\nMODIFICAR PERSONA\n");

		// Recuperem la llista de persones de l'agenda
		ArrayList<Persona> persones = GestioArxius.llegirPersones();

		// Demanem les dades de la persona i les recuperem
		Persona persona = demanarDadesPersona(persones);
		
		// Si la persona és a l'agenda...
		if(persona != null)
		{
			// Demanem les dades a modificar
			modificarPersona(persona);	
			
			// Tornem a guardar la llista de persones a l'agenda
			GestioArxius.gravarPersones(persones);
			
			// Mostrem un missatge informatiu
			System.out.println("Persona modificada");
		}
		// Cas que la persona no estigui a l'agenda, mostrem un missatge
		// informatiu i no fem res més
		else
		{
			System.out.println("No s'ha trobat la persona");
		}		
	}

	/**
	 * Opció que permet eliminar una persona de l'agenda
	 */
	private static void opcioEliminarPersona()
	{
		System.out.println("\n\nELIMINAR PERSONA\n");

		// Recuperem la llista de persones de l'agenda
		ArrayList<Persona> persones = GestioArxius.llegirPersones();

		// Demanem les dades de la persona i les recuperem
		Persona persona = demanarDadesPersona(persones);
		
		// Si la persona és a l'agenda...
		if(persona != null)
		{
			// Eliminem la persona de la llista de persones
			persones.remove(persona);
			
			// Tornem a gravar la llista de persones a l'arxiu
			GestioArxius.gravarPersones(persones);
			
			// Mostrem un missatge informatiu
			System.out.println("Persona eliminada");
		}
		// Cas que la persona no estigui a l'agenda, mostrem un missatge
		// informatiu i no fem res més
		else
		{
			System.out.println("No s'ha trobat la persona");
		}		
	}

	/**
	 * Mostra per pantalla els telèfons d'una llista de telèfons
	 * @param telefons ArrayList amb la llista de telèfons a mostrar
	 */
	private static void mostrarTelefons(ArrayList<Telefon> telefons)
	{
		int numTelefons = telefons.size();	// Nº d'elements de la llista
		
		// Si hi ha telèfons a la llista
		if(numTelefons > 0)
		{
			// Mostrem els telèfons de la llista
			for(int i = 0; i < numTelefons; i++)
			{
				System.out.println((i + 1) + ": " + 
						telefons.get(i).toString());
			}
		}
		// Si no hi ha telèfons a la llista, mostrem un missatge informatiu
		else
		{
			System.out.println("No s'han introduït telèfons per aquesta " + 
					"persona");
		}
	}

	/**
	 * Demana per pantalla els telèfons de la persona rebuda per paràmetre i els 
	 * afegeix a la llista de telèfons de la persona
	 * @param persona Persona a la que volem afegir telèfons
	 */
	private static void demanarTelefons(Persona persona)
	{
		// Demanarem telèfons a l'usuari fins que premi Intro sense introduir
		// cap telèfon
		System.out.println("\nIntroducció de telèfons");
		System.out.println("-----------------------");
		System.out.println("(Intro per sortir)\n");
		
		// Creem un objecte de la classe Scanner per accedir al teclat
		Scanner sc = new Scanner(System.in);
		String strTel;
		
		// Sortirem del bucle quan l'usuari premi intro sense introduir cap
		// telèfon
		do
		{
			// Llegim un telèfon des del teclat com a cadena
			System.out.println("Introdueix telèfon: ");
			strTel = sc.nextLine();
			
			// Si s'ha introduït algun telèfon...
			if(!strTel.equals(""))
			{
				// Creem un objecte amb el telèfon llegit
				Telefon telefon = crearTelefon(strTel);
				
				// Si era un telèfon vàlid, l'afegim a l'ArrayList
				if(telefon != null)
				{
					persona.afegirTelefon(telefon);
				}
			}
		}
		while(!strTel.equals(""));
	}

	/**
	 * Crea un objecte de la classe Telefon a partir del telèfon rebut com a 
	 * paràmetre com a cadena
	 * @param strTel El telèfon que s'ha de transformar en objecte de la classe 
	 * Telefon
	 * @return Objecte de la classe Telefon amb el telèfon rebut per paràmetre
	 */
	private static Telefon crearTelefon(String strTel)
	{
		// Cas que sigui un telèfon incorrecte, retornarem null
		Telefon telefon = null; 
		
		// Creem un objecte de la classe Telefon si és un telèfon vàlid
		try
		{
			telefon = new Telefon(strTel);
		}
		// Si no és un telèfon vàlid, mostrem un missatge informatiu per
		// pantalla i no el creem (retornem null)
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		return telefon;
	}

	/**
	 * Mostra les opcions de modificació de les dades d'una persona i crida als
	 * mètodes que s'encarreguen de fer la modificació. Només es modificarà una
	 * dada de la persona.
	 * @param persona Persona de la qual s'han de modificar les dades
	 */
	private static void modificarPersona(Persona persona)
	{
		int opcio;
		
		// Mostra les opcions de modificació i retorna l'opció escollida
		opcio = menuModificar();

		// En funció de l'opció escollida, crida al mètode adequat
		switch(opcio)
		{
			case 1:
				opcioModifNom(persona);
				break;
			case 2:
				opcioModifCognoms(persona);
				break;
			case 3:
				opcioAfegirTelefon(persona);
				break;
			case 4:
				opcioEliminarTelefon(persona);
				break;
			case 0:
				break;
			default:
				System.out.println("Opció errònia");
				break;
		}
	}

	/**
	 * Mostra el menú per modificar dades d'un usuari i retorna l'opció 
	 * escollida per l'usuari
	 * @return Opcio escollida per l'usuari
	 */
	private static int menuModificar()
	{
		int opcio = -1;
		
		try
		{
			// Mostrem les opcions de modificació d'una persona
			System.out.println("\nOpcions de modificació");
			System.out.println("----------------------\n");
			System.out.println("1. Modificar nom");
			System.out.println("2. Modificar cognoms");
			System.out.println("3. Afegir telèfon");
			System.out.println("4. Eliminar telèfon");

			// Recollim l'opció escollida per l'usauri
			System.out.print("Opció: ");
			Scanner sc = new Scanner(System.in);
			opcio = sc.nextInt();
		}
		catch(Exception e){} // Si l'opció és incorrecta, no fem res i retornem
							 // -1
		return opcio;
	}

	/**
	 * Opció que permet modificar el nom d'una persona
	 * @param persona Persona de la que s'ha de modificar el nom
	 */
	private static void opcioModifNom(Persona persona)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNou nom: ");
		String nouNom = sc.nextLine();
		persona.setNom(nouNom);		
	}

	/**
	 * Opció que permet modificar les cognoms d'una persona
	 * @param persona Persona de la que s'ha de modificar els cognoms
	 */
	private static void opcioModifCognoms(Persona persona)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNous cognoms: ");
		String nousCognoms = sc.nextLine();
		persona.setNom(nousCognoms);		
	}

	/**
	 * Opció que permet afegir un telèfon a una persona
	 * @param persona Persona a la que s'afegirà el telèfon
	 */
	private static void opcioAfegirTelefon(Persona persona)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("\nNou telèfon: ");
			String nouTelefon = sc.nextLine();
			Telefon telefon = new Telefon(nouTelefon);
			persona.afegirTelefon(telefon);
		}
		// Tenim en compte la possibilitat que el telèfon sigui incorrecte
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	/**
	 * Opció que permet eliminar un telèfon d'una persona
	 * @param persona Perosna de la que s'eliminarà un telèfon
	 */
	private static void opcioEliminarTelefon(Persona persona)
	{
		try
		{
			// Mostrem la llista de telèfons
			System.out.println("\nTelèfons: ");
			mostrarTelefons(persona.getTelefons());
			
			// Demanem quin telèfon es vol eliminar
			System.out.println("Opció: ");
			Scanner sc = new Scanner(System.in);
			int opcio = sc.nextInt();
			
			// Eliminem el telèfon escollit
			persona.getTelefons().remove(opcio - 1);
			System.out.println("Telèfon eliminat");
		}
		// Tenim en compte la possibilitat que el telèfon sigui incorrecte
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	/**
	 * Recupera la llista de persones, demana per pantalla les dades d'una 
	 * persona i busca la persona en la llista
	 * @return La persona trobada en la llista de persones o null si no es troba
	 */
	private static Persona demanarDadesPersona()
	{
		ArrayList<Persona> persones = GestioArxius.llegirPersones();
		Persona persona = demanarDadesPersona(persones);
		
		return persona;
	}

	/**
	 * Demana per pantalla les dades d'una persona i la busca en la llista
	 * rebuda per paràmetre
	 * @param persones ArrayList amb les persones de l'agenda
	 * @return Persona trobada en la llista
	 */
	private static Persona demanarDadesPersona(ArrayList<Persona> persones)
	{
		// Demanem les dades de la persona a trobas
		Scanner sc = new Scanner(System.in);
		System.out.print("Nom: ");
		String nom = sc.nextLine();
		System.out.print("Cognoms: ");
		String cognoms = sc.nextLine();
	
		// Recuperem la persona de la llista (o null si no hi és)
		Persona persona = cercaPersona(persones, nom, cognoms);
		
		// Retornem la persona trobada
		return persona;
	}

	/**
	 * Troba en la llista de persones rebuda per paràmetre la persona que 
	 * coincideixi amb el nom i cognoms rebuts per paràmetre. Si no hi ha cap
	 * que en coincideixi, retorna null
	 * @param persones Llista de persones de l'agenda
	 * @param nom Nom de la persona buscada
	 * @param cognoms Cognoms de la persona buscada
	 * @return La persona trobada a la llista o null si no s'ha trobat
	 */
	private static Persona cercaPersona(ArrayList<Persona> persones, 
									   String nom, 
									   String cognoms)
	{
		Persona personaTrobada = null; // Valor de retorn (Per defecte, null)
		int i = 0;	// Comptador per recòrrer la llista de persones
		
		// Repetirem mentre no trobem la persona i quedin persones per examinar
		// Si no hi ha cap persona a la llista, no entrarem mai al bucle
		while(personaTrobada == null && i < persones.size())
		{
			// Determinem la persona a examinar
			Persona persona = persones.get(i);
			
			// Si la persona coincideix amb el nom i cognoms buscats, és la 
			// persona que busquem
			if(persona.getNom().equals(nom) && 
			   persona.getCognoms().equals(cognoms))
			{
				// Guardem la persona trobada en la variable de valor de retorn
				personaTrobada = persona;
			}
			else
			{
				// Si no és la persona que ens interesa, incrementem el 
				// comptador
				i++;
			}
		}
		
		// Retornem la persona trobada o null si no l'hem trobat
		return personaTrobada;
	}
}
