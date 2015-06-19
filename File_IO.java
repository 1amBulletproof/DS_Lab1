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
          try
            {
                inputScanner = new Scanner(inputFile);
                printer = new PrintWriter(outputFile);

            } catch (Exception e){
                System.out.println("There was a problem with the input or output parameters, please try again");

            }
    }
    

    
    public String get_NextInput()
    {
        if (inputScanner.hasNextLine())
        {
            input = inputScanner.nextLine();
            return input;
        } else {return null;}           
    }
    
    public void write_Output(String output)
    {
        printer.println(output);
    }
   
    public void close_Output()
    {
        printer.close();
    }
    
    
}
