/*==============================================================================
 * Aplicació:
 * Arxiu:
 * Autor:               @author ${user}
 * Data de creació:     
 * Descripció:
 *============================================================================*/

// Paquet
package client;

// Imports
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
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
            System.out.println("Nom del servidor: ");
            String nom = introDades.nextLine();
            String ip = InetAddress.getByName(nom).getHostAddress();
        
            Socket socket = new Socket(ip, PORT);
            System.out.println("Connexió establerta amb el servidor.");
            
            // Objecte per a transportar dades a través de la connexió
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            // Envia un missatge al servidor
            /*System.out.println("Missatge: ");
            String missatge = introDades.nextLine();
            oos.writeObject(missatge);*/
            
            // Envia el nom de la màquina client al servidor
            String nomHostLocal = InetAddress.getLocalHost().getHostName();
            oos.writeObject(nomHostLocal);
            
            // Retorna des del servidor el missatge enviat
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String missatgeRetornat = (String)ois.readObject();
            System.out.println(missatgeRetornat);
            
            socket.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString() + "\n");
            // Mostra la pila de trucades als mètodes
            e.printStackTrace();
        }
    }
}