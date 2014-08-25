package topico1_vetores;
// classDataArray.java
// data items as class objects
// to run this program: C>java ClassDataApp
////////////////////////////////////////////////////////////////
class Pessoa
   { 
   private String lastName;
   private String firstName;
   private int age;
//--------------------------------------------------------------
   public Pessoa(String last, String first, int a)
      {                               // comentario aqui
      lastName = last;
      firstName = first;
      age = a;
      }
//--------------------------------------------------------------
   public void displayPessoa()
      {
      System.out.print("   Last name: " + lastName);
      System.out.print(", First name: " + firstName);
      System.out.println(", Age: " + age);
      }
//--------------------------------------------------------------
   public String getSobrenome()           // comentario aqui
      { return lastName; }
   }  // end class Person
////////////////////////////////////////////////////////////////
class EstruturaDadosOb
   {
   private Pessoa[] a;               // comentario aqui
   private int nElems;               /// comentario aqui

   public EstruturaDadosOb(int max)    // comentario aqui
      {
      a = new Pessoa[max];               // comentario aqui
      nElems = 0;                        // comentario aqui
      }
//--------------------------------------------------------------
   public Pessoa find(String searchName)
      {                              // comentario aqui
      int j;
      for(j=0; j<nElems; j++)            // comentario aqui
         if( a[j].getSobrenome().equals(searchName) )  // comentario aqui
            break;                       // comentario aqui
      if(j == nElems)                    // comentario aqui
         return null;                    // comentario aqui
      else
         return a[j];                    // comentario aqui
      }  // end find()
//--------------------------------------------------------------                                    // put person into array
   public void insert(String last, String first, int age)
      {
      a[nElems] = new Pessoa(last, first, age);
      nElems++;                          // comentario aqui
      }
//--------------------------------------------------------------
   public boolean delete(String searchName)
      {                              // comentario aqui
      int j;
      for(j=0; j<nElems; j++)            // comentario aqui
         if( a[j].getSobrenome().equals(searchName) )
            break;
      if(j==nElems)                     // comentario aqui
         return false;
      else                               // comentario aqui
         {
         for(int k=j; k<nElems; k++)    // comentario aqui
            a[k] = a[k+1];
         nElems--;                       // comentario aqui
         return true;
         }
      }  // end delete()
//--------------------------------------------------------------
   public void displayA()            // comentario aqui
      {
      for(int j=0; j<nElems; j++)       // comentario aqui
         a[j].displayPessoa();// comentario aqui
      }
//--------------------------------------------------------------
   }  // end class ClassDataArray
////////////////////////////////////////////////////////////////
class ClassDataApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // comentario aqui
      EstruturaDadosOb arr;            // comentario aqui
      arr = new EstruturaDadosOb(maxSize);  // comentario aqui
                                     // comentario aqui
      arr.insert("Evans", "Patty", 24);
      arr.insert("Smith", "Lorraine", 37);
      arr.insert("Yee", "Tom", 43);
      arr.insert("Adams", "Henry", 63);
      arr.insert("Hashimoto", "Sato", 21);
      arr.insert("Stimson", "Henry", 29);
      arr.insert("Velasquez", "Jose", 72);
      arr.insert("Lamarque", "Henry", 54);
      arr.insert("Vang", "Minh", 22);
      arr.insert("Creswell", "Lucinda", 18);

      arr.displayA();                // comentario aqui

      String searchKey = "Stimson";  // comentario aqui
      Person found;
      found=arr.find(searchKey);
      if(found != null)
         {
         System.out.print("Found ");
         found.displayPerson();
         }
      else
         System.out.println("Can't find " + searchKey);

      System.out.println("Deleting Smith, Yee, and Creswell");
      arr.delete("Smith");          // comentario aqui
      arr.delete("Yee");
      arr.delete("Creswell");

      arr.displayA();                // comentario aqui
      }  // end main()
   }  // end class ClassDataApp
