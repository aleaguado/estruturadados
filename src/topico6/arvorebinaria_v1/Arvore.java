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
public class Arvore {
    private No raiz;
    
    public Arvore(){
        raiz = null;
    }
    
    public void inserir(int ordem, String nome) {
      No novoNo = new No(ordem, nome);    // criamos o novo nó

      if(raiz==null)                // se for o primeiro a ser inserido ...
         raiz = novoNo;             // ele será o nó raiz
      else                          // senão ... 
         {
         No corrente = raiz;        // começamos a nossa busca pelo lugar de inserção pela raiz ...
         No pai;                    // o nó pai é o que buscamos ...
         while(true)                // rodaremos nosso while infinitamente ...
            {
            pai = corrente;
            if(ordem < corrente.getOrdem())  // se nosso número é menor que o nó corrent ...
               {
               corrente = corrente.getFilhoEsquerdo();  // vamos para a esquerda ... (O PAI NÃO MUDA AINDA) 
               if(corrente == null)                      // se chegarmos na folha ...
                  {                                     // é aqui que inserimos ...
                  pai.setFilhoEsquerdo(novoNo);
                  return;
                  }
               }  // final do IF a esquerda ...
            else                    // e se formos para a direita ...
               {
               corrente = corrente.getFilhoDireito();
               if(corrente == null)  // se chegamos ao final
                  {                 // inserimos ele!!!
                  pai.setFilhoDireito(novoNo);
                  return;
                  }
               }  // fim
            }  // fim do while
         }  // fimmm
    
    }
    
    public No buscar(int ordem) {
        No corrente = raiz;               // começaremos a busca da raiz
        while(corrente.getOrdem() != ordem)        // enquanto não encontramos o item que queremos
            {
            if(ordem < corrente.getOrdem())                    // se o que buscamos é menor ...
               corrente = corrente.getFilhoEsquerdo();         // vamos para o lado esquerdo!!        
            else                                               // se o que buscamos é maior ...
               corrente = corrente.getFilhoDireito();          // vamos para o lado direito
            if(corrente == null)                               // mas se o nó for folha ...
               return null;                                    // é sinal que não encontramos!!!
         }
      return corrente;                      // se rodamos o WHILE e chegamos aqui é porque o nó corrente
                                            // é o que buscamos!!!
    }
    
    public boolean remover(int ordem) {
      No corrente = raiz;
      No parent = raiz;
      boolean filhoEsquerda = true;

      while(corrente.getOrdem() != ordem)        // enquanto não encontramos
         {
         parent = corrente;
         if(ordem < corrente.getOrdem())         // go left?
            {
            filhoEsquerda = true;
            corrente = corrente.getFilhoEsquerdo();
            }
         else                            // or go right?
            {
            filhoEsquerda = false;
            corrente = corrente.getFilhoDireito();
            }
         if(corrente == null)             // end of the line,
            return false;                // didn't find it
         }  // end while
      // found node to delete

      // if no children, simply delete it
      if(corrente.getFilhoEsquerdo()==null &&
                                   corrente.getFilhoDireito()==null)
         {
         if(corrente == raiz)             // if raiz,
            raiz = null;                 // tree is empty
         else if(filhoEsquerda)
            parent.setFilhoEsquerdo(null);     // disconnect
         else                            // from parent
            parent.setFilhoDireito(null);
         }

      // if no right child, replace with left subtree
      else if(corrente.getFilhoDireito()==null)
         if(corrente == raiz)
            raiz = corrente.getFilhoEsquerdo();
         else if(filhoEsquerda)
            parent.setFilhoEsquerdo(corrente.getFilhoEsquerdo());
         else
            parent.setFilhoDireito(corrente.getFilhoEsquerdo());

      // if no left child, replace with right subtree
      else if(corrente.getFilhoEsquerdo()==null)
         if(corrente == raiz)
            raiz = corrente.getFilhoDireito();
         else if(filhoEsquerda)
            parent.setFilhoEsquerdo(corrente.getFilhoDireito());
         else
            parent.setFilhoDireito(corrente.getFilhoDireito());

      else  // two children, so replace with inorder successor
         {
         // get successor of node to delete (corrente)
         No successor = getSuccessor(corrente);

         // connect parent of corrente to successor instead
         if(corrente == raiz)
            raiz = successor;
         else if(filhoEsquerda)
            parent.setFilhoEsquerdo(successor);
         else
            parent.setFilhoDireito(successor);

         // connect successor to corrente's left child
         successor.setFilhoEsquerdo(corrente.getFilhoEsquerdo());
         }  // end else two children
      // (successor cannot have a left child)
      return true;                                // success
   
    }

      private No getSuccessor(No delNode)
      {
      No successorParent = delNode;
      No successor = delNode;
      No current = delNode.getFilhoDireito();   // go to right child
      while(current != null)               // until no more
         {                                 // left children,
         successorParent = successor;
         successor = current;
         current = current.getFilhoEsquerdo();      // go to left child
         }
                                           // if successor not
      if(successor != delNode.getFilhoDireito())  // right child,
         {                                 // make connections
         successorParent.setFilhoEsquerdo(successor.getFilhoDireito());
         successor.setFilhoDireito(delNode.getFilhoDireito());
         }
      return successor;
      }
    
    
}
