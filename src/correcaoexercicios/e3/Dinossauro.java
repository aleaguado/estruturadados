/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e3;

/**
 *
 * @author aleaguado
 */
public class Dinossauro
   { 
   private String nome;
   private String cor;
   private double tamanho;
//--------------------------------------------------------------
   public Dinossauro(String n, String c, double t)
      {                               // comentario aqui
      nome = n;
      cor = c;
      tamanho = t;
      }
//--------------------------------------------------------------
   public void displayDino()
      {
      System.out.print("   Nome: " + nome);
      System.out.print(", Cor: " + cor);
      System.out.println(", Tamanho: " + tamanho);
      }
//--------------------------------------------------------------
   public String getNome()           // comentario aqui
      { return nome; }
   
   public String getCor()           // comentario aqui
      { return cor; }

   public double getTamanho()           // comentario aqui
      { return tamanho; }

}  // Final da Classe Dinossauro