# DS_Lab1
WHO: Brandon Tarney's Lab 1 program. 

HOW: To run the program, enter:  java Lab1 [inputFile] [outputfile]

The source code in this assignment can be compiled with Java 1.8 from the command line.

WHAT: Checks input strings from a text file against 6 different languages to determine which 
language each string belongs to. The result is output to a new file.


 My 5th language checks for the presence of ONLY vowels, in the order/precedence 
"AEIOU". "AO", "EI", "O", "" are examples of strings which match with language 5. 
"UO", "IA", "BOON IS THE BEST" are examples of strings which DO NOT match language 5.

My 6th language checks the entire input string for a palindrome.




MORE DETAILED INFORMATION:
About this program:
The program can be executed completely from the (driver) main method of Lab1.java. 
To execute the program, run “java Lab1.class [input file] [output file]”. 
Lab1.java contains the main driver of the program, as mentioned above, 
and generally speaking uses File_IO.java to read and write to/from files, 
uses Stack_LL_CHAR.java to instantiate stacks (which itself relies upon Node_LL_CHAR.java as the node-base of the stack), 
and uses LanguageChecker.java to check each input string against 6 language criteria. 
RuntimeMetric.java is a class used to store the runtime data. 
If you see a Stack_Tester.java file, this is used to test my stack implementation, and is not required or used in the final Lab1.java program.
From a high level, the program opens an input text file, 
reads the input line by line, analyzes each line 1 at a time to see if it matches language 1-6 criteria, 
and then writes the output to a new file. 
The output text file will be identical to the input text file 
except each line will be appended with an indicator of which languages were inclusive. 
For example, input of “AB” would be output as “AB       L1  L2  L4”, 
meaning it matched languages 1, 2, and 4 but not 3, 5, and 6. 
My language criteria were as follows: 

L1 = { w: w contains equal numbers of A's and B's (in any order) and no other characters} 
L2 = {w: w is of the formAnBn, for some n >= 0}
L3 = { w: w is of the form AnB2n, for some n >= 0 }
L4 = { w: w is of the form (AnBm)p, for some m,n,p >= 0 }
L5 = { w: w contains ONLY (AEIOU) with that given precedence: A before EIOU, E before IOU but after A, etc.}
L6 = {w: w is of the form (palindrome) }(enhancement)
*All languages accept empty string