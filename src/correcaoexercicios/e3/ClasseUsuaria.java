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
import java.util.Scanner;


/**
 *
 * @author aleaguado
 */
public class ClasseUsuaria {
  
    public static void main(String[] args)
          {
              int maxSize = 100;            // coloca em uma constante o tamanho do vetor
              EstruturaDadosE3 arr = new EstruturaDadosE3(maxSize);               
              Scanner entrada = new Scanner (System.in); //Instancio o objeto entrada do tipo Scanner
              Scanner entradadouble = new Scanner (System.in);
              System.out.println("Bem Vindo caro Paleontólogo!!!");
              
              //Se quiser perguntar pro usuário descomente o FOR abaixo e comente a outra forma de inserção
              //for (int i = 1; i < 6; i++) {
              //   System.out.println("Digite o nome do dinossauro" + i);
              //   String nome = entrada.nextLine();
             //    System.out.println("Digite a cor do(a) " + nome);
              //   String cor = entrada.nextLine();
             //    System.out.println("Digite o tamanho do(a) " + nome);
              //   double tamanho = entradadouble.nextDouble();
              //   arr.insert(nome, cor, tamanho);
              //}
              //INSERÇÃO PARA GANHAR TEMPO
              arr.insert("Tiranossauro Rex", "verde", 10.5);
              arr.insert("Brutanossauro", "vermelho", 9.5);
              arr.insert("Titerodapius", "azul", 10.5);
              arr.insert("EstinctusDapius", "verde", 11.0);
              arr.insert("EstructurusSauro", "amarelo", 5.00);

              System.out.println("Vamos ver se esta ordenado por cor?:");
              
              arr.display();
              
              System.out.println("Muito bem! Vamos fazer uma busca binária por cor?");
              System.out.println("Digite o nome de uma cor que iremos imprimir os dinos: ");
              
              if (!arr.findPorCor(entrada.nextLine()))
                    System.out.println("Nenhum dinossauro encontrado");

              System.out.println("Vamos buscar agora por tamanho? Mas antes vou ordenar por Tamanho!");
              System.out.println("Ordenando ...");
              arr.ordenaPorTamanho();
              System.out.println("Pronto! Digite agora o tamanho que deseja: ");
              
             if (!arr.findPorTamanho(entradadouble.nextDouble()))
                    System.out.println("Nenhum dinossauro encontrado");
              
              System.out.println("Muito bem! Para finalizar vou imprimir todos os bixos na nova ordem, ok?");

              arr.display();
          }      
          
}