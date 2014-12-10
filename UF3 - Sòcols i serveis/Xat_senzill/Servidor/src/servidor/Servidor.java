/* =============================================================================
 * Aplicació:		Xat senzill - Servidor
 * Arxiu:			CharacterFormatException.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Rep la connexió d'un sol client i permet xatejar amb ell.
 * ========================================================================== */

// Paquet
package servidor;

// Imports
import java.net.*;
import java.io.*;

// Classe Servidor
public class Servidor
{
	// Mètode main
	public static void main(String[] args)
	{
		try
		{
			// Creació del socket genèric
			ServerSocket socketServidor = new ServerSocket(5000);
			System.out.println("Esperant connexions dels clients");
			
			// Acceptació del client i creació del socket específic
			Socket socketClient = socketServidor.accept();
			
			// Recuperació de la IP del client
			InetAddress adressaRemota = socketClient.getInetAddress();
			System.out.println("Client connectat. IP: " + 
					adressaRemota.getHostAddress());

			// Conversa
			xatServidor(socketClient);
			
			// Tancament de sockets i connexions
			socketClient.close();
			socketServidor.close();
			System.out.println("Connexió tancada");
		}
		catch(Exception e)
		{
			System.out.println("Error en la transmissió de dades");
		}
	}

	/* -------------------------------------------------------------------------
	 * Mètode:		xatServidor
	 * Paràmetres:	Socket socket	El socket a través del qual farem la 
	 *								conversa amb el client
	 * Retorn:		Cap
	 * Descripció:	Realitza la conversa amb el client.
	 * ---------------------------------------------------------------------- */
	private static void xatServidor(Socket socket)
	{
		try
		{
			// Creació dels objectes per a l'enviament i recepció de missatges
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			String missatge = "";

			// Implementació de l'algorisme de la conversa
			while(!missatge.equals("FI"))
			{
				missatge = (String) ois.readObject();
				if(!missatge.equals("FI"))
				{
					System.out.println("Client > " + missatge);
					System.out.print("Servidor > ");
					missatge = Teclat.llegirTeclatString();
					oos.writeObject(missatge);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error en la transmissió de dades");
		}
	}
}
