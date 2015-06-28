

/**
 *The purpose of this class is to check input strings 
 * against preset language definitions (6 total) to see 
 * which strings belong to which languages
 * 
 * @author Tarney
 * @version 1.0 2015-26-15
 */
public class LanguageChecker {
    public Stack_LL_CHAR stack1; //direct translation of input string
    private Stack_LL_CHAR stackA; //reference stack used to store 'A's
    private Stack_LL_CHAR stackB; //reference stack used to store 'B's
    String resultString = new String(); //final output string which shows which langauges conform
    String inputString; //string passed into the class to check against l1-l6
    boolean l1,l2,l3,l4,l5,l6; //flags for whether the string conforms to a language
    enum Vowels {A, E, I, O, U};//used for vowel priority

    
   /**
    * Class Constructor: instantiates several stacks and the input string
    * 
    * @param input String that is going to be parsed
    */
    public LanguageChecker(String input)
    {
        stack1 = new Stack_LL_CHAR();
        stackA = new Stack_LL_CHAR();
        stackB = new Stack_LL_CHAR();
        inputString = input;
        stringToStack(inputString);  
    }
    
    
    /**
     * Converts a String to a Stack data type
     * 
     * @param input String from which to create a stack
     */
    private void stringToStack(String input)
    {
        try{
            for (int i = 0; i < input.length(); i++){stack1.push(input.charAt(i));}
        }  catch (Exception e) {} //accomodates an empty line scenario     
    }

    
    /**
     * Pop stackA and StackB until at least 1 is empty 
     * to see if they are equal in size
     * note that each stack will be emptied
     * 
     * @return      boolean return whether each stack is of the same size  
     */
    private boolean popCompare()
    {
        while (!stackA.is_Empty() && !stackB.is_Empty())
        {
            stackA.pop();
            stackB.pop();
        }
        return (stackA.is_Empty() && stackB.is_Empty());   
    }
    
    
    /**
     * Pop StackA once and StackB twice until at least 1 is empty
     * to see if they are equal in size
     * note that each stack will be emptied
     * 
     * @return      return whether each stack conforms to L3
     */
    private boolean popB2Compare()
    {
        boolean passFlag = true;
        {
            while (!stackA.is_Empty() && !stackB.is_Empty())
            {
             stackA.pop();
             stackB.pop();
             if (stackB.is_Empty()){passFlag = false;}//account for odd case, i.e. 2 A's & 3 B's
             stackB.pop();
            }
            if (passFlag){return (stackA.is_Empty() && stackB.is_Empty());}
            else{return false;}
        }       
    }
    
    
    /**
     * Compare 2 reference stacks based on the size of stackA & stackB
     * 
     * @return      boolean return whether each stack conforms to L4
     */
    private boolean popNMCompare(Stack_LL_CHAR refA, Stack_LL_CHAR refB)
    { 
        if (refA.get_Size() == stackA.get_Size() && refB.get_Size() == stackB.get_Size())
        {
            refA.emptyStack();
            refB.emptyStack();
            return true;
        }
        else {return false;}
    }
    
    
    /**
     * Sets the vowel Enum property based on character input
     * 
     * @param input character passed to function to check against vowel enum
     * @return      vowel enum matching the character input
     */
    private Vowels setEnum(char input)
    {
        Vowels temp = Vowels.A;
        switch (input) 
            {
                case 'A': temp =  Vowels.A;
                    break;
                    
                case 'E': temp =  Vowels.E;
                    break;
                       
                case 'I': temp =  Vowels.I;
                    break;
                    
                case 'O': temp =  Vowels.O;
                    break;
                     
                case 'U': temp =  Vowels.U;
                    break;       
            }
        return temp;
    }
    
    
    /**
     * Check all 5 languages against the input string for the class
     * 
     * @return      string result of language checks 
     */
    public String checkLanguages()
    {
        //check input string against all languages & set flags accordingly
        checkLanguage1();
        checkLanguage2();
        checkLanguage3();
        checkLanguage4();
        checkLanguage5();
        checkLanguage6();
        //create output string based on language flags
        setResultString();
        return resultString;
    }
    

    /**
     * Checks an input stack for conformity with #A=#B in any order, 
     * <p>Sets l2 TRUE if the string matches Language 2
     * Sets l2 FALSE if the string doesn't match Language 2</p>
     */
    private void checkLanguage1()
    {
        stackA.emptyStack();
        stackB.emptyStack();
        char temp;
        boolean abFlag = true; //true when input string is null, A, or B
        for (int i = 0; i < inputString.length(); i++)
        {
            temp = inputString.charAt(i);
            if (temp == 'A') {stackA.push(temp);} 
            else if (temp == 'B') {stackB.push(temp);} 
//            else if (temp == ' ')
            else {abFlag = false;}
        }
        if (abFlag)//confirm there were no letters other than 'A' or 'B' or empty string
        {
            if (popCompare()) {l1 = true;}
        }
    }
    
    
    /**
     * Checks an input string for A^nB^n n >= 0 
     * <p>Sets l2 TRUE if the string matches Language 2
     * Sets l2 FALSE if the string doesn't match Language 2</p>
     */
    private void checkLanguage2()
    {
        stackA.emptyStack();
        stackB.emptyStack();
        char temp;
        boolean abFlag = true; //true when input string is null, A, or B
        boolean bFlag = false; //true when after a 'B' is received in input
        for (int i = 0; i < inputString.length(); i++)
        {
            temp = inputString.charAt(i);
            if (temp == 'A' && !bFlag) {stackA.push(temp);} 
            else if (temp == 'B') 
            {
                stackB.push(temp);
                bFlag = true;
            } 
            else {abFlag = false;}
        }
        if (abFlag)//confirm there were no letters other than 'A' or 'B' or empty string
        {
            if (popCompare()) {l2 = true;}
        }      
    }
    

    /**
     * Checks an input string for A^nB^2n n >= 0 
     * <p>Sets l3 TRUE if the string matches Language 3
     * Sets l3 FALSE if the string doesn't match Language 3</p>
     */
    private void checkLanguage3()
    {
        stackA.emptyStack();
        stackB.emptyStack();
        char temp;
        boolean abFlag = true; //true when input string is null, A, or B
        boolean bFlag = false; //true when after a 'B' is received in input
        for (int i = 0; i < inputString.length(); i++)
        {
            temp = inputString.charAt(i);
            if (temp == 'A' && !bFlag) {stackA.push(temp);} 
            else if (temp == 'B') 
            {
                stackB.push(temp);
                bFlag = true;
            } 
            else {abFlag = false;}
        }
        if (abFlag)//confirm there were no letters other than 'A' or 'B' or empty string
        {
            if (popB2Compare()) {l3 = true;}
        }        
    }
    
    
    /**
     * Checks an input string for (A^nB^m)P n,m,p >= 0 
     * <p>Sets l4 TRUE if the string matches Language 4
     * Sets l4 FALSE if the string doesn't match Language 4</p>
     */
    private void checkLanguage4()
    {
        boolean templ4 = true;
        stackA.emptyStack();
        stackB.emptyStack();
        Stack_LL_CHAR stackRefA = new Stack_LL_CHAR();
        Stack_LL_CHAR stackRefB = new Stack_LL_CHAR();
        char temp;
        boolean abFlag = true; //true when input string is null, A, or B
        boolean bFlag = false; //true when after a 'B' is received in input
        boolean refStackFlag = false; //true when reference stack complete
        
        for (int i = 0; i < inputString.length(); i++)
        {
            temp = inputString.charAt(i);
            if (temp == 'A' && !bFlag && !refStackFlag) {stackA.push(temp);}//first set of A's
            else if (temp == 'B' && !refStackFlag) //first set of B's
            {
                stackB.push(temp);
                bFlag = true;
            } 
            else if (temp == 'A' && bFlag && !refStackFlag) //pattern determined
            {                
                stackRefA.push(temp);
                bFlag = false;
                refStackFlag = true;//transition to ref. stacks
            }
            else if (temp == 'A' && !bFlag && refStackFlag) {stackRefA.push(temp);} 
            else if (temp == 'B' && refStackFlag) 
            {
                stackRefB.push(temp);
                bFlag = true;
            } 
            else if (temp == 'A' && bFlag && refStackFlag)
            {
                //compare stackRefA to stackA & compare stackRefB to stackB
                templ4 = templ4 && popNMCompare(stackRefA, stackRefB); //if ever a false value returned, false forever
                stackRefA.push(temp);
                bFlag = false;
            }
            else {abFlag = false;} //there is string input, but the string doesn't start with an A
        }
        if (abFlag)//confirm there were no letters other than 'A' or 'B' or empty string
        {
            if (stackRefA.is_Empty() && stackRefB.is_Empty()) {l4 = true;}//Essentially P = 1 or empty string
            else{l4 = templ4 && popNMCompare(stackRefA, stackRefB);}
        }  
    }
    
    
    /**
     * Checks input string for language 5 parameters: 
     * <p>only upper-case vowels are present and are in the order "AEIOU"
     * for example, "AI", "IOU", "AIOU", etc are contained in language 5
     * for example, "IA", "OUIEA", "IO", etc are NOT contained in language 5
     * IN KEEPING WITH THE THEME, AN EMPTY STRING WILL QUALIFY AS CORRECT FOR THIS LANGUAGE
     * Sets l5 TRUE if the string matches language 5
     * Sets l5 FALSE if the string doesn't match Language 5</p>
     */
    private void checkLanguage5()
    {
       Vowels inputChar;
       Vowels nextInputChar;
       char temp;
       char nextTemp;
       boolean invalidInput = false; //invalid input if (true) if non-vowel input or vowels out of order
       
        while (!stack1.is_Empty() && !invalidInput)
        {
            temp = stack1.pop();
           
            if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U')
            {
                inputChar = setEnum(temp);  
           
                if (!stack1.is_Empty())
                {//because you are moving backwards through the string, the next stack item should be less in enum value
                    nextTemp = stack1.peek();
                    nextInputChar = setEnum(nextTemp);
                    invalidInput = (nextInputChar.ordinal() > inputChar.ordinal());
                }
                
            }
            else { invalidInput = true;}
                    
        }
        l5 = !invalidInput; 
    }
          
    
    /**
     * Checks an input string for the palindrome quality
     * <p>IN KEEPING WITH THE THEME, AN EMPTY STRING WILL QUALIFY AS CORRECT FOR THIS LANGUAGE
     * ALSO, SINGLE SYMBOLS WILL QUALIFY AS WELL: THEY TECHNICALLY ARE THE SAME BACKWARDS AND FORWARDS
     * for example, "ANA", "KAYAK", "NO LEMON NO MELON", etc are contained in language 6
     * for example, "", "I HATE THIS CLASS", "JK, I LIKE IT", etc are NOT contained in language 6
     * Sets l5 TRUE if the string matches language 6
     * Sets l5 FALSE if the string doesn't match Language 6</p>
     */
    private void checkLanguage6()
    {
        stack1.emptyStack(); //clear the stack for use and fill it again
        stringToStack(inputString); //reset the input stack
        char temp,stackTemp;
        boolean palindromeFlag = true;
        for (int i = 0; i < inputString.length(); i++)
        {
            temp = inputString.charAt(i);
            stackTemp = stack1.pop();
            if (temp != stackTemp) {palindromeFlag = false;}
        }
        l6 = palindromeFlag;           
    }
    
    
    /**
     * Creates an output string based on the 
     * language comparison results
     */
    private void setResultString()
    {
        if (l1 == true) {resultString += " L1 ";}
        if (l2 == true) {resultString += " L2 ";}
        if (l3 == true) {resultString += " L3 ";}
        if (l4 == true) {resultString += " L4 ";}
        if (l5 == true) {resultString += " L5 ";}
        if (l6 == true) {resultString += " L6 ";}
    }
    
    
}// end class LanguageChecker

