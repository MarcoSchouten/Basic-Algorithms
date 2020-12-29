
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

	// Creating an empty Stack
	StackGeneric<String> stack = new StackGeneric<String>();

	// Use add() method to add elements into the Stack
	stack.push("Welcome");
	stack.push("To");
	stack.push("Geeks");
	stack.push("4");
	stack.push("Geeks");

	// Metodo esplicito
	Iterator<String> i = stack.iterator();
	System.out.println("The iterator values are: ");
	while (i.hasNext()) {
	    String s = i.next();
	    System.out.println(s);
	}

	// Metodo implicito
	for (String s : stack) {
	    System.out.print(s);
	}
    }

}
