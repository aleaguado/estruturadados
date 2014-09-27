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
public class Usuaria {
    public static void main(String[] args)
      {
      pilha p = new pilha(10);  // criar uma pilha de 10 posições
      p.inserir(20);               // vamos inserir 4 itens
      p.inserir(40);
      p.inserir(60);
      p.inserir(80);

      while( !p.estaVazio())     // enquanto não estiver vazia a pilha
         {                             
         long value = p.remove();       //remova o item do topo
         System.out.print(value);      // e retorne o valor dele
         System.out.print(" ");
         }  // fim do while
      System.out.println("");
      }  // fim do metodo main
    //OBS: Não esqueça que geralmente a pilha, tem como função fazer algo
    //para o programador, então com certa frequência ela se enche e se 
    //esvazia!!!   
}
