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
import java.util.Scanner;


/**
 *
 * @author aleaguado
 */
public class Usuaria {
  
    public static void main(String[] args)
          {
              int maxSize = 100;            // coloca em uma constante o tamanho do vetor
              Estrutura arr = new Estrutura(maxSize);               
              Scanner entrada = new Scanner (System.in); //Instancio o objeto entrada do tipo Scanner
              Scanner entradaint = new Scanner (System.in);
              Scanner entradafloat = new Scanner (System.in);
              System.out.println("Bem Vindo ao Exercicio Avançado!!!");

              for (int i = 1; i < 6; i++) {
                 System.out.println("Digite o nome " + i);
                 String nome = entrada.nextLine();
                 System.out.println("Digite a altura do(a) " + nome + " separada por virgula!");
                 float altura = entradafloat.nextFloat();
                 System.out.println("Digite a idade do(a) " + nome);
                 int idade = entradaint.nextInt();
                 arr.insert(nome, altura, idade);
                  System.out.println("Digite 0 para parar a inserção ou 1 para continuar!");
                  if (entradaint.nextInt() == 0)
                      break;
              }

              System.out.println("Muito Bem! Digite a idade para buscar um jogador:");

              if (!arr.findIdade(entradaint.nextInt()))
                  System.out.println("Não encontrado nenhum nome!!");
              
              System.out.println("Digite um nome para buscar:");
              
              int posicao = arr.findNome(entrada.nextLine());
              
              if (posicao != arr.size())
                    System.out.println("Encontrei na posicao " + posicao );
              else
                    System.out.println("Não encontrado");
              
              System.out.println("Vamos listar todos jogadores cadastrados? Ai estão ...");
              arr.display();
          }      
          
}