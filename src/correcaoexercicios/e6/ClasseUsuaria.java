/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e6;

import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class ClasseUsuaria {


    public static void main(String[] args){
            Scanner entInt = new Scanner(System.in);
            Scanner entString = new Scanner(System.in);
            FilaPrioridade fila = new FilaPrioridade(100);
            String nome;
            int priori;
        
        System.out.println("Caro usuário, seja bem vindo ao SUS!!!");
        
        while(true) {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Para inserir paciente: ");
            System.out.println("2 - Para chamar próximo: ");
            System.out.println("3 - Para sair do sistema: ");
            int opcao = entInt.nextInt();
          
        switch(opcao){
            case 1: {
                System.out.println("Digite o nome do paciente: ");
                nome = entString.nextLine();
                System.out.println("Digite a prioridade do paciente: ");
                priori = entInt.nextInt();
                if (fila.estaCheio()){
                    System.out.println("Não há espaço!!!");
                } else {
                    fila.insert(priori, nome);
                }
                break;
            }
            case 2: { 
                String[] rem = fila.remove();
                System.out.println("O proximo paciente é: ");
                System.out.println("Nome: " + rem[0] + " - Prioridade " + rem[1]);
                 break;
            }
            
            case 3: {
                System.out.println("Obrigado por usar o sistema!!!");
                break;
            }
            default: {
                System.out.println("Opção Invalida!!!");
                //return null; 
                break;
                 
            }
            }
        
        }
        
        }

    }
