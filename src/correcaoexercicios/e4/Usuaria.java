/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e4;

import java.util.Scanner;


/**
 *
 * @author aleaguado
 */
public class Usuaria {
    
    public static void main(String[] args)
      {
          Scanner e = new Scanner(System.in);
          System.out.println("Digite uma frase");
          String frase = e.nextLine();
          Pilha p = new Pilha(frase.length());
          
          for (int i = 0; i < frase.length(); i++) {
              p.inserir(frase.charAt(i));
          }
          
      while( !p.estaVazio())     // enquanto não estiver vazia a pilha
         {                             
         char value = p.remove();       //remova o item do topo
         System.out.print(value);      // e retorne o valor dele
         }  // fim do while
      System.out.println("");
      }  // fim do metodo main
}
