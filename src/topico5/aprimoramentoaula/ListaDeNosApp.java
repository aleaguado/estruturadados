/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico5.aprimoramentoaula;

import java.util.Scanner;

/**
 *
 * @author aleaguado traduzido de Robert Lafore
 */
////////////////////////////////////////////////////////////////
class ListaDeNosApp
   {
   public static void main(String[] args)
      {
      ListaDeNos theList = new ListaDeNos();  // criamos uma nova lista
      Scanner ent = new Scanner(System.in);

      theList.insertFirst("João", "Paula Fernandes");      // inserimos quatro itens nela
      theList.insertFirst("José", "Bruna Marq.");
      theList.insertFirst("Manoel", "Andressa");
      theList.insertFirst("Rovanildo", "Isis");

          System.out.println(theList.displayList());              // mostramos a lista
          
          System.out.println("Vamos fazer uma busca ... vamos buscar o Manuel ...");
          System.out.println(theList.busca("Manoel"));
          
          System.out.println("Digite um nome que você queira remover da lista!!!");
          if (!theList.isEmpty()) {
              if (theList.delete(ent.nextLine()) != null) {
                System.out.println("Nó deletado com sucesso!!!" );
                }
          }
             System.out.println("Vamos ver nossa nova lista!!!");       
                    
      System.out.println(theList.displayList());              // mostramos a lista
      }  // final do método main()
   }  // final da classe usuária
////////////////////////////////////////////////////////////////

