package client;

import java.net.*;
import java.io.*;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			System.out.print("Nom del servidor: ");
			String nom = Teclat.llegirTeclatString();
			String ip = InetAddress.getByName(nom).getHostAddress();
			Socket socket = new Socket(ip, 5001);
			System.out.println("Connexió realitzada amb el servidor");
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
                        
			String nomHostLocal = InetAddress.getLocalHost().getHostName();
			oos.writeObject(nomHostLocal);
			
			socket.close();	
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
