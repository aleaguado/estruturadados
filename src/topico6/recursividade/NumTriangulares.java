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
public class NumTriangulares {
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um posição:");
        int valor = s.nextInt();
        System.out.print("A sequência é: { ");
        int retorno = tri(valor);
        System.out.println("}");
        System.out.println("Podemos ver que na posição "+ valor + " fica o numero " + retorno);
    }
    
    //Essa é a função do triangulo ... ela recebe um número n como parametro
    public static int tri(int n) {
        if (n == 1) // se n for igual a 1 seu valor será 1
        {
            System.out.print("1, ");
            return 1; 
        }
        int resp = n+(tri(n-1));
        System.out.print(resp + ", ");
        
        return resp; // senão o fatorial é igual ao numero * o fatorial dele menos 1   
    }                       // essa função irá chamar a si mesma até chegar no
                            // problema mais simples: fatorial de 0 ... e depois ela 
                            // vai se "desdobrando
}
