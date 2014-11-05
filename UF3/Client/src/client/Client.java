/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Client
{
    private static final int PORT = 5000;
    /**
     * @param args the command line arguments
     */
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
            
            System.out.println("Missatge: ");
            String missatge = introDades.nextLine();
            oos.writeObject(missatge);
            
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String missatgeRetornat = (String)ois.readObject();
            System.out.println(missatgeRetornat);
            
            socket.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString() + "\n");
            e.printStackTrace(); // Mostra la pila de trucades als mètodes
        }
    }
}