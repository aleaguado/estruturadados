/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico3.pilhaex;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author aleaguado
 */
class PilhaApp
   {
   public static void main(String[] args) throws IOException
      {
      String input;
      Scanner e = new Scanner(System.in);
      while(true) //Feito para rodar infinitamente..ou até ter um break
         {
         System.out.print(
                      "Digite uma String que tenha delimitadores: ");
         System.out.flush();
         input = e.nextLine();
         if( input.equals("") )   // se não foi digitado nada, ele encerra...
            break;
                                  // cria o objeto do tipo Verificador de Conchetes
                                  // passando a entrada como parametro
         VerificadorConchetes theChecker = new VerificadorConchetes(input);
         theChecker.check();      // pede para verificar!!!
         }  // finaliza o while
      }  // finaliza o metodo main
//--------------------------------------------------------------

   }  // finaliza a classe