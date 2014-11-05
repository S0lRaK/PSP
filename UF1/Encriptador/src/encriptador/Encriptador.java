/**
 * @author Carlos J. García Carmona
 *         DAM2T - PSP - UF1
 */
package encriptador;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Encriptador
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Arxiu original: ");
            String arxiuOriginal = sc.nextLine();
            System.out.print("Arxiu destí: ");
            String arxiuDesti = sc.nextLine();
            System.out.print("Clau (número): ");
            int clau = sc.nextInt();
            
            FileReader fr = new FileReader(arxiuOriginal);
            FileWriter fw = new FileWriter(arxiuDesti);
            int caracter;
            
                        
            // Llegeix el primer caràcter...
            caracter = fr.read();
            // ...per poder evaluar
            while (caracter != -1)
            {
                //System.out.print((char)caracter);
                
                fw.write(caracter ^ clau);
                
                caracter = fr.read();
            }
            // Tanca els arxius abans d'acabar
            fr.close();
            fw.close();
        }
        catch(Exception e)
        {
            // Mostra un missatge d'error si l'arxiu original no s'ha trobat
            System.out.println("Arxiu no trobat.");
        }
    }    
}