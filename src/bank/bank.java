package bank;
// demonstra a sintaxe básica da Programação Orientada a Objetos
////////////////////////////////////////////////////////////////
//BankAccount é nossa classe principal ...
class BankAccount
   {
   private double balance;                   // cria o atributo balance

   public BankAccount(double openingBalance) // construtor
      {
      balance = openingBalance;
      }

   public void deposit(double amount)        // metodo que faz deposito
      {
      balance = balance + amount;
      }

   public void withdraw(double amount)       // metodo que faz saque
      {
      balance = balance - amount;
      }

   public void display()                     // metodo que mostra balanço
      {
      System.out.println("saldo=" + balance);
      }
   }  // fim da classe bankaccount
////////////////////////////////////////////////////////////////
//Exemplo de Herança!!!
class BankManagerAccount extends BankAccount {

    public BankManagerAccount(double openingBalance) {
        super(openingBalance);
    }
    
    public void show()                     // metodo que mostra balanço
      {
        System.out.println("saldo do gerente=");
        this.display();
      }
    
}

//BankAPP é nossa classe que tem o método main e é a execução inicial de nosso programa
class BankApp
   {
   public static void main(String[] args)
      {
      BankManagerAccount ba1 = new BankManagerAccount(100.00); // cria o objeto ba1 do tipo BankAccount

      System.out.print("Antes das transações, ");
      ba1.show();                         // mostra o balanço

      ba1.deposit(74.35);                    // faz deposito
      ba1.withdraw(20.00);                   // faz saque

      System.out.print("Depois das transações, ");
      ba1.show();                         // mostra o balanço
      }  // termina o metodo main
   }  // termina a classe BankApp
