/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e8;


/**
 *
 * @author aleaguado traduzido de Robert Lafore
 */
class ListaDeNos
   {
   private No fim;            // criamos uma referencia para o primeiro nó da lista
// -------------------------------------------------------------
   public ListaDeNos()              // metodo construtor
      {
      fim = null;               // quando construido o primeiro nó fica como NULL, porque não tem nada!
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // se o primeiro (first) nó estiver como NULL
      {                             // estará vazia
      return (fim==null);
      }
// -------------------------------------------------------------                                
   public void insertFirst(String n, String p, int id)  // insere o primeiro nó
      {                           
      No newNo = new No(n, p, id);
      newNo.setAnterior(fim);       // colocamos o antigo "primeiro nó" na referência do que esta sendo inserido
      fim = newNo;            // e aí colocamos o que esta sendo inserido como o primeiro
      }
// -------------------------------------------------------------
   public No deleteFirst()      // removemos o primeiro nó
      {                           // assumimos que a lista não esta vazia!
      No temp = fim;          // o primeiro nó vai p/ variavel temporária
      fim = fim.getAnterior();         // o segundo nó se torna o novo primeiro
      return temp;                // retornarmos para classe usuária o item removido
      }
// -------------------------------------------------------------
   public No delete(String n)    // deleta um nó de determinado nome
      {                           // (assumimos que a lista não esta vazia!!!)
      No current = fim;              // a bola da vez é o first
      No previous = fim;              // e precisamos referenciar o anterior também!
      while(!current.getNome().equals(n)) //enquanto o nome da bola da vez não for o buscado
         {
         if(current.getAnterior() == null) // se chegamos no primeiro nó inserido ...
            return null;                 // retornamos null pois não encontramos
         else                            //senão ...
            {
            previous = current;          // caminhamos "um nó" pra frente ... 
            current = current.getAnterior();     // caminhamos "um nó" pra frente ...
            }
         }                               // encontramos!!!
      if(current == fim)               // se o que buscamos é o ultimo inserido
         fim = fim.getAnterior();             //   somente mudamos o first para o próximo dele
      else                               // senão
         previous.setAnterior(current.getAnterior());   //    fazemos o anterior a ele apontar para o next dele
      return current;                       
      }

// -------------------------------------------------------------
   public String displayList()
      {
      String Retorno = "Lista (primeiro-->último): ";
      No current = fim;       // começamos pelo começo da lista
      while(current != null)      // enquanto não chegarmos no item null ...
         {
         Retorno = Retorno + current.getNo();   // guarda os resultados dentro de Retorno
         current = current.getAnterior();  // movemos a lista para o proximo
         Retorno = Retorno + "\n";
      }
      return Retorno;
      }
   

   public String busca(String n){
      No current = fim;       // começamos pelo começo da lista
      while(current != null)      // enquanto não chegarmos no item null ...
         {
         if (current.getNome().equals(n)) {
             return current.getNo();
         }
            
         current = current.getAnterior();  // movemos a lista para o proximo
      }
    return "Não Encontrado";
   }
   
   public void InsertSort(String n, String p, int id) {
      No current = fim;       // começamos pelo começo da lista
      No previous = null;
      No newNo = new No(n, p, id);

      while(current != null && id > current.getIdade())
         {                            
         previous = current;
         current = current.getAnterior();       
      }
      if (previous==null) {
          fim = newNo;
          newNo.setAnterior(current); }
      else {
          newNo.setAnterior(current);
          previous.setAnterior(newNo);
      
      }
   }
   
// -------------------------------------------------------------
   }  // fim da classe Lista de Nós
//////////////////////////////////////////////////////////////