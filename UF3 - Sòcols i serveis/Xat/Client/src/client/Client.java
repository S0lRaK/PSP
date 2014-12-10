/*==============================================================================
 * Aplicació:           Xat
 * Arxiu:               Client.java
 * Autor:               @author Carlos J. García Carmona
 * Data de creació:     30/10/2014
 * Descripció:
 *============================================================================*/

// Paquet
package client;

// Imports
import java.util.Scanner;


// Classe principal
public class Client
{
    // Constants
    private static final int PORT = 5000;
    
    // Punt d'entrada de l'aplicació
    public static void main(String[] args)
    {
        try
        {
            Scanner introDades = new Scanner(System.in);
            // Demana la IP del servidor a connectar
            System.out.println("IP del servidor: ");
            String ip = introDades.nextLine();
        }
        catch(Exception e)
        {
            System.out.println(e.toString() + "\n");
            // Mostra la pila de trucades als mètodes
            e.printStackTrace();
        }
    }
}