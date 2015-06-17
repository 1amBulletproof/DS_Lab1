/**
*Base Driver Class for two arrays
*/
public class Stack_Array_Driver 
{
	public static void main(String[] args) 
	{
		Stack_Array test_Stack = new Stack_Array();
		Stack_LL test_Stack2 = new Stack_LL();
		
		//array-based stack
		System.out.println("\nThese print statements are for the array-based stack");
		if (test_Stack.is_Empty()) System.out.println("The Stack is empty ");//expect it is empty
		test_Stack.push("I");
		test_Stack.push("Am");
		test_Stack.push("Yoda");
		if (test_Stack.is_Empty()) System.out.println("The Stack is empty ");//expect it NOT empty
		System.out.println("The stack has this many items on it: " + test_Stack.get_Size());
		System.out.println(test_Stack.display());//expect it to print 100 items
		System.out.println(test_Stack.pop() + " " + test_Stack.pop() + " "  + test_Stack.pop());//expect "Yoda Am I"
		System.out.println(test_Stack.pop());//expect an underflow error
		
		//linked-list based stack
		System.out.println("\nThese print statements are for the Linked-List-based stack");
		if (test_Stack2.is_Empty()) System.out.println("The Stack is empty ");//expect it is empty
		test_Stack2.push("I");
		test_Stack2.push("Am");
		test_Stack2.push("Yoda");
		if (test_Stack2.is_Empty()) System.out.println("The Stack is empty ");//expect it NOT empty
		System.out.println("The Stack has this many items on it: " + test_Stack2.get_Size());
		System.out.println(test_Stack2.display());//expect it to print all the data items
		System.out.println(test_Stack2.pop() + " " + test_Stack2.pop() + " "  + test_Stack2.pop());//expect "Yoda Am I"
		System.out.println(test_Stack2.pop());//expect an underflow error

		
	}
}