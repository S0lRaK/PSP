/* =============================================================================
 * Aplicació:		Xat senzill - Client
 * Arxiu:			CharacterFormatException.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Connecta amb un servidor i permet xatejar amb ell.
 * ========================================================================== */

// Paquet
package client;

// Imports
import java.net.*;
import java.io.*;

// Classe Client
public class Client
{
	// Mètode main
	public static void main(String[] args)
	{
		try
		{
			// Demanem a l'usuari la IP del servidor amb qui connectarem
			System.out.print("IP del servidor: ");
			String ip = Teclat.llegirTeclatString();
			
			// Connectem amb el servidor (es crea el socket per a la connexió)
			Socket socket = new Socket(ip, 5000);
			System.out.println("Connexió realitzada amb el servidor");
			
			// Conversem amb el servidor
			xatClient(socket);
			
			// Es tanca el socket (la connexió) amb el servidor)
			socket.close();	
			System.out.println("Connexió tancada");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:		xatClient
	 * Paràmetres:	Socket socket	El socket a través del qual farem la 
	 *								conversa amb el servidor
	 * Retorn:		Cap
	 * Descripció:	Realitza la conversa amb el servidor.
	 * ---------------------------------------------------------------------- */
	private static void xatClient(Socket socket)
	{
		try
		{
			// Creació dels objectes per a l'enviament i recepció de missatges
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			String missatge = "";

			// Implementació de l'algorisme de la conversa
			while(!missatge.equals("FI"))
			{
				System.out.print("Client > ");
				missatge = Teclat.llegirTeclatString();
				oos.writeObject(missatge);
				if(!missatge.equals("FI"))
				{
					missatge = (String) ois.readObject();
					if(!missatge.equals("FI"))
					{
						System.out.println("Servidor > " + missatge);
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
