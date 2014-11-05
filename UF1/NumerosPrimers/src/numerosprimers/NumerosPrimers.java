/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosprimers;

/**
 *
 * @author Carlos
 */
public class NumerosPrimers {

    private static final int MAX_DIVISORS = 6;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] divisors = new int[MAX_DIVISORS];
        int num, numDivisors;
        
        for(num = 1; num <= 100; num++) {
            System.out.print(num + ": ");
            
            if(esPrimer(num))
                System.out.print("Primer");
            else {
                numDivisors = buscarDivisorsPrimers(num, divisors);
                mostrarDivisors(divisors, numDivisors);
            }
            System.out.println();
        }
    }
    
    private static boolean esPrimer(int num) {
        boolean primer = true;
        int divi = 2;
        
        if(num > 2) {
            do {
                if(num % divi == 0)
                    primer = false;
                else
                    divi++;
            }while(primer == true && divi < num);
        }
        return primer;
    }
    
    private static int buscarDivisorsPrimers(int num, int [] divisors) {
        int divi = 2, numDivisors = 0;
        
        do {
            if(esPrimer(divi) && num % divi == 0) {
                divisors[(numDivisors)++] = divi;
                num = num / divi;
            }
            else
                divi++;
        }while(num > 1);
        return numDivisors;
    }
    
    private static void mostrarDivisors(int [] divisors, int numDivisors) {
        for(int i = 0; i < numDivisors; i++)
            System.out.print(divisors[i] + " ");
    }
}