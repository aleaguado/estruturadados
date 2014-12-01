/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico6.arvoreavl;

import java.util.Scanner;


/**
 *
 * @author aleaguado
 */
public class ClasseUsuaria {
     public static void main(String[] args) {
         Arvore a = new Arvore();
         
         //Vamos inserir alguns itens ....
         a.inserir(15, "Antonio");
          a.percorrer(1);
         a.inserir(27, "Bruno");
          a.percorrer(1);
         a.inserir(49, "Roger");
          a.percorrer(1);
         a.inserir(10, "Aparecido");
          a.percorrer(1);
         a.inserir(8, "Malaquias");
          a.percorrer(1);
         a.inserir(67, "Cintia"); 
         a.percorrer(1);
         a.inserir(59, "Ale");
          a.percorrer(1);
         a.inserir(9, "Teotonio");
          a.percorrer(1);
         a.inserir(13, "Alba");
          a.percorrer(1);
         a.inserir(20, "Margarida");
          a.percorrer(1);
         a.inserir(14, "Elfim");
         
         System.out.println("=====Imprimindo a arvore ...");
         //a.percorrer(1);
         a.percorrer(1);
         
         System.out.println("A Raiz é: " + a.getRaiz());
         //a.percorrer(3);

         //vamos fazer uma busca:
         System.out.println("Vamos buscar alguns numeros!");
         Scanner entrada = new Scanner (System.in); //Instancio o objeto entrada do tipo Scanner
         
         int busca = 1;

         while (busca != 0)
         {
             System.out.println("Digite a idade de quem você deseja encontrar:");
              busca = entrada.nextInt();
             
         if (a.buscar(busca) != null)
            System.out.println("Encontrei!!!");
         else
             System.out.println("Não encontrado!!!");
        
         }
         
         System.out.println("Vamos tentar remover um numero!!!");
        if (a.remover(15))
                System.out.println("Removido com sucesso");
        else
           System.out.println("Não foi possível resolver ...");
         
         a.percorrer(1);
         
        }
}
