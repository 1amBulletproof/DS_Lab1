/**
*Linked-List-Based Stack ADT NOT WORKING AT THE MOMENT
*/
import java.util.Arrays;				//use for the display method

public class Stack_LL_CHAR 
{
	private Node_LL_CHAR top;				// points to the ADT which is at the top of the stack
	private Node_LL_CHAR temp_top;				// for manipulating data in flux
	private int size;
	private char[] whole_Stack;		//used for the display method

	
	public Stack_LL_CHAR()
	{
            top = new Node_LL_CHAR();	
            top.next_Node = null;
            size = 0;	
	} 
	
	
	public int get_Size()
	{
            return size;
	}
	
	
	public boolean is_Empty()
	{
            return (size == 0);		
	}
	
	
	public void push(char new_Data)
	{
            temp_top = new Node_LL_CHAR();
            temp_top.data = new_Data;
            temp_top.next_Node = top;		//Set the pointer to the next node in the new top of the stack
            top = temp_top;					//set the top pointer to the new top
            size++;
	}
	
	
	public char peek()
	{
            return top.data;			
	}
	
	
	public char pop()
	{
		if (!is_Empty())
		{
                    temp_top = top;	
                    top = top.next_Node;	
                    size--;
                    return temp_top.data;	
		} 
		else 
		{
                    return '0';
		}
	}
	
	
//	public String display()
//	{
//		temp_top = top;
//		whole_Stack = new char[size];
//		for (int i = 0; i < size; i++)
//		{
//			whole_Stack[size- 1 - i] = temp_top.data; //subtract i from (size - 1) to achieve correct order displayed
//			temp_top = temp_top.next_Node;
//		}
//		return Arrays.deepToString(whole_Stack);
//	}
//	
}//end class