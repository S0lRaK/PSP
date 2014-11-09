/*==============================================================================
 * Aplicació:           Servidor
 * Arxiu:               Servidor.java
 * Autor:               @author Carlos J. García Carmona
 * Data de creació:     22/10/2014
 * Descripció:
 *============================================================================*/

// Paquet
package servidor;

// Imports
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Classe principal
public class Servidor
{
    // Constants
    private static final int PORT = 5000;
    
    // Punt d'entrada de l'aplicació
    public static void main(String[] args)
    {
        try
        {
            ServerSocket socketServidor = new ServerSocket(PORT);
            System.out.println("Esperant connexions dels clients...");
            
            while(true)
            {
                Socket socketClient = socketServidor.accept();
                InetAddress addressRemota = socketClient.getInetAddress();
                System.out.println(addressRemota.getHostAddress());
                
                // Llegeix el missatge del client
                InputStream is = socketClient.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                String missatge = (String)ois.readObject();
                System.out.println(missatge);
                
                // Retorna el mateix missatge al client
                OutputStream os = socketClient.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeObject(missatge);
                
                socketClient.close();
            }
//            socketServidor.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString() + "\n");
            // Mostra la pila de trucades als mètodes
            e.printStackTrace();
        }
//        catch (IOException ex)
//        {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}