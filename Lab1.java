/**
*This is the Lab1 driver class. 
* <p> This class will implement the main function of the program.
* It will use File_IO.java to open an input text file,
* LanguageChecker.java to check each input string for l1-l6,
* It will use File_IO.java to create an output text file,
* and it will use RuntimeMetric.java to store the program runtime.
* 
* @author Brandon Tarney
* @version 1.0  6/16/15
* 




*/
import java.io.*;
import java.util.*;

public class Lab1{
   String title;
   String number;  
   static RuntimeMetric metrics;

   
   /**
    * Main program which will drive lab1.
    * <p> Grab input from the input file,
    * run each string through a language checker,
    * output the results to an output file.</p>
    * 
    * @param args   1D array of input/output files of the form args[0] = inputfile, args[1] = outputfil] 
    */
   public static void main(String [] args)
    {
        long start = System.nanoTime(); //runtime metrics variable
        long end;                       //runtime metrics variable
        String input = null;            //contains input string 1 line at a time
        String result;                  //contains matched languages for each input string
           
//            //code only to test the stack: see Stack_Tester.java
//            Stack_Tester stackTest = new Stack_Tester();
//            stackTest.test();
        
        File_IO fileIO = new File_IO(args[0], args[1]);
        //error handling in case the file is empty
        try{
            input = fileIO.get_NextInput();
        }catch (Exception e){
            System.out.println("An error occurred, please check your input file");
        }
        
        //pass each input string to a LanguageChecker class and format result
        while (input != null)
        {               
            LanguageChecker lc = new LanguageChecker(input);
            result = lc.checkLanguages();
            input=input.concat("      ");
            fileIO.write_Output(input.concat(result));
             
            input = fileIO.get_NextInput();
        } 
        
        //error handling on closing the output file
        try{
            fileIO.close_Output();
        }catch (Exception e){
            System.out.println("Could not close the output file: check your input and output file parameters");
        }
        
        //runtime metrics
        end = System.nanoTime();
        metrics = new RuntimeMetric(end - start);
        
        //report program status
        System.out.println("\nThe program ran successfully, please check your output file for the results");
        System.out.println("The Program took " + metrics.getRuntime() + " nano seconds");
    }//end of main method

}//end of lab1 class