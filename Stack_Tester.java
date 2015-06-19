/**
*Base Driver Class for two arrays
*/
public class Stack_Tester 
{
	public static void test() 
	{
		Stack_Array test_Stack = new Stack_Array(5);
		
		
		//array-based stack
                
		System.out.println("\nThese print statements are for the array-based stack");
                System.out.println(test_Stack.get_MaxSize());
		if (test_Stack.is_Empty()) System.out.println("The Stack is empty ");//expect it is empty
		test_Stack.push("I");
		test_Stack.push("Am");
		test_Stack.push("Yoda");
		if (test_Stack.is_Empty()) System.out.println("The Stack is empty ");//expect it NOT empty
		System.out.println("The stack has this many items on it: " + test_Stack.get_Size());
		System.out.println(test_Stack.display());//expect it to print 100 items
		System.out.println(test_Stack.pop() + " " + test_Stack.pop() + " "  + test_Stack.pop());//expect "Yoda Am I"
		System.out.println(test_Stack.pop());//expect an underflow error
	

		
	}
}