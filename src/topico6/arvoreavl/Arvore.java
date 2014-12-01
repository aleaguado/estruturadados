/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico6.arvoreavl;

/**
 *
 * @author aleaguado
 */
public class Arvore {
    private No raiz;
    
    public Arvore(){
        raiz = null;
    }
    
    public String getRaiz(){
        return raiz.printDebug();
    }
    
    public void inserir(int idade, String nome) {
      No novoNo = new No(idade, nome);    // criamos o novo nó

      if(raiz==null) {                // se for o primeiro a ser inserido ...
         raiz = novoNo;             // ele será o nó raiz
         raiz.setAltD(0);
         raiz.setAltE(0);
      }
      else                          // senão ... 
         {
         No corrente = raiz;        // começamos a nossa busca pelo lugar de inserção pela raiz ...
         No pai;                    // o nó pai é o que buscamos ...
         while(true)                // rodaremos nosso while infinitamente ...
            {
            pai = corrente;
            if(idade < corrente.getIdade())  // se nosso número é menor que o nó corrent ...
               {             
               corrente = corrente.getFilhoEsquerdo();  // vamos para a esquerda ... (O PAI NÃO MUDA AINDA)                
               if(corrente == null)                      // se chegarmos na folha ...
                  {                                     // é aqui que inserimos ...
                  pai.setFilhoEsquerdo(novoNo);
                  novoNo.setPai(pai);
                    this.reajustarAltura(novoNo);                                 //temos que ajustar e balancear                  
                  if ((novoNo != raiz) && (pai.getFilhoDireito() == null)) {//se a inserção provocou aumento de altura

                    this.balancear(novoNo); }// Irá checar o balanceamento da árvore superior e corrigirá ...
                    this.reajustarAltura(novoNo);
                  return;
                  }
               }  // final do IF a esquerda ...
            else                    // e se formos para a direita ...
               {

               corrente = corrente.getFilhoDireito();
               if(corrente == null)  // se chegamos ao final
                  {                 // inserimos ele!!!
                  pai.setFilhoDireito(novoNo);
                  novoNo.setPai(pai);
                  this.reajustarAltura(novoNo); 
                  if ((novoNo != raiz) && (pai.getFilhoEsquerdo() == null)){ //se a inserção provocou aumento de altura           
                    this.balancear(novoNo); // Irá checar o balanceamento da árvore superior e corrigirá ...
                    this.reajustarAltura(novoNo); }
                  return;
                  }
               }  // fim
            }  // fim do while
         }  // fimmm

    }
    
    private void reajustarAltura(No inicial){
        No corrente;
        
        if (inicial == raiz )
            return;
        
        corrente = inicial;

        while (corrente != raiz) {
            if (corrente.getPai().getFilhoDireito() == corrente) { // se eu sou o filho a direita
                corrente.getPai().setAltD(corrente.getAlturaMaxima() + 1);
                
            } else { // se não sou filho a direita do meu pai
                corrente.getPai().setAltE(corrente.getAlturaMaxima() + 1);
            }
            corrente = corrente.getPai();
        }
             
    }
    
      private void balancear(No folhaInserida) {
        
        No corrente = folhaInserida.getPai();
        
        //Buscamos na árvore genealógica um nó desequilibrado
        while ((corrente.getTamanho() <= 1) && (corrente.getTamanho() >= -1)) 
        {
            if ( corrente == raiz )
                return;
            
            corrente = corrente.getPai();
        }   // Se encontramos saimos do while ... 
        
        // Se chegar aqui é porque esta desbalanceado... vamos fazer os testes

        
        if (corrente.getTamanho() > 1) { //Se o desbalanço for positivo
            if (corrente.getFilhoEsquerdo().getTamanho() >= 0) { // Se o desbalanço do filho for positivo
                //rotação simples a direita
                if (raiz == corrente)
                    raiz = corrente.getFilhoEsquerdo();
                
                rsd(corrente,corrente.getFilhoEsquerdo());
                
                }
            else {
                if (raiz == corrente)
                    raiz = corrente.getFilhoEsquerdo().getFilhoDireito();
                //rotação dupla a direita
                rse(corrente.getFilhoEsquerdo(),corrente.getFilhoEsquerdo().getFilhoDireito() );
                rsd(corrente,corrente.getFilhoEsquerdo());
                  }
        } else {                        // Se o desbalanço for negativo
            if (corrente.getFilhoDireito().getTamanho() < 0) { // Se o desbalanço do filho for positivo
                if (raiz == corrente)
                    raiz = corrente.getFilhoDireito();
                //rotação simples a esquerda
                rse(corrente,corrente.getFilhoDireito());
                }
            else {
                if (raiz == corrente)
                    raiz = corrente.getFilhoDireito().getFilhoEsquerdo();
                //rotação dupla a esquerda
                rsd(corrente.getFilhoDireito(), corrente.getFilhoDireito().getFilhoEsquerdo());
                rse(corrente, corrente.getFilhoDireito());            
                }        
        }   
    }
    
    private void rsd(No desbal, No filho) {
        No aux; //Esse nó será utilizado para guardar o nó filho no caso de troca
        
        
            aux = filho.getFilhoDireito();
            filho.setFilhoDireito(desbal);
            filho.setPai(desbal.getPai());
            
            if (desbal.getPai() != null) { //Confere se o desbalanceado não é a raiz sem pai
                if ( desbal.getPai().getFilhoDireito() == desbal ) // se eu sou o filho a direita
                    desbal.getPai().setFilhoDireito(filho);         // aviso meu pai ...
                else                                                // senão ...
                    desbal.getPai().setFilhoEsquerdo(filho);        //aviso que sou o filho a esq.
            }
                
                
            desbal.setPai(filho);                               //E o filho virou pai do pai ...
            desbal.setFilhoEsquerdo(aux);                         // O filho herdará a árvore de
                                                                // onde ele substituiu ...
                                                                //Vamos ajustar as alturas ...
            // A altura a esquerda do nó "pai" que vai virar filho, para ser a altura a direta do filho
            desbal.setAltE(filho.getAltD());
            // A altura a direta do filho que virou pai, vai ser a maior do novo filho + 1
            if (desbal.getAltD() > desbal.getAltE())
                filho.setAltD(desbal.getAltD() + 1);
            else
                filho.setAltD(desbal.getAltE() + 1);            
    }
    
    private void rse(No desbal, No filho) {
            No aux; //Esse nó será utilizado para guardar o nó filho no caso de troca
        
            aux = filho.getFilhoEsquerdo();
            filho.setFilhoEsquerdo(desbal);
            filho.setPai(desbal.getPai());
            
            if (desbal.getPai() != null ) {
                if ( desbal.getPai().getFilhoDireito() == desbal ) // se eu sou o filho a direita
                    desbal.getPai().setFilhoDireito(filho);         // aviso meu pai ...
                else                                                // senão ...
                    desbal.getPai().setFilhoEsquerdo(filho);        //aviso que sou o filho a esq.
            }
                
            desbal.setPai(filho);                               //E o filho virou pai do pai ...
            desbal.setFilhoDireito(aux);                         // O filho herdará a árvore de
                                                                // onde ele substituiu ...
            //Vamos ajustar as alturas ...
            // A altura a direita do nó "pai" para ser a altura a esquerda do filho
            desbal.setAltD(filho.getAltE());
            // A altura a esquerda do filho que virou pai, vai ser a maior do novo filho + 1
            if (desbal.getAltD() > desbal.getAltE())
                filho.setAltE(desbal.getAltD() + 1);
            else
                filho.setAltE(desbal.getAltE() + 1);       
            
    }

    public No buscar(int idade) {
        No corrente = raiz;               // começaremos a busca da raiz
        while(corrente.getIdade() != idade)        // enquanto não encontramos o item que queremos
            {
                System.out.println("Passei pelo: " + corrente.getIdade());
            if(idade < corrente.getIdade())                    // se o que buscamos é menor ...
               corrente = corrente.getFilhoEsquerdo();         // vamos para o lado esquerdo!!        
            else                                               // se o que buscamos é maior ...
               corrente = corrente.getFilhoDireito();          // vamos para o lado direito
            if(corrente == null)                               // mas se o nó for folha ...
               return null;                                    // é sinal que não encontramos!!!
         }
      return corrente;                      // se rodamos o WHILE e chegamos aqui é porque o nó corrente
                                            // é o que buscamos!!!
    }
    
    public boolean remover(int idade) {
      No corrente = raiz;           // corrente é a referência de nó que ficará sobre o nó da vez
      No pai = raiz;             // é necessário uma referência sobre o pai também ...
      boolean filhoEsquerda = true;

      while(corrente.getIdade() != idade)        // vamos buscar o que vamos remover!
         {
         pai = corrente;                      //o nó pai passa a ser o nó corrente ... 
         if(idade < corrente.getIdade())         // vamos para o lado esquerdo? ... 
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
         else if(filhoEsquerda) {         // se ele for um filho a esquerda ....
            pai.setFilhoEsquerdo(null);     // disconectados o filho a esquerda do pai dele ...
            pai.setAltE(0);
            this.reajustarAltura(pai);
         }
         else  {                           // senão ...
            pai.setFilhoDireito(null);      // disconectamos o filho a direito do pai dele ...
            pai.setAltD(0);
            this.reajustarAltura(pai);
         }
         }

      
      // CASO 2: Se não existe filho a direita!!!
      // nesse caso substituimos pela arvore da esquerda
      else if(corrente.getFilhoDireito()==null)
         if(corrente == raiz)       //se for nó raiz ...
            raiz = corrente.getFilhoEsquerdo(); // a raiz passa a ser o filho da esquerda ...
         else if(filhoEsquerda) {//se ele for um filho a esquerda ...
            pai.setFilhoEsquerdo(corrente.getFilhoEsquerdo());  // disconectamos o pai do filho a esquerda
            corrente.getFilhoEsquerdo().setPai(pai); //Referencia para o pai ...
            pai.setAltE(pai.getAltE() - 1);
            this.reajustarAltura(pai);
         }
         else        {   // senão
            pai.setFilhoDireito(corrente.getFilhoEsquerdo()); //disconectamos o pai do filho a direita
            corrente.getFilhoEsquerdo().setPai(pai);  //Referencia para o pai ...
             pai.setAltD(pai.getAltD() - 1);
             this.reajustarAltura(pai);
         }
      //CASO 3: Se não existe filho a esquerda!!!
      // nesse caso substituimos pela arvore a direita
      else if(corrente.getFilhoEsquerdo()==null)
         if(corrente == raiz)
            raiz = corrente.getFilhoDireito();
         else if(filhoEsquerda) {
            pai.setFilhoEsquerdo(corrente.getFilhoDireito());
            corrente.getFilhoDireito().setPai(pai); //Referencia para o pai ...
            pai.setAltE(pai.getAltE() - 1);
            this.reajustarAltura(pai);
         }
         else {
            pai.setFilhoDireito(corrente.getFilhoDireito());
            corrente.getFilhoDireito().setPai(pai); //Referencia para o pai ...
            pai.setAltD(pai.getAltD() - 1);
            this.reajustarAltura(pai);
         }
      else  // CASO 4: Se existem os dois filhos ...
         {
         // Substituimos pelo Sucessor ... 
         No successor = getSuccessor(corrente);
         
         //Ja ajustamos a altura dos nós ...
         if (successor == successor.getPai().getFilhoDireito())
             successor.getPai().setAltD(successor.getPai().getAltD() - 1);
        else
             successor.getPai().setAltE(successor.getPai().getAltE() - 1);
         this.reajustarAltura(successor);

         // conectando o pai aos sucessores ...
         if(corrente == raiz)   // se for a raiz ....
            raiz = successor;   // a raiz passa a ser o sucessor ...
         else if(filhoEsquerda) { // se o removido for a esquerda ...
            pai.setFilhoEsquerdo(successor);    // conectamos o filho do pai a esquerda ...
            successor.setPai(pai);
         }
         else {
            pai.setFilhoDireito(successor);     // senão conectamos o filho a direita do pai ...
            successor.setPai(pai);
         }
         // connectamos o sucessor aos seus filhos ... 
         successor.setFilhoEsquerdo(corrente.getFilhoEsquerdo());
         corrente.getFilhoEsquerdo().setPai(successor);
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
      
     public void percorrer(int TipoDeAcesso)
      {
      switch(TipoDeAcesso)
         {
         case 1: System.out.print("\nTravessial em Pré Ordem: ");
                 preOrdem(raiz);
                 break;
         case 2: System.out.print("\nTraveria em Ordem:  ");
                 emOrdem(raiz);
                 break;
         case 3: System.out.print("\nTravessia em Pós Ordem: ");
                 posOrdem(raiz);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrdem(No raizLocal)
      {
      if(raizLocal != null)
         {
         System.out.println(raizLocal.printDebug() + " ");
         preOrdem(raizLocal.getFilhoEsquerdo());
         preOrdem(raizLocal.getFilhoDireito());
         }
      }
// -------------------------------------------------------------
   private void emOrdem(No raizLocal)
      {
      if(raizLocal != null)
         {
         emOrdem(raizLocal.getFilhoEsquerdo());
         System.out.println(raizLocal.printDebug() + " ");
         emOrdem(raizLocal.getFilhoDireito());
         }
      }
// -------------------------------------------------------------
   private void posOrdem(No raizLocal)
      {
      if(raizLocal != null)
         {
         posOrdem(raizLocal.getFilhoEsquerdo());
         posOrdem(raizLocal.getFilhoDireito());
         System.out.println(raizLocal.getNo() + " ");
         }
      }   
}