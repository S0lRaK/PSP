 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication3;

import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author jlgarcia
 */
public class JavaApplication3
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			FileReader arxiuOrigen = new FileReader("quijote.txt");
			FileWriter arxiuDesti = new FileWriter("quijote2.txt");
			
			int caracter = arxiuOrigen.read();
			while(caracter != -1)
			{
				System.out.print((char) caracter);
				arxiuDesti.write(caracter);
				caracter = arxiuOrigen.read();
			}
			
			arxiuOrigen.close();
			arxiuDesti.close();
		}
		catch(Exception e)
		{
			System.out.println("No s'ha trobat l'arxiu");
		}
	}
	
}
