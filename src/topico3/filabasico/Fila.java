/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico3.filabasico;

/**
 *
 * @author Robert Lafore - traduzido e adaptador por aleaguado
 */
public class Fila    {
   private int maxSize;
   private long[] filaArray;
   private int comeco;
   private int fim;
   private int nItems;
//--------------------------------------------------------------
   public Fila(int s)          // método construtor
      {
      maxSize = s;
      filaArray = new long[maxSize];
      comeco = 0;
      fim = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   //OBS: EM UMA FILA CIRCULAR, NÂO NECESSARIAMENTE O PRIMEIRO ITEM DO VETOR, VAI SER O PRIMEIRO
   // ITEM DO VETOR!!!!
   
   
   public void insert(long j)   // insere um item no final da fila
      {
      if(fim == maxSize-1)         // se o fim esta no final do vetor, jogamos o 
         fim = -1;                          // fim para baixo, afinal é uma fila circular!!!  
      filaArray[++fim] = j;         // incrementa o final e insere o valor!!!
      nItems++;                     // incrementa a variavel de controle nItems
      }
//--------------------------------------------------------------
   public long remove()         // remove um item do começo da fila
      {
      long temp = filaArray[comeco++]; // retorna valor e incremente o "começo"
      if(comeco == maxSize)           // se o começo chegar no "final" do vetor, ele desce..FILA CIRCULAR
         comeco = 0;
      nItems--;                      // um item a menos
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // pega o item do começo da fila
      {
      return filaArray[comeco];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // verdadeiro se a fila estiver vazia!
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // verdadeiro se a fila estiver cheia
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // retorna o numero de itens em fila
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // fim da classe FILA
