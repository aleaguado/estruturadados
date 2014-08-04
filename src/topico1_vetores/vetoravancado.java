package topico1_vetores;

// vetoravançado.java
// demonstra uma implementação de estrutura de dados com vetor em P.O.O
////////////////////////////////////////////////////////////////

class EstruturaAvancada  //Criamos aqui nossa classe EstruturaAvancada
   {
   private long[] a;                 // cria a referência do vetor
   private int nElems;               // nElems controla quantos elementos o vetor terá ...
   //-----------------------------------------------------------
   public EstruturaAvancada(int max)         // método construtor
      {
      a = new long[max];                 // cria o vetor ...
      nElems = 0;                        // inicialmente sem itens ...
      }
//--------------------------------------------------------------
//Método de busca ....
//--------------------------------------------------------------
   public boolean find(long searchKey)
      {                              // metodo buscará o valor que a classe usuaria pedir ...
      int j;
      for(j=0; j<nElems; j++)            // varrerá o vetor buscando ...
         if(a[j] == searchKey)           // entrou o item?
            break;                       // sai do for antes de finalizar ...
      if(j == nElems)                    // precisou chegar no final??
         return false;                   // se sim, retorna falso
      else
         return true;                    // se não, encontrou ...
      }  // fim da busca
//--------------------------------------------------------------
//Método de inserção ....
//--------------------------------------------------------------
   public void insert(long value)    // insere um elemento no vetor
      {
      a[nElems] = value;             // insere nessa posição ...
      nElems++;                      // incrementa o tamanho
      }
//--------------------------------------------------------------
//Método de remoção ....
//--------------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // varre o vetor 
         if( value == a[j] )
            break;
      if(j==nElems)                  // se não encontrar retorna falso
         return false;
      else                           // se encontrar ...
         {
         for(int k=j; k<nElems; k++) // move os mais altos para "frente"
            a[k] = a[k+1];
         nElems--;                   // decrementa o contador de elementos
         return true;
         }
      }  // final do método de remoção
//--------------------------------------------------------------
//Método de visualização ....
//--------------------------------------------------------------
   public void display()             // mostra o conteúdo do vetor
      {
      for(int j=0; j<nElems; j++)      
         System.out.print(a[j] + " ");  
      System.out.println("");
      }
   //-----------------------------------------------------------
   }  // aqui termina a classe EstruturaAvancada

class VetorAvancadoApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // coloca em uma constante o tamanho do vetor
      EstruturaAvancada arr;                // cria referencia para a estrutura de dados
      arr = new EstruturaAvancada(maxSize); // instancia a estrutura de dados

      arr.insert(77);               // insere os itens
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // mostra os itens

      int searchKey = 35;           //configura para busca o item 35
      if( arr.find(searchKey) )
         System.out.println("Encontrei " + searchKey);
      else
         System.out.println("Não encontrei " + searchKey);

      arr.delete(00);               // deleta três valores
      arr.delete(55);
      arr.delete(99);

      arr.display();                // mostra na tela o vetor
      }  // fim do método main()
   }  //fim da classe VetorAvancadoApp
