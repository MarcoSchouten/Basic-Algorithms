public class InterpreterParser {

    public static final String OPERATORS = "+-*/";

    private InterpreterExpression expression;

    public InterpreterParser() {
	expression = null;
    }

    public InterpreterExpression doParse(String text) throws SyntaxError {

	int i = doRecursiveParse(text, 0);
	if (i < text.length()) {
	    throw new SyntaxError("Garbage at the end of text");
	}

	return expression;
    }

    private int doRecursiveParse(String text, int i) throws SyntaxError {
	if (Character.isDigit(text.charAt(i))) {
	    return doParseNumber(text, i);
	} else if (text.charAt(i) == '(') {
	    i = doRecursiveParse(text, i + 1);
	    InterpreterExpression left = expression;
	    /*if (i >= text.length()) {
	    	throw new SyntaxError("Premature end of input");
	    } else if (OPERATORS.indexOf(text.charAt(i)) < 0) {
	    	throw new SyntaxError("Unrecognized operator at position: " + i);
	    }*/

	    InterpreterOperator.OpCode op = InterpreterOperator.charToCode(text.charAt(i));

	    i = doRecursiveParse(text, i + 1);
	    InterpreterExpression right = expression;
	    /*if (i >= text.length()) {
	    throw new SyntaxError("Premature end of input");
	    } else if (text.charAt(i) != ')') {
	    throw new SyntaxError("Unbalanced parenthesis at position: " + i);
	    }*/
	    expression = new InterpreterOperator(op, left, right);
	    return (i + 1);
	} else {
	    throw new SyntaxError("Illegal token at position: " + i);
	}
    }

    private int doParseNumber(String text, int i) {
	int j = i;
	while (j < text.length() && Character.isDigit(text.charAt(j))) {
	    j = j + 1;
	}
	String numAsText = text.substring(i, j);
	expression = new InterpreterOperand(Integer.parseInt(numAsText));
	return j;
    }

}
