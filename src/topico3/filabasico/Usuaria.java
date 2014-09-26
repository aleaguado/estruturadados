/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico3.filabasico;

/**
 *
 * @author Robert Lafore - Traduzido e adaptado por Alexandre Garcia Aguado
 */
public class Usuaria {
   public static void main(String[] args)
      {
      Fila aFila = new Fila(5);  // criamos uma fila que comporta 5 itens

      if (!aFila.isFull())
        aFila.insert(10);            // inserimos 4 itens
      
      if (!aFila.isFull())
        aFila.insert(20);
      if (!aFila.isFull())
        aFila.insert(30);
      if (!aFila.isFull())
        aFila.insert(40);
      
      
      aFila.remove();              // removemos três itens (Repare que não falo quais itens ...obvio
      aFila.remove();              //   que será os 3 que entraram primeiro (10, 20, 30)
      aFila.remove();

      if (!aFila.isFull())
        aFila.insert(50);            // inserimos mais 4 itens!
      if (!aFila.isFull())
        aFila.insert(60);            //  
      if (!aFila.isFull())
        aFila.insert(70);
      if (!aFila.isFull())
        aFila.insert(80);

      while( !aFila.isEmpty() )    // enquanto a fila não estiver vazia...
         {                                
         long n = aFila.remove();  // removemos os  valores imprimindo-os!!!
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
      }  // fim do método main
    
}
