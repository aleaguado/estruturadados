/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico6.recursividade;

import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class CalculoLog {
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número:");
        System.out.println("O log é: " + log(s.nextInt()));
    }
    
    //Essa é a função do log ... ela recebe um número n como parametro
    public static int log(int n) {
        if (n == 0) // se n for igual a zero, o fatorial é igual a 1
            return 1; 
        
        return n*(log(n-1)); // senão o fatorial é igual ao numero * o fatorial dele menos 1   
    }                       // essa função irá chamar a si mesma até chegar no
                            // problema mais simples: fatorial de 0 ... e depois ela 
                            // vai se "desdobrando
}
