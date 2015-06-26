

/**
 *The purpose of this class is to check input strings 
 * against preset language definitions to see 
 * which strings belong to which languages
 * @author Tarney
 */
public class LanguageChecker {
    public Stack_LL_CHAR stack1;
    public Stack_LL_CHAR stackA;
    public Stack_LL_CHAR stackB;
    String resultString = new String();
    String inputString;
    boolean l1,l2,l3,l4,l5; //flags for whether the string conforms to a language
    
   /**
    * Class Constructor: instantiates several stacks and the input string
    * @param input String that is going to be parsed
    */
    public LanguageChecker(String input)
    {
        stack1 = new Stack_LL_CHAR();
        stackA = new Stack_LL_CHAR();
        stackB = new Stack_LL_CHAR();
        inputString = input;
//        stringToStack(inputString);  
    }
    
//    /**
//     * Converts a String to a Stack data type
//     * @param input String to be converted to a stack
//     */
//    private void stringToStack(String input)
//    {
//        try{
//            for (int i = 0; i < input.length(); i++){stack1.push(input.charAt(i));}
//        }  catch (Exception e) {} //accomodates an empty line scenario     
//    }

    /**
     * Pop stackA and StackB until at least 1 is empty 
     * to see if they are equal in size
     * note that each stack will be emptied
     * @return  boolean return whether each stack is of the same size  
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
    
    public String checkLanguages()
    {
        //check input string against all languages & set flags accordingly
        checkLanguage1();
        checkLanguage2();
        checkLanguage3();
        checkLanguage4();
        checkLanguage5();
        //create output string based on language flags
        setResultString();
        return resultString;
    }
    

    /**
     * Checks an input stack for conformity with #A=#B in any order, 
     * but there must be no other characters
     */
    private void checkLanguage1()
    {
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
     * Sets l2 TRUE if the string matches Language 2
     * Sets l2 FALSE if the string doesn't match Language 2
     */
    private void checkLanguage2()
    {

        char temp;
        boolean abFlag = true; //true when input string is null, A, or B
        boolean bFlag = false; //true when a 'B' is received in input
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
     */
    private void checkLanguage3()
    {
        
        
    }
    
    /**
     * Checks an input string for (A^nB^m)P n,m,p >= 0 
     */
    private void checkLanguage4()
    {
        
        
    }
    
    /**
     * Checks an input string for the palindrome quality
     */
    private void checkLanguage5()
    {
        
        
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
    }
}// end class LanguageChecker

