/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico6.arvorebinaria_v1;

/**
 *
 * @author aleaguado
 */
class No
   {
   private int ordem;              // vai guardar um identificador
   private String nome;           // vai armazenar a palavra do aluno
   private No filhoesquerdo;              // referência para o próximo item da lista
   private No filhodireito;
// -------------------------------------------------------------
   public No(int o, String n) // metodo construtor
      {
       ordem = o;
       nome = n;                 // initializa os dois atributos do No
      }                           // 
// -------------------------------------------------------------
   public String getNo()      // mostra os valores do proprio nó
      {
      return "Ordem: " + ordem + " Nome: " + nome + "";
      }
   
   public void setFilhoEsquerdo(No n){       //Conecta o Filho Esquerdo
       filhoesquerdo = n;
   }
   
     public void setFilhoDireito(No n){       //Conecta o Filho Direito
       filhodireito = n;
   }

   public No getFilhoEsquerdo(){                //Retorna o filho esquerdo
       return filhoesquerdo;
   }   
   
    public No getFilhoDireito(){                //Retorna o filho direito
       return filhodireito;
   } 
   
    public String getNome(){
       return nome;
   } 
    
    public int getOrdem(){
       return ordem;
   } 

      
   }  // fim da classe nó
////////////////////////////////////////////////////////////////