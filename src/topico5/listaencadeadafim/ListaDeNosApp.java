/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico5.listaencadeadafim;

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
      ListaAvancada theList = new ListaAvancada();  // criamos uma nova lista
      Scanner ent = new Scanner(System.in);

      theList.InsereOrdenado("João", "Paula Fernandes", 15);
      theList.InsereOrdenado("Ze", "Isis", 31);
      theList.InsereOrdenado("João", "Paula Fernandes", 15);      // inserimos quatro itens nela
      theList.InsereOrdenado("José", "Bruna Marq.", 19);
      theList.InsereOrdenado("Manoel", "Andressa", 18);
      theList.InsereOrdenado("Rovanildo", "Isis", 20);

          //Mostra de Frente para Tarde
          System.out.println("Vamos ver a lista de Frente para Trás?");
          System.out.println(theList.ListaDeFrentePraTras());              // mostramos a lista

           System.out.println("Vamos ver a lista de tras para frente?");
           //Mostra de Traz para Frente
          System.out.println(theList.ListaDeTrazPraFrente());              // mostramos a lista
          

          System.out.println("Vamos fazer uma busca ... vamos buscar o Manuel ...");
          System.out.println(theList.buscaEspecifico("Manoel"));
          
          System.out.println("Digite um nome que você queira remover da lista!!!");
          if (!theList.estaVazio()) {
              if (theList.removeEspecifico(ent.nextLine()) != null) {
                System.out.println("Nó deletado com sucesso!!!" );
                }
          }
             System.out.println("Vamos ver nossa nova lista!!!");       
                    
      System.out.println(theList.ListaDeFrentePraTras());              // mostramos a lista
      }  // final do método main()
   }  // final da classe usuária
////////////////////////////////////////////////////////////////

