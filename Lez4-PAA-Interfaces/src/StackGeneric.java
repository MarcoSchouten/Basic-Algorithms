
import java.util.Iterator;

public class StackGeneric<T> implements Iterable<T> {

    private T[] contents; // stack elements
    private int top; // index to the top stack

    /**
     * Constructor with default capacity
     */
    public StackGeneric() {
	// It is not permitted to create an E[]
	// contents = new E[1]

	// I can create an array of "Object" and then cast
	this.contents = (T[]) new Object[1];
	top = -1;
    }

    /**
     * Constructor with parameters, needed for resize method
     */
    public StackGeneric(int cap) {
	assert (cap > 0);
	contents = (T[]) new Object[cap];
	top = -1;
    }

    /**
     * @param e the element to be pushed into the stack push
     */
    public void push(T e) {
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
     * @return the element on the top of the stack (removed) pop
     */
    public T pop() {
	assert (top >= 0);
	// With this implementation the popped object
	// would remain active inside contents (no
	// garbage collection would occur)
	// This is called "loitering"
	// int index = top;
	// top -= 1;
	// return contents[index];

	// This implementation avoid loitering
	T result = contents[top];
	contents[top] = null;
	top -= 1;
	return result;
    }

    /**
     * @return the element of the top of the stack (not removed) pop (senza
     *         rimuovere)
     */
    public T top() {
	assert (top >= 0);
	return contents[top];
    }

    /**
     * @return true if stack is empty stack è vuoto
     */
    public boolean isEmpty() {
	return (top == -1);
    }

    /**
     * @return the actual size of the stack, not the actual array length
     */
    public int getSize() {
	return (top + 1);
    }

    /**
     * Resize the stack. rialloca lo stack (per 2^k + 1 inserimento)
     */
    private void resize() {
	T[] temp = (T[]) new Object[contents.length * 2];
	for (int i = 0; i < contents.length; ++i) {
	    temp[i] = contents[i];
	}
	contents = temp;
    }

    /**
     * costruisce un oggetto iteratore
     */
    public Iterator<T> iterator() {
	return new Itr();
    }

    /**
     * definisce oggetto iteratore: è un intero(non T), l'indice di uno stack
     * generico ha metotodi : has next next - restituisce l'elemento generico dello
     * stack generico
     */
    private class Itr implements Iterator<T> {
	private int cursor; // index of next element to return

	public Itr() {
	    cursor = 0;

	}

	@Override
	public boolean hasNext() {
	    return (cursor < getSize());
	}

	@Override
	public T next() {
	    T temp = null;
	    if (this.hasNext()) {
		temp = contents[cursor];
		cursor++;
	    }
	    return temp;
	}
    }

}
