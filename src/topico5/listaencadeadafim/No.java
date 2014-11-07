/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico5.listaencadeadafim;
/**
 *
 * @author aleaguado traduzido de Robert Lafore
 */
class No
   {
   private String nome;              // vai armazenar o nome do aluno
   private String palavra;           // vai armazenar a palavra do aluno
   private int idade;
   private No anterior;              // referência para o próximo item da lista
   private No proximo;
// -------------------------------------------------------------
   public No(String n, String p, int id) // metodo construtor
      {
      nome = n;                 // initializa os dois atributos do No
      palavra = p;                 // o No next a principio fica como null
      idade = id;
      }                           // 
// -------------------------------------------------------------
   public String getNo()      // mostra os valores do proprio nó
      {
      return "Nome: " + nome + " Palavra: " + palavra + "Idade: " + idade;
      }
   
   public void setAnterior(No n){       //Link ao nó anterior
       anterior = n;
   }
   
    public void setProximo(No p){          //Link ao proximo nó
       proximo = p;
   }
   
   
   public No getAnterior(){                //Retorna o nó anterior
       return anterior;
   }   
   
   public No getProximo(){                  //Retorna o próximo nó
       return proximo;
   }   
   
    public String getNome(){
       return nome;
   } 
    
    public int getIdade(){
       return idade;
   } 
      
   }  // fim da classe nó
////////////////////////////////////////////////////////////////