package stackIntVsGeneric;

/**
 * Unlimited capacity stack (generic)
 * 
 * @author tac
 *
 */
public class StackGeneric<Item> {

    private Item[] contents; // stack elements
    private int top; // index to the top stack

    /**
     * Constructor with default capacity
     */
    public StackGeneric() {
	// It is not permitted to create an Item[]
	// contents = new Item[1]

	// I can create an array of "Object" and then cast
	contents = (Item[]) new Object[1];
	top = -1;
    }

    /**
     * Constructor with a given capacity
     * 
     * @param cap the initial capacity of the stack
     */
    public StackGeneric(int cap) {
	assert (cap > 0);
	contents = (Item[]) new Object[cap];
	top = -1;
    }

    /**
     * The stack is handled dynamically: new memory is allocated if needed
     * 
     * @param e the element to be pushed
     */
    public void push(Item e) {
	if ((top + 1) == contents.length) {
	    // Stack must be resized
	    resize();
	}
	// From here on
	// (top + 1) < contents.length
	top += 1;
	contents[top] = e;
    }

    /**
     * Pop operator
     * 
     * @return the element on the top of the stack (removed)
     */
    public Item pop() {
	assert (top >= 0);
	// With this implementation the popped object
	// would remain active inside contents (no
	// garbage collection would occur)
	// This is called "loitering"
	// int index = top;
	// top -= 1;
	// return contents[index];

	// This implementation avoid loitering
	Item result = contents[top];
	contents[top] = null;
	top -= 1;
	return result;

    }

    /**
     * Top operator
     * 
     * @return the element of the top of the stack (not removed)
     */
    public Item top() {
	assert (top >= 0);
	return contents[top];
    }

    /**
     * test for emptiness
     * 
     * @return true if stack is empty
     */
    public boolean isEmpty() {
	return (top == -1);
    }

    /**
     * Get the size of the stack
     * 
     * @return
     */
    public int getSize() {
	return (top + 1);
    }

    /**
     * Internal method to resize the stack NOTE: the increase in size must follow a
     * geometric progression (for efficiency)
     */
    private void resize() {
	Item[] temp = (Item[]) new Object[contents.length * 2];
	for (int i = 0; i < contents.length; ++i) {
	    temp[i] = contents[i];
	}
	contents = temp;
    }

}
