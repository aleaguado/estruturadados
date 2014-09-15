/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e3;


/**
 *
 * @author aleaguado
 */
class EstruturaDadosE3  //Criamos aqui nossa classe EstruturaVetor
   { 
   private Dinossauro[] a;                 // cria a referência para um vetor do tipo Dinossauro
   private int nElems;               // nElems controla quantos elementos o vetor terá ...
   //-----------------------------------------------------------
   public EstruturaDadosE3(int max)         // método construtor
      {
      a = new Dinossauro[max];                 // cria o vetor ...
      nElems = 0;                        // inicialmente sem itens ...
      }

 //--------------------------------------------------------------
//Método que retorna quantidade de itens do vetor ....
//--------------------------------------------------------------
   public int size()
      { return nElems; }
 
 //--------------------------------------------------------------
//Método de pesquisa binária com String
//--------------------------------------------------------------
   public int findByName(String searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn].getNome().equals(searchKey)) //mudamos aqui para comparar nome
            return curIn;              // encontrei!
         else if(lowerBound > upperBound)
            return nElems;             // não pude encontra-lo
         else                          // divide o range
            {
             //O metodo compareTo do tipo String, retorna positivo se a primeira
             //String for maior que a segunda e negativo se for o contrário
            if(a[curIn].getNome().compareTo(searchKey) < 0) //mudamos aqui para comparar nome
               lowerBound = curIn + 1; // esta na metade de cima
            else
               upperBound = curIn - 1; // esta na metade de baixo
            }  // fim do else de divisão de range
         }  // fim do while
      }  // fim do método de pesquisa binária()  

 //--------------------------------------------------------------
//Método de pesquisa binária para imprimir valores iguais
//--------------------------------------------------------------
   public boolean findPorCor(String searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn].getCor().equals(searchKey)) { 
             //Se encontrou, ele irá rodar pra cima e pra baixo, imprimindo os valores
             for (int i = curIn; (a[i].getCor().equals(searchKey)); i++) { //mudado p/desafio
                 a[i].displayDino();//mudado p/ imprimir todos os dados da pessoa
                 System.out.println("==============================================");
                 //Se encontrar na última vamor dar um break
                 if (i == (nElems-1))
                     break;
             }
             
             //Testa se foi encontrado na posição zero, entao não anda mais pra baixo
             if (curIn ==0)
                 return true;
             
             for (int j = curIn-1; (a[j].getCor().equals(searchKey)); j--) {
                   a[j].displayDino();//mudado p/ imprimir todos os dados da pessoa
                 System.out.println("==============================================");
                                  //Se encontrar na última vamor dar um break
                 if (j == 0)
                     break;     
             }   
             return true;
         }
         else if(lowerBound > upperBound)
            return false;
         else                          // divide o range
            {
             //O metodo compareTo do tipo String, retorna positivo se a primeira
             //String for maior que a segunda e negativo se for o contrário
            if(a[curIn].getCor().compareTo(searchKey) < 0) //mudado aqui p/ desafio
               lowerBound = curIn + 1; // esta na metade de cima
            else
               upperBound = curIn - 1; // esta na metade de baixo
            }  // fim do else de divisão de range
         }  // fim do while
      }  // fim do método de pesquisa binária()     
 
 //--------------------------------------------------------------
//Método de pesquisa binária com String
//--------------------------------------------------------------
   public boolean findPorTamanho(double searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn].getTamanho() == searchKey) //mudamos aqui para comparar Tamanho
         {            //Se encontrou, ele irá rodar pra cima e pra baixo, imprimindo os valores
             for (int i = curIn; (a[i].getTamanho() == searchKey); i++) { //mudado p/exercicio
                 a[i].displayDino();//mudado p/ imprimir todos os dados da pessoa
                 System.out.println("==============================================");
                 //Se encontrar na última vamor dar um break
                 if (i == (nElems-1))
                     break;
             }
             
             //Testa se foi encontrado na posição zero, entao não anda mais pra baixo
             if (curIn ==0)
                 return true;

             for (int j = curIn-1; (a[j].getTamanho() == searchKey); j--) {
                   a[j].displayDino();//mudado p/ imprimir todos os dados do dino
                 System.out.println("==============================================");
                  //Se encontrar na última vamor dar um break
                 if (j == 0)
                     break;
             }   
         
         
            return true;        }      // encontrei!
         else if(lowerBound > upperBound)
            return false;             // não pude encontra-lo
         else                          // divide o range
            {
             //O metodo compareTo do tipo String, retorna positivo se a primeira
             //String for maior que a segunda e negativo se for o contrário
            if(a[curIn].getTamanho() < searchKey) //mudamos aqui para comparar nome
               lowerBound = curIn + 1; // esta na metade de cima
            else
               upperBound = curIn - 1; // esta na metade de baixo
            }  // fim do else de divisão de range
         }  // fim do while
      }  // fim do método de pesquisa binária()  


//--------------------------------------------------------------
//Método de inserção ORDENADA por COR!!!!!! ....
//--------------------------------------------------------------
   public void insert(String n, String c, double t)    // insere o elemento no vetor
      {
      int j;
      for(j=0; j<nElems; j++)        // localiza onde esse elemento se encaixa
          //usamos aqui o metodo compareTo para String
          if (a[j].getCor().compareTo(c) > 0) //mudado
            break;
      for(int k=nElems; k>j; k--)    // move os elementos maiores uma posição p/ frente
         a[k] = a[k-1];
      //Apos abrir um espaço no lugar certo, ele cria o nome objeto Dinossauro na posição aberta!!!
      a[j] = new Dinossauro(n, c, t);                  // insere o elemento na posição necessária
      nElems++;                      // incrementa a variavel de controle de tamanho
      }  // finaliza o método de inserção

//--------------------------------------------------------------
//Método de remoção por nome....
//--------------------------------------------------------------
  
    public boolean delete(String value)
      {
      int j = findByName(value);           //Utiliza a busca binária para remover!!!
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
         a[j].displayDino();
      }
   //-----------------------------------
   
           //--------------------------------------------------------------
   // Rotina de Ordenação pelo método de Inserção (InsertSort)
   //-----------------------------------------------------------
       public void ordenaPorTamanho()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // vamos rodar até o final do vetor
         {
         Dinossauro temp = a[out];            // jogamos em uma variável (Tamanho) temporária o item marcado
         in = out;                      // inicializamos a variavel in, que ira receber o valor a esquerda
         while(in>0 && a[in-1].getTamanho() >= temp.getTamanho()) // enquanto o item a esquerda for maior que o marcado ...
            {
            a[in] = a[in-1];            // ...nós fazemos eles pularem uma casa a direita
            --in;                       
            }                           // ... quando o item for menor, ele nao pula!
         a[in] = temp;                  // ...inserimos o valor marcado na posição que ficou "livre", ou seja,
                                        // onde estava o último item a esquerda maior que o marcado
         }  // fim do for
      }  // fim do método de ordenação   
}
   
