package servidor;

import java.net.*;
import java.io.*;

public class Servidor
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket socketServidor = new ServerSocket(5001);
			System.out.println("Esperant connexions dels clients");
			
			while(true)
			{
				Socket socketClient = socketServidor.accept();
				InetAddress adressaRemota = socketClient.getInetAddress();
				System.out.println(adressaRemota.getHostAddress());
				InputStream is = socketClient.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				String nomClient = (String) ois.readObject();
				System.out.println("Nom de la màquina client: " + nomClient);

				socketClient.close();
			}
//			socketServidor.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
