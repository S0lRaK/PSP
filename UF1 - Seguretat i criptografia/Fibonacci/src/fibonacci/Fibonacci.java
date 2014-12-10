/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Carlos
 */
public class Fibonacci {

    private static final int NUM_ELEMENTS = 20;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] serie = new int[NUM_ELEMENTS];
        int sumaValors;
        
        sumaValors = crearSerie(serie);
        mostrarSerie(serie, sumaValors);
    }
    
    private static int crearSerie(int [] serie) {
        serie[0] = 0;
        serie[1] = 1;
        
        int sumaValors = serie[0] + serie[1];
        
        for(int i = 2; i < NUM_ELEMENTS; i++) {
            serie[i] = serie[i - 2] + serie[i - 1];
        }
        
        return sumaValors;
    }
    
    private static void mostrarSerie(int [] serie, int sumaValors) {
        for(int i = 0; i < NUM_ELEMENTS; i++) {
            System.out.print(serie[i] + " ");
        }
        System.out.println();
    }
}