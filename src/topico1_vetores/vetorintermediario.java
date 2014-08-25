package topico1_vetores;
// vetorintermediario.java
// demonstra utilização de vetor c/ pouca conceituação P.O.O
////////////////////////////////////////////////////////////////
class EstruturaDeDados  //Inicia a classe da Estrutura de Dados c/ baixo uso de P.O.O
   {
   private long[] a;                 // referência para o vetor a
//--------------------------------------------------------------
   public EstruturaDeDados(int size)         // método construtor
      { a = new long[size]; }        // instancia o vetor
//--------------------------------------------------------------
   public void setElem(int index, long value)  // metodo para setar um valor no vetor
      { a[index] = value; }
//--------------------------------------------------------------
   public long getElem(int index)              // metodo para retornar um valor no vetor
      { return a[index]; }
//--------------------------------------------------------------
   }  // final da classe BaixoVetor
////////////////////////////////////////////////////////////////
class VetorIntermediarioApp //Inicia a classe "usuaria" da estrutura de dados
   {
   public static void main(String[] args)
      {
      EstruturaDeDados arr;                 // referencia
      arr = new EstruturaDeDados(100);      // cria o objeto Baixo Vetor
      
      int nElems = 0;               // inicializa a quantidade de elementos do vetor
      int j;                        // variavel para repetição
//--------------------------------------------------------------
//Rotina de inserção ....
//--------------------------------------------------------------
      arr.setElem(0, 77);           // insere 10 itens
      arr.setElem(1, 99);
      arr.setElem(2, 44);
      arr.setElem(3, 55);
      arr.setElem(4, 22);
      arr.setElem(5, 88);
      arr.setElem(6, 11);
      arr.setElem(7, 00);
      arr.setElem(8, 66);
      arr.setElem(9, 33);
      nElems = 10;                 // informa a variavel que tem 10 elementos no vetor
//--------------------------------------------------------------
//Rotina de visualização ....
//--------------------------------------------------------------
      for(j=0; j<nElems; j++)      // mostra os elementos do vetor
         System.out.print(arr.getElem(j) + " ");
      System.out.println("");
//--------------------------------------------------------------
//Rotina de busca ....
//--------------------------------------------------------------
      int searchKey = 26;          // buscará o numero 26
      for(j=0; j<nElems; j++)            // varrerá o vetor
         if(arr.getElem(j) == searchKey) // encontrou o item?
            break;                       // Se sim, para busca
      if(j == nElems)                    // se não ...
         System.out.println("Não achei o item " + searchKey);  //informa que não achou
      else                               // se sim ...
         System.out.println("Encontrei o item " + searchKey); //informa que achou

  //--------------------------------------------------------------
//Rotina de remoção ....
//--------------------------------------------------------------
      for(j=0; j<nElems; j++)            // vamos buscar por ele ...
      if(arr.getElem(j) == 55)           // se achou para no ponto ...
         break;
      for(int k=j; k<nElems; k++)        // e rearranja o vetor!
         arr.setElem(k, arr.getElem(k+1) );
      nElems--;                          // depois decrementa da variável
//--------------------------------------------------------------
//Rotina de visualização ....
//--------------------------------------------------------------
      
      for(j=0; j<nElems; j++)      // e mostra os itens novamente
         System.out.print( arr.getElem(j) + " ");
      System.out.println("");
      }  // fim do método main()
   }  // fim da classe VetorIntermediarioApp
////////////////////////////////////////////////////////////////
