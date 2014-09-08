/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Este Código foi adaptado do programa apresentado no livro Estruturas de Dados e Algoritmos em Java
// Robert Lafore

package topico2_ordenacao;

/**
 *
 * @adaptador aleaguado
 */
public class EstruturaDados {
    
   private long[] a;                 // criamos a referência para um array Long
   private int nElems;               // controla a qty de itens no vetor
//--------------------------------------------------------------
   public EstruturaDados(int max)          // Método construtor
      {
      a = new long[max];                    // Instancia um novo array
      nElems = 0;                        // coloca no inicio a variavel nElems c/ zero elemento
      }
//--------------------------------------------------------------
   public void insert(long value)    // rotina de inserção DESORDENADA!!!
      {
      a[nElems] = value;             // insere o valor na primeira posição livre
      nElems++;                      // incrementa nElems 
      }
//--------------------------------------------------------------
   public void display()             // rotina para imprimir na tela os itens existentes
      {
      for(int j=0; j<nElems; j++)       // para cada elemento
         System.out.print(a[j] + " ");  // vamos imprimi-lo
      System.out.println("");
      }
//--------------------------------------------------------------
   // Rotina de Ordenação pelo método Bolha (BubbleSort)
   //-----------------------------------------------------------
   public void bubbleSort()
      {
      int out, in;

      for(out=nElems-1; out>1; out--)   // este for roda até que tenhamos certeza que até o primeiro item esta ordenado
         for(in=0; in<out; in++)        // este for que irá caminhar uma posição a direita comparando os itens
            if( a[in] > a[in+1] )       // out aqui que comparamos um valor com o outro e quado o da esquerda for maior
               swap(in, in+1);          // nós chamamos o método que faz a troca.
      }
   
//--------------------------------------------------------------
   //--------------------------------------------------------------
   // Rotina de Ordenação pelo método de Seleção (SelectionSort)
   //-----------------------------------------------------------
     public void selectionSort()
      {
      int out, in, min;

      for(out=0; out<nElems-1; out++)   // este for roda até que tenhamos certeza que até o ultimo item esta ordenado
         {
         min = out;                     // inicialmente a primeira posiçãp (out) é considerada a menor
         for(in=out+1; in<nElems; in++) // mas vamos varrer todos itens pra ter certeza ...
            if(a[in] < a[min] )         // e se encontrarmos um novo item menor
                min = in;               // ele irá para variavel min
         swap(out, min);                // e ao final colocamos o menor no lugar dele
         }  // end for(out)             // e seguimos o for até que todos estejam ordenados!!!    
      }  // end selectionSort()
   //--------------------------------------------------------------   
        //--------------------------------------------------------------
   // Rotina de Ordenação pelo método de Inserção (InsertSort)
   //-----------------------------------------------------------
       public void insertionSort()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // vamos rodar até o final do vetor
         {
         long temp = a[out];            // jogamos em uma variável temporária o item marcado
         in = out;                      // inicializamos a variavel in, que ira receber o valor a esquerda
         while(in>0 && a[in-1] >= temp) // enquanto o item a esquerda for maior que o marcado ...
            {
            a[in] = a[in-1];            // ...nós fazemos eles pularem uma casa a direita
            --in;                       
            }                           // ... quando o item for menor, ele nao pula!
         a[in] = temp;                  // ...inserimos o valor marcado na posição que ficou "livre", ou seja,
                                        // onde estava o último item a esquerda maior que o marcado
         }  // end for
      }  // end insertionSort()
//--------------------------------------------------------------   
   private void swap(int one, int two) //Simples rotina onde é efetuada a troca!!!
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
}