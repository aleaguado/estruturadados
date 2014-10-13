/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico5.listabasica;

/**
 *
 * @author aleaguado traduzido de Robert Lafore
 */
class No
   {
   private int iData;              // vai armazenar um valor numerico qualquer
   private double dData;           // vai armazenar um valor numerico qualquer
   private No next;              // referência para o próximo item da lista
// -------------------------------------------------------------
   public No(int id, double dd) // metodo construtor
      {
      iData = id;                 // initializa os dois atributos do No
      dData = dd;                 // o No next a principio fica como null
      }                           // 
// -------------------------------------------------------------
   public void displayNo()      // mostra os valores do proprio nó
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   
   public void setNext(No n){
       next = n;
   }
   
   public No getNext(){
       return next;
   }   
   }  // fim da classe nó
////////////////////////////////////////////////////////////////