/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico6.arvorebinaria_v1;

/**
 *
 * @author aleaguado
 */
public class ClasseUsuaria {
     public static void main(String[] args) {
         Arvore a = new Arvore();
         
         //Vamos inserir alguns itens ....
         a.inserir(10, "Antonio");
         a.inserir(30, "Bruno");
         a.inserir(60, "Roger");
         a.inserir(20, "Aparecido");
         a.inserir(50, "Malaquias");
         a.inserir(40, "Cintia");
         
         //vamos fazer uma busca:
         System.out.println("Vamos buscar o item numero 60!!!");
         
         if (a.buscar(60) != null)
            System.out.println("Encontrei: " + a.buscar(60).getNo());
         else
             System.out.println("Não encontrado!!!");
         
         System.out.println("Vamos remover o item 60!!!");
         
         if (a.remover(60))
                 System.out.println("Removido com sucesso");
         else
             System.out.println("Não foi possível resolver ...");
                        
        
         //vamos fazer uma busca:
         System.out.println("Vamos buscar o item numero 60 novamente!!!");
         
         if (a.buscar(60) != null)
            System.out.println("Encontrei: " + a.buscar(60).getNo());
         else
             System.out.println("Não encontrado!!!");
         
     }
}
