/**
*Test class for any stack
* 
* @author Brandon Tarney 
* @version 1.0  06/15/15
*/
public class Stack_Tester 
{
    public static void test() 
    {//Linked-list based stack
        Stack_LL_CHAR test_Stack = new Stack_LL_CHAR();         
        System.out.println("\nThese print statements are for the array-based stack");
        System.out.println(test_Stack.get_Size());
        if (test_Stack.is_Empty()) System.out.println("The Stack is empty ");//expect stack is empty
        test_Stack.push('I');
        test_Stack.push('O');
        test_Stack.push('U');
        if (test_Stack.is_Empty()) System.out.println("The Stack is empty ");//expect stack NOT empty
        System.out.println("The stack has this many items on it: " + test_Stack.get_Size());
        test_Stack.emptyStack();
        System.out.println("The stack has this many items on it: " + test_Stack.get_Size());
    }
}//end stack tester