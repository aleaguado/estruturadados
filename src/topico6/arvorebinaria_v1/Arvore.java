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
      No corrente = raiz;           // corrente é a referência de nó que ficará sobre o nó da vez
      No pai = raiz;             // é necessário uma referência sobre o pai também ...
      boolean filhoEsquerda = true;

      while(corrente.getOrdem() != ordem)        // vamos buscar o que vamos remover!
         {
         pai = corrente;                      //o nó pai passa a ser o nó corrente ... 
         if(ordem < corrente.getOrdem())         // vamos para o lado esquerdo? ... 
            {
            filhoEsquerda = true;                // marcamos que estamos no lado esquerdo
            corrente = corrente.getFilhoEsquerdo();
            }
         else                            //vamos para o lado direito ... 
            {
            filhoEsquerda = false;      // marcamos que estamos no lado direito
            corrente = corrente.getFilhoDireito();
            }
         if(corrente == null)             // se o nó corrente for null é pq é o final ...
            return false;                // ... e não encontramos!!!
         }  // terminamos o while
      
      // IMPORTANTE: passamos por aqui se terminamos o while e aqui estaremos com a referencia
      // corrente sob o nó que vamos remover e a referência pai sobre o nó pai dele ...

      //CASO 1: O nó a ser removido não tem filhos ... é nó FOLHA ...
      // se o nó não tiver filhos, é só colocar ele como null ..
      if(corrente.getFilhoEsquerdo()==null &&
                                   corrente.getFilhoDireito()==null)
         {
         if(corrente == raiz)             // se for o nó raiz ...
            raiz = null;                 // deixamos nossa raiz NULL ...
         else if(filhoEsquerda)          // se ele for um filho a esquerda ....
            pai.setFilhoEsquerdo(null);     // disconectados o filho a esquerda do pai dele ...
         else                            // senão ...
            pai.setFilhoDireito(null);      // disconectamos o filho a direito do pai dele ...
         }

      
      // CASO 2: Se não existe filho a direita!!!
      // nesse caso substituimos pela arvore da esquerda
      else if(corrente.getFilhoDireito()==null)
         if(corrente == raiz)       //se for nó raiz ...
            raiz = corrente.getFilhoEsquerdo(); // a raiz passa a ser o filho da esquerda ...
         else if(filhoEsquerda) //se ele for um filho a esquerda ...
            pai.setFilhoEsquerdo(corrente.getFilhoEsquerdo());  // disconectamos o pai do filho a esquerda
         else           // senão
            pai.setFilhoDireito(corrente.getFilhoEsquerdo()); //disconectamos o pai do filho a direita

      //CASO 3: Se não existe filho a esquerda!!!
      // nesse caso substituimos pela arvore a direita
      else if(corrente.getFilhoEsquerdo()==null)
         if(corrente == raiz)
            raiz = corrente.getFilhoDireito();
         else if(filhoEsquerda)
            pai.setFilhoEsquerdo(corrente.getFilhoDireito());
         else
            pai.setFilhoDireito(corrente.getFilhoDireito());

      else  // CASO 4: Se existem os dois filhos ...
         {
         // Substituimos pelo Sucessor ... 
         No successor = getSuccessor(corrente);

         // conectando o pai aos sucessores ...
         if(corrente == raiz)   // se for a raiz ....
            raiz = successor;   // a raiz passa a ser o sucessor ...
         else if(filhoEsquerda) // se o removido for a esquerda ...
            pai.setFilhoEsquerdo(successor);    // conectamos o filho do pai a esquerda ...
         else
            pai.setFilhoDireito(successor);     // senão conectamos o filho a direita do pai ...

         // connectamos o sucessor aos seus filhos ... 
         successor.setFilhoEsquerdo(corrente.getFilhoEsquerdo());
         }  // final do else de ter dois filhos ...
      return true;                                // retornamos que deu certo 
    }

      private No getSuccessor(No delNode)
      {
      No successorPai = delNode; // o nó sucessorPai começa sendo o nó que queremos deletar ...
      No successor = delNode;   // o nó sucessor também ...
      No corrente = delNode.getFilhoDireito();   // vamos para a direita do nó que queremos deletar
      while(corrente != null)               // enquanto não chegarmos na folha 
         {                                 // mais a esquerda do lado direito
         successorPai = successor;          // o pai passa a ser o sucessor
         successor = corrente;              // o sucessor passa a ser o corrente
         corrente = corrente.getFilhoEsquerdo();      // o corrente para a ser o filho a esquerda
         }
         //chegamos aqui quando o corrente aponta prabaixo da folha ...
      
      if(successor != delNode.getFilhoDireito())  // se o sucessor não é o filho a direita
         {                                 // do nó deletado vamos ...
         successorPai.setFilhoEsquerdo(successor.getFilhoDireito()); // fazer o filho a esquerda do pai
         successor.setFilhoDireito(delNode.getFilhoDireito());       // do sucessor apontar p/ a arvore
         }                                                          // a direita do sucessor ...
      return successor;         // e retornamos o sucessor ...
      }
    
    
}
