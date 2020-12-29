
public class InterpreterOperator implements InterpreterExpression {

	public enum OpCode { ADD, SUB, MUL, DIV, NOP };
	
	public OpCode                operator;
	public InterpreterExpression left;
	public InterpreterExpression right;
	
	public InterpreterOperator(OpCode op, InterpreterExpression left, InterpreterExpression right) {
		this.operator = op;
		this.left = left;
		this.right = right;
	}
	
	public int evaluate() {
		switch (operator) {
		case ADD :
			return left.evaluate() + right.evaluate();
		case SUB :
			return left.evaluate() - right.evaluate();
		case MUL :
			return left.evaluate() * right.evaluate();
		case DIV :
			return left.evaluate() / right.evaluate();
		default:
			return 0;
		}
	}
	
	public static OpCode charToCode(char ch) {
		switch (ch) {
		case '+' : return OpCode.ADD;
		case '-' : return OpCode.SUB;
		case '*' : return OpCode.MUL;
		case '/' : return OpCode.DIV;
		default : return OpCode.NOP;
		}
	}
	
}
