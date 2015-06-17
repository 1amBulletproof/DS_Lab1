import java.io.*;
import java.util.*;


/**
 * Customized version of Greeting class which was written by Johns Hopkins University 
 * customized by brandon tarney
 * 
 * A sample data class used to demonstrate Java file I/O.  The class includes 
 * an int, String and double value and demonstrates how each of these is read 
 * from and written to a file and to standard output.   Javadoc tags document 
 * the class and functions.
 *
 * @ author CS210
 * @version 1.0, September 1, 2000
 *
 */
class Greeting {
   
   // Class attributes   

   private String saying;

      
   
   /**  Parameterized  constructor  
    * @param int index - the index of the Greeting object
    * @param String words - the text of the Greeting object
    * @param double data - number assigned to value in the Greeting object
    */
   public Greeting(String words,) {
      saying = words; 
   }
   
   /**  Default  constructor    
    */
   public Greeting () {
      saying = "";

  }

   
   /**  Write the data in the class to a file.   
    * @param PrintWriter output - file text writer 
    */
   public void writeData(PrintWriter output) 
         throws IOException
   {
      output.println(count + "\t" + saying + "\t" + value);
   }
   
   /**  Read the data into the class from a file   
    * @param BufferedReader input - file text reader
    */
   public void readData(BufferedReader input) 
         throws IOException
   {
      String words = input.readLine();
      StringTokenizer t = new StringTokenizer(words, "\t");
      count = Integer.parseInt(t.nextToken());
      saying = t.nextToken();
      value = Double.parseDouble(t.nextToken());
   }

}
