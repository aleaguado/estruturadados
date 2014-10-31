/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package correcaoexercicios.e7;

/**
 *
 * @author aleaguado traduzido de Robert Lafore
 */
class ListaDeNos
   {
   private No first;            // criamos uma referencia para o primeiro nó da lista
// -------------------------------------------------------------
   public ListaDeNos()              // metodo construtor
      {
      first = null;               // quando construido o primeiro nó fica como NULL, porque não tem nada!
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // se o primeiro (first) nó estiver como NULL
      {                             // estará vazia
      return (first==null);
      }
// -------------------------------------------------------------                                
   public void insertFirst(String n, String p)  // insere o primeiro nó
      {                           
      No newNo = new No(n, p);
      newNo.setNext(first);       // colocamos o antigo "primeiro nó" na referência do que esta sendo inserido
      first = newNo;            // e aí colocamos o que esta sendo inserido como o primeiro
      }
// -------------------------------------------------------------
   public No deleteFirst()      // removemos o primeiro nó
      {                           // assumimos que a lista não esta vazia!
      No temp = first;          // o primeiro nó vai p/ variavel temporária
      first = first.getNext();         // o segundo nó se torna o novo primeiro
      return temp;                // retornarmos para classe usuária o item removido
      }
// -------------------------------------------------------------

// -------------------------------------------------------------
   public String displayList()
      {
      String Retorno = "Lista (primeiro-->último): ";
      No current = first;       // começamos pelo começo da lista
      while(current != null)      // enquanto não chegarmos no item null ...
         {
         Retorno = Retorno + current.getNo();   // guarda os resultados dentro de Retorno
         current = current.getNext();  // movemos a lista para o proximo
         Retorno = Retorno + "\n";
      }
      return Retorno;
      }
   

   public String busca(String n){
      No current = first;       // começamos pelo começo da lista
      while(current != null)      // enquanto não chegarmos no item null ...
         {
         if (current.getNome().equals(n)) {
             return current.getNo();
         }
            
         current = current.getNext();  // movemos a lista para o proximo
      }
    return "Não Encontrado";
   }
   
// -------------------------------------------------------------
   }  // fim da classe Lista de Nós
//////////////////////////////////////////////////////////////