

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
    boolean l1,l2,l3,l4,l5; //flags for whether the string is in a language
    
    public LanguageChecker(String input)
    {
        stack1 = new Stack_LL_CHAR();
        stackA = new Stack_LL_CHAR();
        stackB = new Stack_LL_CHAR();
        inputString = input;

        
    }
    

    
    
    public String checkLanguages()
    {

        
        checkLanguage1();
        checkLanguage2();
        checkLanguage3();
        checkLanguage4();
        checkLanguage5();
        
        setResultString();
        
        return resultString;
    }
    
    private void divideAB()
    {

    }
    
    /**
     * Checks an input stack for conformity with 
     */
    private void checkLanguage1()
    {
        char temp;
        for (int i = 0; i < inputString.length(); i++)
        {
            temp = inputString.charAt(i);
            if (temp == 'A') {stackA.push(temp);} 
            else if (temp == 'B') {stackB.push(temp);}  
        }
        
        if (stackA.get_Size() != 0)
        {
            if (stackA.get_Size() == stackB.get_Size()) {l1 = true;}
        }
        
    }
    
    private boolean is_SameSize(Stack_LL_CHAR stackA, Stack_LL_CHAR stackB)
    {
//        while (!stackA.is_Empty() && !stackB.is_Empty())
//        {
//            stackA.pop();
//            stackB.pop();
//        }
        if (stackA.get_Size() == stackB.get_Size()){return true;}
        else {return false;}
               
    }
    
    private void checkLanguage2()
    {
        
        
    }
        
    private void checkLanguage3()
    {
        
        
    }
    
    private void checkLanguage4()
    {
        
        
    }
    
    private void checkLanguage5()
    {
        
        
    }
    
    private void setResultString()
    {
        if (l1 == true) {resultString += " L1 ";}
        if (l2 == true) {resultString += " L2 ";}
        if (l3 == true) {resultString += " L3 ";}
        if (l4 == true) {resultString += " L4 ";}
        if (l5 == true) {resultString += " L5 ";}
    }
}

