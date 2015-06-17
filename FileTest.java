import java.io.*;
import java.util.*;

/**
 * Customized version of IOExample.java which was written by Johns Hopkins University 
 * customized by brandon tarney
*
 * A class that writes data to, and reads data from, a file.  To be used as a 
 * template to demonstrate the use of Java File I/O.  Javadoc tags document 
 * the class and functions.
 *
 * @ author CS210
 * @version 1.0, September 1, 2000
 *
 * Usage: java FileTest
 *
 */
public class FileTest  { 

   String title;
   String number;     
         
   /**
    *   Write data to a file  
    * @param Greeting[] script - an array of Greeting objects
    * @param PrintWriter output
    */
   static void writeData(Greeting[] script, PrintWriter output)
         throws IOException
   {
      output.println(script.length);
      int index;
      for (index=0; index<script.length; index++) {
         script[index].writeData(output);
      }
   }
   
   /**   Read data from a file.      
    * @param BufferedReader input
    * @return Greeting[] - the array of Greeting objects
    */
   static Greeting[] readData(BufferedReader input)
         throws IOException
   {
      int count = Integer.parseInt(input.readLine());
      Greeting[] script = new Greeting[count];
      int index;
      for (index=0; index<count; index++) {
         script[index] = new Greeting();
         script[index].readData(input);
      }
      return script;
   }
   
   /**   main    
    * @param String[] args - input arguments - none needed
    */
   public static void main(String[] args) {
     final int GREETING_COUNT = 3;
      Greeting[] script = new Greeting[GREETING_COUNT];
      script[0] = new Greeting(1, "Hello, World!", 10.0);
      script[1] = new Greeting(2, "Be well!   ", 15.0);
      script[2] = new Greeting(3, "Be happy!", 20.0);
      
      int index;
      for (index=0; index<script.length; index++) {
         script[index].decreaseCounter(1);
         script[index].increaseValue(5.0);
      }
      
      // File output is  encapsulated in try statement. 
      try {
         PrintWriter output = new PrintWriter(new 
            FileWriter("script.dat"));
         writeData(script, output);
         output.close();
      } catch(IOException exception) {
         System.out.print("Error: " + exception);
         System.exit(1);
      }
      
      // File input is encapsulated in try statement. 
      try {
         BufferedReader input = new BufferedReader(new
            FileReader("script.dat"));
         script = readData(input);
         for (index=0; index<script.length; index++) {
            script[index].print();
         }
         input.close();         
      } catch (IOException exception) {
         System.out.print("Error: " + exception);
         System.exit(1);
      }
   }
    
}