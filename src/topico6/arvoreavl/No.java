/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico6.arvoreavl;


/**
 *
 * @author aleaguado
 */
class No
   {
   private int idade;              // vai guardar um identificador
   private String nome;           // vai armazenar a palavra do aluno
   private No filhoesquerdo;              // referência para o próximo item da lista
   private No filhodireito;
   private int alturadir;
   private int alturaesq;
   private No pai;
// -------------------------------------------------------------
   public No(int id, String n) // metodo construtor
      {
       idade = id;
       nome = n; 
       alturadir = 0;
       alturaesq = 0;
      }                           // 
// -------------------------------------------------------------
 
   public int getAltD(){
       return alturadir;
   }
   
   public int getAltE(){
       return alturaesq;
   }
   
   public void setAltD(int a){
       alturadir = a;
   }
   
   public void setAltE(int a){
       alturaesq = a;
   }
      
   public String getNo()      // mostra os valores do proprio nó
      {
      return "Idade: " + idade + " Nome: " + nome + "";
      }
   
   public String printDebug()      // mostra os valores do proprio nó
      {
       if (pai != null )
           return "Idade: " + idade + " Nome: " + nome + " AltE:" + alturaesq + " AltD: " +  alturadir + " Pai: " + pai.getIdade();
       else
           return "Idade: " + idade + " Nome: " + nome + " AltE:" + alturaesq + " AltD: " +  alturadir + " ";

   }
   
   
   
   public void setFilhoEsquerdo(No n){       //Conecta o Filho Esquerdo
       filhoesquerdo = n;
   }
   
     public void setFilhoDireito(No n){       //Conecta o Filho Direito
       filhodireito = n;
   }

    public void setPai(No n){       //Referencia o pai
       pai = n;
   } 
    
    public int getAlturaMaxima(){
        if (alturadir > alturaesq)
            return alturadir;
        else
            return alturaesq; 
    }
    
    public No getPai(){       //Referencia o pai
       return pai;
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
    
    public int getIdade(){
       return idade;
   } 

   
    public int getTamanho(){
       return (alturaesq - alturadir);
   } 
      
   }  // fim da classe nó
////////////////////////////////////////////////////////////////