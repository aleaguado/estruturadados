/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico2_demo;

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
              EstruturaDadosDemo arr = new EstruturaDadosDemo(maxSize); // instancia a estrutura de dados
              Scanner entrada = new Scanner (System.in); //Instancio o objeto entrada do tipo Scanner
              Scanner entradaint = new Scanner (System.in);
              System.out.println("Bem Vindo ao Programa de Vetores!!!");
              
              for (int i = 1; i < 6; i++) {
                 System.out.println("Digite o nome " + i);
                 String nome = entrada.nextLine();
                 System.out.println("Digite a profissao do(a) " + nome);
                 String profissao = entrada.nextLine();
                 System.out.println("Digite a idade do(a) " + nome);
                 int idade = entradaint.nextInt();
                 arr.insert(nome, profissao, idade);
              }

              System.out.println("Vamos ver se esta ordenado por nome:");
              
              arr.display();
              
              System.out.println("Muito bem! Vamos fazer uma busca binária de um nome? Digite:");
              
              int posicao = arr.findByName(entrada.nextLine());
              
              if (posicao != arr.size())
                    System.out.println("Encontrei na posicao " + posicao );
              else
                    System.out.println("Não encontrado");
              
              arr.insertionSort();
              System.out.println("Acabei de ordenar os dados por idade, ok?");
              
              arr.display();
              
              System.out.println("Vamos fazer uma busca binária por idade? Digite a idade:");

              if (arr.delete(entrada.nextLine()))   
                    System.out.println("Removido!!!");
              else  
                   System.out.println("Não encontrado!!!");  
              
              arr.display();
          }      
          
}