/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e6;

/**
 *
 * @author aleaguado
 */
public class Paciente {
    int prioridade; //controlará a prioridade do atendimento
    String nome;   // controlará o nome do usuário
    
    public Paciente(int p, String n) { // metodo construtor
            prioridade = p;  // atribui a prioridade que vem por parametro
            nome = n;        // atribui o nome que vem por parametro
    }
    
    public int getPriori() {
        return prioridade;
    }
      
    
    public String[] Display() { //O  metodo display vai retornar um vetor para quem o chamar!!!
        String[] ret  = new String[2];
        ret[0] = nome;
         switch(prioridade){
                    case 0:{ ret[1]="Alta"; 
                        break;}
                    case 1:{ ret[1]="Média"; 
                        break;}
                    case 2:{ ret[1]="Baixa";
                        break;}
                    }
        return ret;
    }   
}
