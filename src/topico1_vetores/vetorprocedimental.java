package topico1_vetores;
// vetorprocedimental.java
// demonstra a utilização de vetores em java
////////////////////////////////////////////////////////////////
class VetorApp
   {
    
   public static void main(String[] args)
      {
      long[] vet;                  // referencia para vetor
      vet = new long[100];         // cria o vetor
      int nElems = 0;              // número de itens
      int j;                       // contador dos laços
      long chaveBusca;              // chave de Busca
//--------------------------------------------------------------
//Rotina de inserção ....
//--------------------------------------------------------------
      vet[0] = 77;   // insere 10 itens
      vet[1] = 99;
      vet[2] = 44;
      vet[3] = 55;
      vet[4] = 22;
      vet[5] = 88;
      vet[6] = 11;
      vet[7] = 00;
      vet[8] = 66;
      vet[9] = 33;
      nElems = 10;   // insere a quant. de itens no vetor na variavel nElems
//--------------------------------------------------------------
//Rotina para visualizar os itens do vetor ....
//--------------------------------------------------------------
      for(j=0; j<nElems; j++)      // mostra os itens do vetor
            System.out.print(vet[j] + " ");
      System.out.println("");
//--------------------------------------------------------------
//Rotina de busca ....
//--------------------------------------------------------------
         
      
      chaveBusca = 89;              // seta a busca para achar o valor 66
      for(j=0; j<nElems; j++)          // faz o for varrer o vetor
         if(vet[j] == chaveBusca)       // compara ... encontrou?
            break;                     // ...se encontrou termina o for antes de finalizar..
      if(j == nElems)  {                // chegou ao final do vetor?
         System.out.println("Não localizei o item " + chaveBusca); }// sim
      else
         System.out.println("Encontrei o item " + chaveBusca);      // não
//--------------------------------------------------------------
//Rotina de remoção ....
//--------------------------------------------------------------
      chaveBusca = 55;              // seta a busca e remoção p/ o valor 55
      for(j=0; j<nElems; j++)           // faz o for p/ varrer o vetor
      if(vet[j] == chaveBusca)          // se encontrar o numero 55 ...
         break;                         // para a busca no ponto que encontrou
      for(int k=j; k<nElems; k++)       // e através do for, a partir do local que encontrou..
         vet[k] = vet[k+1];             // move todos itens (uma posição pra frente)
      nElems--;                         // decrementa a variavel nElems
//--------------------------------------------------------------
//Rotina de visualização ....
//--------------------------------------------------------------
      for(j=0; j<nElems; j++)      // mostra novamente os itens
         System.out.print( vet[j] + " ");
      System.out.println("");
      }  // finaliza o método main
   }  // finaliza a classe VetorApp