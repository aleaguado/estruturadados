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
class No
   {
   private String nome;              // vai armazenar o nome do aluno
   private String palavra;           // vai armazenar a palavra do aluno
   private No next;              // referência para o próximo item da lista
// -------------------------------------------------------------
   public No(String n, String p) // metodo construtor
      {
      nome = n;                 // initializa os dois atributos do No
      palavra = p;                 // o No next a principio fica como null
      }                           // 
// -------------------------------------------------------------
   public String getNo()      // mostra os valores do proprio nó
      {
      return "Nome: " + nome + " Palavra: " + palavra;
      }
   
   public void setNext(No n){
       next = n;
   }
   
   public No getNext(){
       return next;
   }   
   
    public String getNome(){
       return nome;
   } 
      
   }  // fim da classe nó
////////////////////////////////////////////////////////////////