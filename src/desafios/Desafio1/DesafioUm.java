/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desafios.Desafio1;

/**
 *
 * @author aleaguado
 */
import java.util.Scanner;

public class DesafioUm {
     public static void main(String[] args)
      {
          String[] StringVetor = new String[5]; //Instancio o vetor
          Scanner entrada = new Scanner (System.in); //Instancio o objeto entrada do tipo Scanner
          boolean teste = false;
                    
          System.out.println("Bem Vindo ao Programa de Vetores!!!");
          System.out.println("Digite o primeiro nome!!!");
          StringVetor[0] = entrada.nextLine();
          System.out.println("Digite o segundo nome!!!");
          StringVetor[1] = entrada.nextLine();
          System.out.println("Digite o terceiro nome!!!");
          StringVetor[2] = entrada.nextLine();
          System.out.println("Digite o quarto nome!!!");
          StringVetor[3] = entrada.nextLine();
          System.out.println("Digite o quinto nome!!!");
          StringVetor[4] = entrada.nextLine();

          System.out.println("Muito Bem! Agora que você cadastrou os nomes, digite uma letra");
          String busca = entrada.nextLine(); //Pegar c/ o usuario a letra da busca
          
          for (int i = 0; i < 5; i++) {   //Varemos o vetor neste for ... 
             
            if (StringVetor[i].charAt(0) == busca.charAt(0)) { //Comparamos o primeiro caracter 
                System.out.println("O nome " + StringVetor[i] + " começa com a letra " + busca ); 
                teste = true;
            }
            }
          
           if (!teste) { //Se não houver nenhum nome c/ a letra, imprimimos isso ...
            System.out.println("Nenhum nome começa com a letra: " + busca);
           }
                  
      }  // termina o metodo main
    
}