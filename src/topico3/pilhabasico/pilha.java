/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico3.pilhabasico;


/**
 *
 * @author aleaguado
 */
class pilha
   {
   private int maxSize;
   private int[] pilhaArray;
   private int top;
//--------------------------------------------------------------
   public pilha(int s)       // constructor
      {
      maxSize = s;
      pilhaArray = new int[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void inserir(int j)  // insere item
      {
      pilhaArray[++top] = j;
      }
//--------------------------------------------------------------
   public int remove()         // remove item
      {
      return pilhaArray[top--];
      }
//--------------------------------------------------------------
   public int pegaitem()        // pega o item do topo
      {
      return pilhaArray[top];
      }
//--------------------------------------------------------------
   public boolean estaVazio()    // retorna verdadeiro se estiver vazio
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   }  // fim da classe
