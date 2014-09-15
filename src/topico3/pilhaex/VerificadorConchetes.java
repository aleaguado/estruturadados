/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topico3.pilhaex;

/**
 *
 * @author aleaguado
 */
class VerificadorConchetes
   {
   private String input;                   // input vai guardar a string que virá da classe usuária
//--------------------------------------------------------------
   public VerificadorConchetes(String in)        // nosso método construtor
      { input = in; }                           //guarda em input o que vem via parametro da classe usuária
//--------------------------------------------------------------
   public void check()
      {
      int tamanhoPilha = input.length();      // pega o tamanho maximo da pilha, que será a qty de caracteres da entrada
      PilhaX aPilha = new PilhaX(tamanhoPilha);  // cria objeto pilha com tamanho da expressão

      for(int j=0; j<input.length(); j++)  // esse for girará para cada caracterer!!!
         {
         char ch = input.charAt(j);        // a variavel ch guarda o "caracter da rodada"
         switch(ch)                         
            {
            case '{':                      // caso o caracter for um dos delimitadores de abertura ...
            case '[':
            case '(':
               aPilha.inserir(ch);          // ...nós inserimos ele na pilha!!!
               break;

            case '}':                      // ...caso o caracter for um dos delimitadores de fechamento
            case ']':
            case ')':
               if( !aPilha.estaVazio() )   // ...nós checamos se a pilha não esta vazia...caso não esteja ...
                  {
                  char chx = aPilha.remove();  // jogamos para chx o top da fila (e removemos ele)
                  if( (ch=='}' && chx!='{') ||  // se o caracter da vez fecha chave e o ultimo tirado da pilha nao abre, ou
                      (ch==']' && chx!='[') ||  // se o caracter da vez fecha conchete e o ultimo tirado da pilha nao abre, ou
                      (ch==')' && chx!='(') )   // se o caracter da vez fecha parenteses e o ultimo tirado da pilha nao abre ...
                     System.out.println("Erro: "+ch+" em "+j);     // Imprimimos mensagem de erro!!!
                  }
               else                        // se a pilha estiver vazia
                  System.out.println("Err: "+ch+" em "+j); //Imprimimos erro ... porque tem um delimitador fechando, sem nenhum sequer ter aberto!
               break;
            default:    // para os outros caracteres, ignoramos!!!
               break;
            }  // fim do switch
         }  // fim do for
      // opa! Aqui todos caracteres ja foram processados!!!
      if( !aPilha.estaVazio() ) //se ao final sobrou coisa aberta na pilha, é porque delimitador não foi fechado!
         System.out.println("Erro: delimitador do lado direito perdido!!!");
      }  // fim check()
//--------------------------------------------------------------
   }  // fim da classe