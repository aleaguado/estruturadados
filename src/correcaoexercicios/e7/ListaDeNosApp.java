/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e7;

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

      theList.insertFirst("João", "Paula Fernandes");      // inserimos quatro itens nela
      theList.insertFirst("José", "Bruna Marq.");
      theList.insertFirst("Manoel", "Andressa");
      theList.insertFirst("Rovanildo", "Isis");

          System.out.println(theList.displayList());              // mostramos a lista
          
          System.out.println("Vamos fazer uma busca ... vamos buscar o Manuel ...");
          System.out.println(theList.busca("Manoel"));

      while( !theList.isEmpty() )         // vamos esvaziar
         {
         No aLink = theList.deleteFirst();   // deletamos o primeiro nó da lista e colocamos em aLink
         System.out.print("Deletado ");         // 
         System.out.println(aLink.getNo());                     // mostramos o nó deletado
         System.out.println("");
         }
      System.out.println(theList.displayList());              // mostramos a lista
      }  // final do método main()
   }  // final da classe usuária
////////////////////////////////////////////////////////////////

