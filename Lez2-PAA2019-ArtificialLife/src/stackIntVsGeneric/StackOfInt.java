package stackIntVsGeneric;

public class StackOfInt {
    int[] contents; // valori array
    int top; // puntatore all'ultimo elemento

    StackOfInt(int n) {
	this.contents = new int[n];
	this.top = -1;
    }

    boolean isEmpty() {
	return (this.top < 0);
    }

    boolean isFull() {
	return (this.top == this.contents.length - 1);
    }

    boolean push(int n) {
	if (isFull() == true) {
	    return false;
	} else {
	    this.top = this.top + 1;
	    this.contents[this.top] = n;
	    return true;
	}
    }

    int pop(int n) {
	if (isEmpty() == true) {
	    return -1;
	} else {
	    int x = this.contents[this.top];
	    this.top = this.top - 1;
	    return x;
	}
    }

    int top() {
	if (isEmpty()) {
	    return -1;
	} else {
	    return this.contents[this.top];
	}
    }

    int size() {
	return this.top + 1;
    }

}
