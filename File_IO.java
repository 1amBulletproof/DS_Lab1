/**
 * Provides data structure and methods for String File input & output
 * @author Brandon Tarney
 * @version 1.0
 * 
 * 
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Tarney
 */
public class File_IO {
    
    private String input = new String();
    private String output = new String();
    private File inputFile;
    private File outputFile;
    private Scanner inputScanner;
    private PrintWriter printer;
    
    public File_IO(String file_in, String file_out)
    {
         //test i/o
          inputFile = new File(file_in);
          outputFile = new File(file_out);      
    }
    

    
    public String get_NextInput()
    {
            try
            {
                inputScanner = new Scanner(inputFile);
                if (inputScanner.hasNext())
                {
                    input = inputScanner.next();
                    return input;
                }else{
                    return "There is no more input";
                }
                

                
            } catch (Exception e){
                System.out.println("There was no input file you suggested, please try again");
                return null;
            }
    }
    
    public void write_Output(String output)
    {
            try
            {
                printer = new PrintWriter(outputFile);
                printer.println(output);
                
            } catch (Exception e){
                System.out.println("There was no output file you suggested, please try again");
                
            }
                            
     
    }
   
    public void close_Output()
    {
        printer.close();
    }
    
    
}
