/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico3.filaprioridade;

/**
 *
 * @author aleaguado
 */
public class Usuaria   {
   public static void main(String[] args)
      {
      FilaPrioridade fila = new FilaPrioridade(5);
      fila.insert(30);
      fila.insert(50);
      fila.insert(10);
      fila.insert(40);
      fila.insert(20);

      while( !fila.isEmpty() )
         {
         long item = fila.remove();
         System.out.print(item + " ");  // 10, 20, 30, 40, 50
         }  // end while
      System.out.println("");
      }  // end main()

}
