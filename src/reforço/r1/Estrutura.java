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
class Estrutura  //Criamos aqui nossa classe EstruturaVetor
   { 
   private Jogador[] a;                 // cria a referência para um vetor do tipo Jogador
   private int nElems;               // nElems controla quantos elementos o vetor terá ...
   //-----------------------------------------------------------
   public Estrutura(int max)         // método construtor
      {
      a = new Jogador[max];                 // cria o vetor ...
      nElems = 0;                        // inicialmente sem itens ...
      }

 //--------------------------------------------------------------
//Método que retorna quantidade de itens do vetor ....
//--------------------------------------------------------------
   public int size()
      { return nElems; }
 
  //--------------------------------------------------------------
//Método que faz busca Linear pelo nome
//--------------------------------------------------------------
   public int findNome(String searchKey)
      {                              // metodo buscará o valor que a classe usuaria pedir ...
      int j;
      for(j=0; j<nElems; j++)            // varrerá o vetor buscando ...
         if(a[j].getNome().equals(searchKey))           // entrou o item?
            break;                       // sai do for antes de finalizar ...
      if(j == nElems)                    // precisou chegar no final??
         return nElems;                   // se sim, retorna falso
      else
         return j;                    // se não, encontrou ...
      }  // fim da busca
   
 //--------------------------------------------------------------
//Método de pesquisa binária da altura
//--------------------------------------------------------------
   public boolean findIdade(int searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
            if (a[curIn].getIdade() == searchKey) {
             //Se encontrou, ele irá rodar pra cima e pra baixo, imprimindo os valores
             for (int i = curIn; a[i].getIdade() == searchKey; i++) {
                 a[i].displayJogador(); //imprime os dados do Jogador
                 System.out.println("==============================================");
                 if (i < nElems) //evitar erro se chegar ao final do vetor
                        break;
             }
             if (curIn == 0) //condição para evitar erro ao encontrar nome
                             // na posição zero
                 return true;
             
             for (int j = curIn-1; (a[j].getIdade() == searchKey); j--) {
                   a[j].displayJogador();//imprime os dados do Jogador
                 System.out.println("==============================================");
             }   
             return true;
         }
         else if(lowerBound > upperBound) //Condição de parada da Busca
            return false;
         else                          // divide o range
            {
             //O metodo compareTo do tipo String, retorna positivo se a primeira
             //String for maior que a segunda e negativo se for o contrário
            if(a[curIn].getIdade() < searchKey) //mudado aqui p/ desafio
               lowerBound = curIn + 1; // esta na metade de cima
            else
               upperBound = curIn - 1; // esta na metade de baixo
            }  // fim do else de divisão de range
         }  // fim do while
      }  // fim do método de pesquisa binária()     
 
//--------------------------------------------------------------
//Método de inserção ORDENADA com String!!! ....
//--------------------------------------------------------------
   public void insert(String n, float alt, int id)    // insere o elemento no vetor
      {
      int j;
      for(j=0; j<nElems; j++)        // localiza onde esse elemento se encaixa
          //usamos aqui o metodo compareTo para String
          if(a[j].getAltura() > alt)
            break;
      for(int k=nElems; k>j; k--)    // move os elementos maiores uma posição p/ frente
         a[k] = a[k-1];
      //Apos abrir um espaço no lugar certo, ele cria o nome objeto Jogador na posição aberta!!!
      a[j] = new Jogador(n, alt, id);                  // insere o elemento na posição necessária
      nElems++;                      // incrementa a variavel de controle de tamanho
      }  // finaliza o método de inserção

//--------------------------------------------------------------
//Método de remoção ....
//--------------------------------------------------------------
  
    public boolean delete(String value)
      {
      int j = findNome(value);           //Utiliza a busca binária para remover!!!
      if(j==nElems)                  // caso não encontre, retorna false!
         return false;
      else                           // caso encontre...
         {
         for(int k=j; k<nElems; k++) // move os elementos uma posição pra tras
            a[k] = a[k+1];
         nElems--;                   // decrementa o tamanho
         return true;
         }
      }  // finaliza remoção

//--------------------------------------------------------------
//Método de visualização ....
//--------------------------------------------------------------
   public void display()             // mostra o conteúdo do vetor
      {
      for(int j=0; j<nElems; j++)      
         a[j].displayJogador();
      }
   //-----------------------------------
   
}