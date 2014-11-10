/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Este exercício implementa:
// Lista de duas extremidades;
// Lista duplamente encadeada;
// Lista ordenada;
// "Tentativa" de busca binária

package topico5.listaencadeadafim;

/**
 *
 * @author aleaguado
 */
public class ListaAvancada {
   private No primeiro;               // referencia para o primeiro nó
   private No ultimo;                // referencia para o último nó
   
    public ListaAvancada()              // metodo construtor
      {
        primeiro = null;               // Na construção o primeiro e último é null!
        ultimo = null;
      }
   
    public boolean estaVazio()          // retornará verdadeiro se o primeiro estiver vazio
      { return primeiro==null; }
    
    public void insereNaFrente(String n, String p, int id)  // insere na frente da lista
      {
        No newNo = new No(n, p, id);   // criamos o novo nó

        if( estaVazio() )  {              // se a lista estiver vazia
         ultimo = newNo;                // o ultimo passa a ser o novo
        }
        else {                          // senão 
         primeiro.setAnterior(newNo);   // colocamos o primeiro linkado ao novo
        }
        
         newNo.setProximo(primeiro);         // ao final o novo aponta para o antigo primeiro
         primeiro = newNo;               // e agora ele passa a ser o primeiro
      }
    
       public void insertNoFim(String n, String p, int id)   // insere no final da lista
      {
        No NewNo = new No(n, p, id);   // cria um novo link
        if( estaVazio() )                // se a lista estiver vazia ...
           primeiro = NewNo;            // o primeiro aponta para o novo nó
        else                            // Senão ...
           {
              ultimo.setProximo(NewNo);        // o proximo do ultimo linka no novo ...
              NewNo.setAnterior(ultimo);    // o anterior do novo para a ser o último
           }

          ultimo = NewNo;                // ao final, o novo passa a ser o ultimo
      }
       
      public String InsereOrdenado(String n, String p, int id) {
            No bolaDaVez = primeiro;
            No newNo = new No(n, p, id);
            
            if( estaVazio() )    {            // se a lista estiver vazia ...
                this.insereNaFrente(n, p, id);
                return "Inserido Primeiro Item";
            }
            
            //A ordenação será Primeiro > menor ... Último > Maior
            // Entao se for para inserir em uma ponta...
            if (id <= primeiro.getIdade() ) {
                this.insereNaFrente(n, p, id);
                return "Inserido com sucesso no começo da lista!";
            } 
            
             if (id >= ultimo.getIdade() ){
                this.insertNoFim(n, p, id);
                return "Inserido com sucesso no final da lista";
            }

            while(id > bolaDaVez.getIdade())
               {                            
               bolaDaVez = bolaDaVez.getProximo();
               }
                bolaDaVez.getAnterior().setProximo(newNo);
                newNo.setAnterior(bolaDaVez.getAnterior());
                newNo.setProximo(bolaDaVez);              
                bolaDaVez.setAnterior(newNo);                
                return "Inserido entre itens com sucesso";
   }

        public No removePrimeiro()         // remove o primeiro nó
      {                              // assume a lista como não vazia
            No temp = primeiro;
            if(primeiro.getProximo() == null)         // se só tiver um item na lista ...
               ultimo = null;                // é só colocar o último como null ...
            else                             // ou ...
               primeiro.getProximo().setAnterior(null); // remover o link para mim mesmo ...
            primeiro = primeiro.getProximo();            // o primeiro passa a ser o proximo
            return temp;                                  // retornamos para o usuario o nó removido
      }
    
        public No removeUltimo()         // remove o ultimo nó
      {                              // assume a lista como não vazia
            No temp = ultimo;
            if(primeiro.getProximo() == null)         // se só tiver um item na lista ...
               primeiro = null;                // é só colocar o primeiro como null ...
            else                             // ou ...
               ultimo.getAnterior().setProximo(null); // remover o link para mim mesmo ...
            ultimo = ultimo.getAnterior();            // o primeiro passa a ser o anterior
            return temp;                                  // retornamos para o usuario o nó removido
      }
    
        public String ListaDeFrentePraTras()
      {
            String Retorno = "Lista (primeiro-->último): ";
            No bolaDaVez = primeiro;       // começamos pelo começo da lista
            while(bolaDaVez != null)      // enquanto não chegarmos no item null ...
               {
               Retorno = Retorno + bolaDaVez.getNo();   // guarda os resultados dentro de Retorno
               bolaDaVez = bolaDaVez.getProximo();  // movemos a lista para o proximo
               Retorno = Retorno + "\n";
            }
            return Retorno;
      }  
        
        public String ListaDeTrazPraFrente()
      {
            String Retorno = "Lista (último-->primeiro): ";
            No bolaDaVez = ultimo;       // começamos pelo começo da lista
            while(bolaDaVez != null)      // enquanto não chegarmos no item null ...
               {
               Retorno = Retorno + bolaDaVez.getNo();   // guarda os resultados dentro de Retorno
               bolaDaVez = bolaDaVez.getAnterior();  // movemos a lista para o anterior
               Retorno = Retorno + "\n";
            }
            return Retorno;
      }
        
        
        public No removeEspecifico(String n)    // deleta um nó de determinado nome
        {                           // (assumimos que a lista não esta vazia!!!)
            No bolaDaVez = primeiro;              // a bola da vez é o primeiro

            while(!bolaDaVez.getNome().equals(n)) //enquanto o nome da bola da vez não for o buscado
               {
                    bolaDaVez = bolaDaVez.getProximo(); //fazemos girar a lista
                    if(bolaDaVez == null) // se chegamos no primeiro nó inserido ...
                    return null;                 // retornamos null pois não encontramos
               } 
 
            if(bolaDaVez == primeiro)               // se o que buscamos é o primeiro item
               primeiro = bolaDaVez.getProximo();             //   o primeiro passa a ser o próximo
            else                               // senão
               bolaDaVez.getAnterior().setProximo(bolaDaVez.getProximo());   //    fazemos o anterior a ele apontar para o next dele
                  
            
            if (bolaDaVez == ultimo)            // se o que buscamos é o ultimo item
                ultimo = bolaDaVez.getAnterior();
            else
                bolaDaVez.getProximo().setAnterior(bolaDaVez.getAnterior());
            
            return bolaDaVez;      
       }
        
        public String buscaEspecifico(String n)    // busca um item específico
        {                           // (assumimos que a lista não esta vazia!!!)
            No bolaDaVez = primeiro;              // a bola da vez é o primeiro

            while(!bolaDaVez.getNome().equals(n)) //enquanto o nome da bola da vez não for o buscado
               {
                    bolaDaVez = bolaDaVez.getProximo(); //fazemos girar a lista
                    if(bolaDaVez == null) // se chegamos no primeiro nó inserido ...
                    return "Não Encontrado";                 // retornamos null pois não encontramos
               } 
            return bolaDaVez.getNo();      
       } 
        
        
        
        
    
   
}
