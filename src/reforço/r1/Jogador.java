/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reforço.r1;



/**
 *
 * @author aleaguado
 */
public class Jogador
   { 
   private String nome;
   private float altura;
   private int idade;
//--------------------------------------------------------------
   public Jogador(String n, float a, int id)
      {                               // comentario aqui
      nome = n;
      altura = a;
      idade = id;
      }
//--------------------------------------------------------------
   public void displayJogador()
      {
      System.out.print("   Nome: " + nome);
      System.out.print(", Altura: " + altura);
      System.out.println(", Idade: " + idade);
      }
//--------------------------------------------------------------
   public String getNome()           // comentario aqui
      { return nome; }

   public float getAltura()           // comentario aqui
      { return altura; }

   public int getIdade()           // comentario aqui
      { return idade; }
   
   
}  // Final da Classe Jogador
