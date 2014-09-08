 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico2_ordenacao;

import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class ClasseUsuaria {
   public static void main(String[] args)
      {
      int maxSize = 100;            // variável que guarda o tamanho máximo da estrutura de dados
      EstruturaDados arr;                 // criamos nossa referência para a Estrutura de Dados
      arr = new EstruturaDados(maxSize);  // instanciamos a classe EstruturaDados
      Scanner e = new Scanner(System.in);

      arr.insert(77);               // inserimos 10 itens na Estrutura de Dados
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // imprimimos na tela nossos itens
      
        
      
          // Para não colocar varios programas, eu implementei uma escolha do usuario
          // apontando qual algoritmo ele quer usar! Nossa estrutura de dados esta pronta
          // para os três tipos de ordenação
          System.out.println("Qual Algoritmo você deseja utilizar para ordenar?");
          System.out.println("Digite B - BubbleSort");
          System.out.println("Digite S - SelectSort");
          System.out.println("Digite I - InsertSort");
          switch (e.nextLine()) {
              case "B":
                  System.out.println("Ótimo opção! BubbleSort!!!");
                  arr.bubbleSort(); 
                  break;
              case "S":
                  System.out.println("Ótimo opção! SelectSort!!!");
                  arr.selectionSort(); 
                  break;
              case "I":
                  System.out.println("Ótimo opção! InsertSort!!!");
                  arr.insertionSort();
                  break;         
              default:
                  System.out.println("Ok! Como você não colocou nada, vou pegar meu padrão! Bubblleeee");
          }
          
      arr.display();                // mostramos na  tela nossos itens!!!
      } 
   }  