/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e4;


/**
 *
 * @author aleaguado
 */
class Pilha
   {
   private int maxSize;
   private char[] pilhaArray;
   private int top;
//--------------------------------------------------------------
   public Pilha(int s)       // constructor
      {
      maxSize = s;
      pilhaArray = new char[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void inserir(char j)  // insere item
      {
      pilhaArray[++top] = j;
      }
//--------------------------------------------------------------
   public char remove()         // remove item
      {
      return pilhaArray[top--];
      }
//--------------------------------------------------------------
   public char pegaitem()        // pega o item do topo
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
