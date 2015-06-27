/**
Date: 06/15/2015
@author Brandon Tarney



Implementation goals:
1. Use GIT to version the project (command line, github app, and netbeans integration)
2. Use Sublime Text & Netbeans extensively to familiarize with both

7. Use runtime metrics
8. Use good error & exception handling
9. Use Javadoc (built in java documenting tool?)


*/
import java.io.*;
import java.util.*;

public class Lab1{
   String title;
   String number;  
   static RuntimeMetric metrics;

	public static void main(String [] args)
        {
            long start = System.nanoTime();
            long end;
            String input;  //contains input string 1 line at a time
            String result; //contains matched languages for each input string
           
//            //code only to test the stack: see Stack_Tester.java
//            Stack_Tester stackTest = new Stack_Tester();
//            stackTest.test();

            File_IO fileIO = new File_IO(args[0], args[1]);
            input = fileIO.get_NextInput();
            while (input != null)
            {
//                System.out.println(input);
                
                LanguageChecker lc = new LanguageChecker(input);
                result = lc.checkLanguages();
                input=input.concat("      ");
                fileIO.write_Output(input.concat(result));
             
                input = fileIO.get_NextInput();
            }
            
            fileIO.close_Output();
            end = System.nanoTime();
            metrics = new RuntimeMetric(end - start);
            System.out.println("\nThe program ran successfully, please check your output file for the results");
            System.out.println("The Program took " + metrics.getRuntime() + " nano seconds");


	}//end of main method

}//end of lab1