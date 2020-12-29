
public class TestInterpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SyntaxError {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			System.exit(0);
		}
		InterpreterParser parser = new InterpreterParser();
		InterpreterExpression expr = parser.doParse(args[0]);
		System.out.println("The value of the expression is: " + expr.evaluate());
	}

}
