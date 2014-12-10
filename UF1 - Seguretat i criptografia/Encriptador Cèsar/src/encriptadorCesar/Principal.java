/**
 * DAM2T PSP UF1 - Seguretat i criptografia
 * Examen Convocatòria Ordinària 1
 * Data: 10/12/2014
 * @author Carlos J.
 */

// Paquet
package encriptadorCesar;

// Imports
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

// Classe principal
public class Principal
{
    /**
     * Punt d'entrada a l'aplicació
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Atributs
        Scanner sc = new Scanner(System.in);
        String arxiuOriginal;
        int clau, caracter, caracterEncriptat;
        
        try
        {
            System.out.print("Nom de l'arxiu: ");
            // Llegeix l'String introduït per l'usuari i el guarda
            arxiuOriginal = sc.nextLine();
            
            do
            {
                System.out.print("Clau (1~255): ");
                // Llegeix el byte introduït per l'usuari i el guarda
                clau = sc.nextInt();
            }
            while(clau < 1 || clau > 255);
            
            // Evalua si s'ha d'encriptar o desencriptar l'arxiu per la seva extensió
            if(!arxiuOriginal.endsWith(".enc"))
            {
                encriptar(arxiuOriginal, clau);
            }
            else
            {
                desencriptar(arxiuOriginal, clau);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    static private void encriptar(String arxiuOriginal, int clau)
    {
        int caracter, caracterEncriptat;
        String arxiuEncriptat = arxiuOriginal + ".enc";
        System.out.println("Encriptant...");
        
        try
        {
            // Crea objectes per llegir l'original i escriure l'encriptat
            FileReader arxiuOrigen = new FileReader(arxiuOriginal);
            FileWriter arxiuDesti = new FileWriter(arxiuEncriptat);
                
            caracter = arxiuOrigen.read();
            // Recórre el text fins al final de cadena (-1)
            while(caracter != -1)
            {
                // Tradueix el caràcter segons la clau
                caracterEncriptat = caracter + clau;
                // En cas que superi els 255 caràcters de la taula ASCI, torna al primer
                if(caracterEncriptat > 255)
                {
                    caracterEncriptat -= 256;  // caracterEncriptat = caracterEncriptat - 256                      
                }
                    
                arxiuDesti.write(caracterEncriptat);
                    
                // Continua llegint l'arxiu
                caracter = arxiuOrigen.read();
            }
                
            System.out.println("Arxiu \"" + arxiuOriginal + "\" encriptat");
                        
            // Tanca el fluxe de dades dels arxius
            arxiuOrigen.close();
            arxiuDesti.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
                
        System.out.println("Arxiu \"" + arxiuEncriptat + "\" creat");
    }
    
    static private void desencriptar(String arxiuOriginal, int clau)
    {
        int caracter, caracterEncriptat;
        String arxiuDesencriptat = arxiuOriginal.replace(".enc", "");
                System.out.println("Desencriptant...");
                
                // Crea objectes per llegir l'original i escriure l'encriptat
                FileReader arxiuOrigen;
        try {
            arxiuOrigen = new FileReader(arxiuOriginal);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                FileWriter arxiuDesti = new FileWriter(arxiuDesencriptat);
                
                caracter = arxiuOrigen.read();
                // Recórre el text fins al final de cadena (-1)
                while(caracter != -1)
                {
                    // Tradueix el caràcter segons la clau
                    caracterEncriptat = caracter - clau;
                    // En cas que surti dels 255 caràcters de la taula ASCI, torna a l'últim
                    if(caracterEncriptat < 0)
                    {
                        caracterEncriptat += 256;   // caracterEncriptat = caracterEncriptat + 256               
                    }
                    
                    arxiuDesti.write(caracterEncriptat);
                    
                    // Continua llegint l'arxiu
                    caracter = arxiuOrigen.read();
                }
                
                System.out.println("Arxiu \"" + arxiuOriginal + "\" desencriptat");
                        
                // Tanca el fluxe de dades dels arxius
                arxiuOrigen.close();
                arxiuDesti.close();
                
                System.out.println("Arxiu \"" + arxiuDesencriptat + "\" creat");
    }
}