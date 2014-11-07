/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e8;

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

      theList.InsertSort("João", "Paula Fernandes", 15);
      theList.InsertSort("Ze", "Isis", 31);
      theList.InsertSort("João", "Paula Fernandes", 15);      // inserimos quatro itens nela
      theList.InsertSort("José", "Bruna Marq.", 19);
      theList.InsertSort("Manoel", "Andressa", 18);
      theList.InsertSort("Rovanildo", "Isis", 20);

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

