/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico1_vetores;

import java.util.Scanner;
/**
 *
 * @author aleaguado
 */
public class Rascunho {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        
        System.out.println("Digite um nome: ");
        String nomeA = entrada.nextLine();
        
        System.out.println("Digite outro nome: ");
        String nomeB = entrada.nextLine();
        
        System.out.println("O valor é: " + nomeA.compareTo(nomeB));
   
    
    }
    
    
    
}
