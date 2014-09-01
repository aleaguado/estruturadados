/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desafios.Desafio2;

/**
 *
 * @author aleaguado
 */
public class Pessoa
   { 
   private String nome;
   private String profissao;
   private int idade;
//--------------------------------------------------------------
   public Pessoa(String n, String p, int id)
      {                               // comentario aqui
      nome = n;
      profissao = p;
      idade = id;
      }
//--------------------------------------------------------------
   public void displayPessoa()
      {
      System.out.print("   Nome: " + nome);
      System.out.print(", Profissao: " + profissao);
      System.out.println(", Idade: " + idade);
      }
//--------------------------------------------------------------
   public String getNome()           // comentario aqui
      { return nome; }
   }  // Final da Classe Pessoa