import java.util.HashMap;
import java.util.LinkedList;

public class Interpreter {

    HashMap<String, Double> variables;
    LinkedList<Double> stack;

    public Interpreter() {
	this.variables = new HashMap<String, Double>();
	this.stack = new LinkedList<Double>();
    }

    public void compute(String[] instruction) throws SyntaxError {
	switch (instruction[0]) {
	case "DEF":
	    variables.put(instruction[1], Double.parseDouble(instruction[2]));
	    break;
	case "PUSH" :
	    char[] data = instruction[1].toCharArray();
	    if(Character.isDigit(data[0])) {
		stack.push(Double.parseDouble(instruction[1]));
	    }
	    else {
		if(variables.containsKey(instruction[1]))
		    stack.push(variables.get(instruction[1]));
		else {
		    throw new SyntaxError("errore");
		}
	    }
	    break;
	case "TOP" :
	    if(!stack.isEmpty()) {
		System.out.println(stack.peek());
	    }
	    break;
	case "POP" :
	    if(!stack.isEmpty()) {
		System.out.println(stack.poll());
	    }
	    else {
		    throw new SyntaxError("errore");
		}
	    break;
	case "ADD" :
	    if(stack.size() >= 2) {
		double val1 = stack.poll();
		double val2 = stack.poll();
		stack.push(val1 + val2);
	    }
	    else {
		    throw new SyntaxError("errore");
		}
	    break;
	    
	case "SUB" :
	    if(stack.size() >= 2) {
		double val1 = stack.poll();
		double val2 = stack.poll();
		stack.push(val1 - val2);
	    }
	    else {
		    throw new SyntaxError("errore");
		}
	    break;
	    
	    
	case "MUL" :
	    if(stack.size() >= 2) {
		double val1 = stack.poll();
		double val2 = stack.poll();
		stack.push(val1 * val2);
	    }
	    else {
		    throw new SyntaxError("errore");
		}
	    break;
	    
	    
	case "DIV" :
	    if(stack.size() >= 2) {
		double val1 = stack.poll();
		double val2 = stack.poll();
		stack.push(val1 / val2);
	    }
	    else {
		    throw new SyntaxError("errore");
		}
	    break;
	}
    }
}
