// Paquet
package rsa;

// Llibreries
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

/**
 * Examen DAM2T PSP UF1
 * Data de creació: 22-10-2014
 * @author Carlos J. García Carmona
 */
public class RSA {

    /**
     * Punt d'entrada de l'aplicació amb les opcions del menú.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcio;
        
        // Mostra les opcions de menú fins a prèmer 0 (sortir)
        do
	{
            // Demana l'opció a l'usuari
            opcio = menu();

            // S'executa l'opció escollida
            switch(opcio)
            {
                case 1:
                    opcioGenerarClaus();
                    break;
                case 2:
                    opcioEncriptarArxiu();
                    break;
                case 3:
                    opcioDesencriptarArxiu();
                    break;
                case 0:
                    System.out.println("Adéu!");
                    break;
                default:
                    System.out.println("Opció invàlida!");
                    break;
            }
        }while(opcio != 0);
    }
    
    /**
    * Mostra les opcions del menú, retornant l'escollida
    * @return Opció escollida per l'usuari
    */
    private static int menu()
    {
        int opcio = -1;
		
        try
        {
            // Mostra les opcions disponibles
            System.out.println("\n\nMENÚ PRINCIPAL\n");
            System.out.println("1. Generar claus");
            System.out.println("2. Encriptar arxiu");
            System.out.println("3. Desencriptar arxiu");
            System.out.println("0. Sortir\n");

            // Demana l'opció a l'usuari
            System.out.print("Opció: ");
            Scanner sc = new Scanner(System.in);
            opcio = sc.nextByte();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

        return opcio;
    }
    
    /*
    *   Opció del menú que genera claus públiques i privades,
    *   i les grava en un arxiu cadascuna dins la carpeta 'claus'
    */
    private static void opcioGenerarClaus()
    {
        try
        {
            // Avisa si les claus ja han estat generades
            if(GestioArxius.clausGenerades())
            {
                System.out.println("Les claus ja han estat generades prèviament.");
            }
            // Si no hi han claus, es creen
            else
            {
                KeyPair claus = EncriptadorRSA.generarClaus();
                GestioArxius.gravarClaus(claus);
                System.out.println("Claus generades correctament!");
            }
        }
        // Excepció genèrica
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    /*
    *   Opció del menú que encripta un arxiu qualsevol (menor de 117 bytes).
    */
    private static void opcioEncriptarArxiu()
    {
        try
        {
            // Avisa si les claus ja han estat generades
            if(GestioArxius.clausGenerades())
            {
                System.out.println("Les claus ja han estat generades prèviament.");
            }
            // Si no hi han claus, es creen
            else
            {
                
            }
            // Obre l'arxiu per llegir-lo
            FileReader fr = new FileReader("quijote.txt");
        }
        // Excepció per quan l'arxiu a encriptar no es trobat
        catch(FileNotFoundException e){}
        // Excepció genèrica
        catch(Exception e)
        {
            System.out.printf("Error en accedir a l'arxiu.");
        }
    }
    
    /*
    *   Opció del menú que desencripta un arxiu qualsevol prèviament encriptat.
    */
    private static void opcioDesencriptarArxiu()
    {
        
    }
}