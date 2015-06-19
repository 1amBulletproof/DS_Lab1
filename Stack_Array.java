/**
*Array-Based Stack ADT
*/
import java.util.Arrays;

public class Stack_Array 
{
	private int array_size = 100; 	//customize how bit the array will be
	private int top;						// point to the 'data' which is at the top of the stack
	private String[] data;					// array to hold the contents of the stack


	
	public Stack_Array()
	{
		top = -1;		
		data = new String[array_size]; 
	} 
        
        public Stack_Array(int size)
        {
            top = -1;
            array_size = size;
            data = new String[array_size];
        }
	
	public int get_MaxSize()
	{
		return (array_size);
	}
        
        public int get_Size()
	{
		return (top+1);
	}
	
	
	public boolean is_Empty()
	{
		return (top == -1);		
	}
	
	
	public boolean is_Full()
	{
		return (top == array_size-1);		//subtract 1 to account for 0 indexing
	}
	
	
	public void push(String new_Data)
	{
		if (!is_Full())
		{
			data[++top] = new_Data;
		}
	}
	
	
	public String peek()
	{
		return data[top];			
	}
	
	
	public String pop()
	{
		String temp;
		
		if (!is_Empty()){
			temp = data[top];	
			data[top] = null;
			top--;		
		} else {
			temp = "ERROR UNDERFLOW:The Stack is EMPTY, you cannot Pop it";
		}
		
		return temp;
	}
	
	
	public String display()
	{
		String[] temp_data = new String[top+1];
		for (int x = 0; x <= top; x++)
		{
			temp_data[x] = data[x];
		}
		return Arrays.deepToString(temp_data);
	}
	
}//end class