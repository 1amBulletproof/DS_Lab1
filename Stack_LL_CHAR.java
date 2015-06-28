/**
*Linked-List-Based Stack 
* <p> Includes get_size, is_Empty, push, peek, pop, emptyStack methods</p>
* 
* @author Brandon Tarney 
* @version 1.0  6/16/15
*/		

public class Stack_LL_CHAR 
{
    private Node_LL_CHAR top;           // points to the ADT which is at the top of the stack
    private Node_LL_CHAR temp_top;      // for manipulating data in flux
    private int size;

	
    /**
     * Stack Constructor method
     * instantiates the top node and size value of the stack
     */
    public Stack_LL_CHAR()
    {
        top = new Node_LL_CHAR();	
        top.next_Node = null;
        size = 0;	
    } 
	

    /**
     * Gets the size of the stack
     * 
     * @return  size of the stack as an int 
     */
    public int get_Size()
    {
        return size;
    }
	

    /**
     * Tests if the stack is empty
     * 
     * @return  true if size = 0, false otherwise 
     */
    public boolean is_Empty()
    {
        return (size == 0);		
    }
	
	
    /**
     * Pushes new value onto stack
     * 
     * @param new_Data  value to be pushed onto stack
     */
    public void push(char new_Data)
    {
        temp_top = new Node_LL_CHAR();
        temp_top.data = new_Data;
        temp_top.next_Node = top;	//Set the pointer to the next node in the new top of the stack
        top = temp_top;			//set the top pointer to the new top
        size++;
    }
	
	
    /**
     * See what is on top of the stack
     * 
     * @return  data on top of the stack in the form of a CHAR
     */
    public char peek()
    {
        return top.data;			
    }
	
	
    /**
     * Delete the top item from the stack and return its value
     * 
     * @return  data on top of the stack in the form of a CHAR
     */
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

    
    /**
     * Delete all data from the stack
     */
    public void emptyStack()
    {
        while (!is_Empty())
        {
            pop();
        }
    }
	
}//end class