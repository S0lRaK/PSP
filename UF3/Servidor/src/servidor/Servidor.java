/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

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

/**
 *
 * @author Carlos
 */
public class Servidor
{
    private static final int PORT = 5000;
    /**
     * @param args the command line arguments
     */
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
                
                InputStream is = socketClient.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                String missatge = (String)ois.readObject();
                System.out.println(missatge);
                
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
            e.printStackTrace(); // Mostra la pila de trucades als mètodes
        }
//        catch (IOException ex)
//        {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}